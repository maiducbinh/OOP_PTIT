import java.util.ArrayList;
import java.util.Scanner;

class SV1{
    private String ma, ten, lop, dd;
    private int diem;
    public SV1(String ma, String ten, String lop) {
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
public class J05075_DiemDanh2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<SV1> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            SV1 x = new SV1(sc.nextLine(), sc.nextLine(), sc.nextLine());
            arr.add(x);
        }
        for(int i = 0; i < n; i++){
            String[] x = sc.nextLine().split(" ");
            for(SV1 j: arr)
                if(j.getMa().equals(x[0])) j.setDd(x[1]);
        }
        String lop = sc.nextLine();
        for(SV1 i: arr)
            if(i.getLop().equals(lop))
            System.out.println(i);
    }
}
