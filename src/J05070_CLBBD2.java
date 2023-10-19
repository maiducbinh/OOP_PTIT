
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Club2{
    private String ma, ten, maTran;
    private long gia, num;

    public Club2(String ma, String ten, long gia) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
    }

    public String getMa() {
        return ma;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public void setMaTran(String maTran) {
        this.maTran = maTran;
    }

    public String getTen() {
        return ten;
    }

    public String getMaTran() {
        return maTran;
    }

    public long getGia() {
        return gia;
    }

    public long getNum() {
        return num;
    }
    public long doanhThu(){
        return gia * num;
    }
    public String toString(){
        return maTran + " " + ten + " " + gia * num;
    }
}
public class J05070_CLBBD2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Club2> arr = new ArrayList<>();
        while(n-->0){
            Club2 x = new Club2(sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine()));
            arr.add(x);
        }
        int m = Integer.parseInt(sc.nextLine());
        while(m-->0){
            String[] x = sc.nextLine().split(" ");
            String maTran = x[0];
            int num = Integer.parseInt(x[1]);
            for(Club2 i: arr){
                if(i.getMa().equals(maTran.subSequence(1, 3))){
                    i.setMaTran(maTran);
                    i.setNum(num);
                }
            }
        }
        arr.sort(Comparator.comparing(Club2::doanhThu).reversed().thenComparing(Club2::getTen));
        for(Club2 i: arr)
            System.out.println(i);
    }
}
