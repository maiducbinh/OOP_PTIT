
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Mon{
    private String ma, ten;
    private int credit;

    public Mon(String ma, String ten, int credit) {
        this.ma = ma;
        this.ten = ten;
        this.credit = credit;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public int getCredit() {
        return credit;
    }
    
}

class Nhom{
    private String nhom, mon;
    private int ngay, kip;
    private String gv, phong;
    static int stt = 1;

    public Nhom(String ma, int ngay, int kip, String gv, String phong) {
        this.mon = ma;
        this.ngay = ngay;
        this.kip = kip;
        this.gv = gv;
        this.phong = phong;
        this.nhom = String.format("HP%03d", stt++);
    }

    public String getNhom() {
        return nhom;
    }

    public String getMon() {
        return mon;
    }

    public int getNgay() {
        return ngay;
    }

    public int getKip() {
        return kip;
    }

    public String getGv() {
        return gv;
    }

    public String getPhong() {
        return phong;
    }

    public static int getStt() {
        return stt;
    }
    
    public String toString(){
        return nhom + " " + ngay + " " + kip + " " + gv + " " + phong;
    }
    
}
public class J07074_LichGiangDayTheoMonHoc {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File("MONHOC.in"));
        int n = Integer.parseInt(sc1.nextLine());
        ArrayList<Mon> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            Mon x = new Mon(sc1.nextLine(), sc1.nextLine(), Integer.parseInt(sc1.nextLine()));
            arr.add(x);
        }
        Scanner sc2 = new Scanner(new File("LICHGD.in"));
        int m = Integer.parseInt(sc2.nextLine());
        ArrayList<Nhom> b = new ArrayList<>();
        for(int i = 0; i < m; i++){
            Nhom x = new Nhom(sc2.nextLine(), Integer.parseInt(sc2.nextLine()), Integer.parseInt(sc2.nextLine()), sc2.nextLine(), sc2.nextLine());
            b.add(x);
        }
        String ma = sc2.nextLine();
        for(Mon i: arr)
            if(i.getMa().equals(ma))
            {
                System.out.println("LICH GIANG DAY MON " + i.getTen() + ":");
                break;
            }
        b.sort(Comparator.comparing(Nhom::getNgay).thenComparing(Nhom::getKip));
        for(Nhom i: b)
            if(i.getMon().equals(ma))
                System.out.println(i);
        
    }
}
