
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class SV{
    private String ma, ten, sdt, btl;
    private int nhom;

    public SV(String ma, String ten, String sdt, int stt) {
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
        this.nhom = stt;
    }

    public void setBtl(String btl) {
        this.btl = btl;
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
        return ma + " " + ten + " " + sdt + " " + nhom + " " + btl; 
    }
}
public class J06004_QuanLyBaiTapNhom2 {
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
            for(SV j: a)
                if(j.getNhom() == i + 1)
                    j.setBtl(s);
        }
        a.sort(Comparator.comparing(SV::getMa));
        for(SV i: a)
            System.out.println(i);
    }
}
