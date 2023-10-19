
import java.util.ArrayList;
import java.util.Scanner;

class SV{
    private String ma, ten, lop, dd;
    private int diem;
    public SV(String ma, String ten, String lop) {
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getLop() {
        return lop;
    }

    public void setDd(String dd) {
        this.dd = dd;
    }
    public int diemCC(){
        int sum = 10;
        for(char i: dd.toCharArray())
            if(i == 'm') sum -= 1;
            else if(i == 'v') sum -= 2;
        return sum;
    }
    public String toString(){
        diem = diemCC();
        String note = "";
        if(diem < 0) diem = 0;
        if(diem == 0) note = "KDDK";
        return ma + " " + ten + " " + lop + " " + diem + " " + note;
    }
}
public class J05074_DiemDanh1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<SV> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            SV x = new SV(sc.nextLine(), sc.nextLine(), sc.nextLine());
            arr.add(x);
        }
        for(int i = 0; i < n; i++){
            String[] x = sc.nextLine().split(" ");
            for(SV j: arr)
                if(j.getMa().equals(x[0])) j.setDd(x[1]);
        }
        for(SV i: arr)
            System.out.println(i);
    }
}
