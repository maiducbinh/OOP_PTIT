
import java.util.ArrayList;
import java.util.Scanner;

class SV{
    private String ma, ten, sdt;
    private int nhom;

    public SV(String ma, String ten, String sdt, int stt) {
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
        this.nhom = stt;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getSdt() {
        return sdt;
    }

    public int getNhom() {
        return nhom;
    }
    
    public String toString(){
        return ma + " " + ten + " " + sdt; 
    }
}
public class J06003_QuanLyBaiTapNhom1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        ArrayList<SV> a = new ArrayList<>();
        for(int i = 0; i < n; i++){
            SV x = new SV(sc.nextLine(), sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()));
            a.add(x);
        }
        ArrayList<String> b = new ArrayList<>();
        for(int i = 0; i < m; i++){
            String s = sc.nextLine();
            b.add(s);
        }
        int q = Integer.parseInt(sc.nextLine());
        while(q-->0){
            int nhom = Integer.parseInt(sc.nextLine());
            System.out.println("DANH SACH NHOM " + nhom + ":");
            for(SV i: a)
                if(i.getNhom() == nhom)
                {
                    System.out.println(i);
                }
            System.out.println("Bai tap dang ky: " + b.get(nhom - 1));
        }
    }
}
