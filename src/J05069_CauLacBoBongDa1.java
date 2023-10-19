
import java.util.ArrayList;
import java.util.Scanner;

class Club{
    private String ma, ten, maTran;
    private long gia, num;

    public Club(String ma, String ten, long gia) {
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
    public String toString(){
        return maTran + " " + ten + " " + gia * num;
    }
}
public class J05069_CauLacBoBongDa1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Club> arr = new ArrayList<>();
        while(n-->0){
            Club x = new Club(sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine()));
            arr.add(x);
        }
        int m = Integer.parseInt(sc.nextLine());
        while(m-->0){
            String[] x = sc.nextLine().split(" ");
            String maTran = x[0];
            int num = Integer.parseInt(x[1]);
            for(Club i: arr){
                if(i.getMa().equals(maTran.subSequence(1, 3))){
                    System.out.println(maTran + " " + i.getTen() + " " + i.getGia() * num);
                }
            }
        }
    }
}
