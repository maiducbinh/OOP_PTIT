
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Mon{
    private String ma, ten, hinhThuc;

    public Mon(String ma, String ten, String hinhThuc) {
        this.ma = ma;
        this.ten = ten;
        this.hinhThuc = hinhThuc;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getHinhThuc() {
        return hinhThuc;
    }
    
}

class Ca{
    private String ma, ngay, gio, phong;
    static int stt = 1;
    public Ca(String ngay, String gio, String phong) {
        this.ngay = ngay;
        this.gio = gio;
        this.phong = phong;
        this.ma = String.format("C%03d", stt++);
    }

    public String getMa() {
        return ma;
    }

    public String getNgay() {
        return ngay;
    }

    public String getGio() {
        return gio;
    }

    public String getPhong() {
        return phong;
    }

    public static int getStt() {
        return stt;
    }
    
    
}
class Lich{
    private String ma, nhom;
    private Ca ca;
    private Mon mon;
    private int num;
    public Lich(Ca ca, Mon mon, String nhom, int num) {
        this.ca = ca;
        this.mon = mon;
        this.num = num;
        this.nhom = nhom;
    }

    public String getMa() {
        return ma;
    }

    public String getNhom() {
        return nhom;
    }

    public Ca getCa() {
        return ca;
    }

    public Mon getMon() {
        return mon;
    }

    public int getNum() {
        return num;
    }
    public String toString(){
        return ca.getNgay() + " " + ca.getGio() + " " + ca.getPhong() + " " + mon.getTen() + " " + nhom + " " + num;
    }
    
    
}
public class J07060_SapXepLichThi {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File("MONTHI.in"));
        int n = Integer.parseInt(sc1.nextLine());
        ArrayList<Mon> a = new ArrayList<>();
        for(int i = 0; i < n; i++){
            Mon x = new Mon(sc1.nextLine(), sc1.nextLine(), sc1.nextLine());
            a.add(x);
        }
        ArrayList<Ca> b = new ArrayList<>();
        Scanner sc2 = new Scanner(new File("CATHI.in"));
        int m = Integer.parseInt(sc2.nextLine());
        for(int i = 0; i < m; i++){
            Ca x = new Ca(sc2.nextLine(), sc2.nextLine(), sc2.nextLine());
            b.add(x);
        }
        ArrayList<Lich> c = new ArrayList<>();
        Scanner sc3 = new Scanner(new File("LICHTHI.in"));
        int k = Integer.parseInt(sc3.nextLine());
        for(int i = 0; i < k; i++){
            String s[] = sc3.nextLine().split(" ");
            for(Mon x: a)
                for(Ca y: b)
                    if(x.getMa().equals(s[1]) && y.getMa().equals(s[0])){
                        Lich z = new Lich(y, x, s[2], Integer.parseInt(s[3]));
                        c.add(z);
                    }
        }
        Collections.sort(c, new Comparator<Lich>(){
            @Override
            public int compare(Lich x, Lich y) {
                if(!x.getCa().getNgay().equals(y.getCa().getNgay()))
                    return x.getCa().getNgay().compareTo(y.getCa().getNgay());
                else if(!x.getCa().getGio().equals(y.getCa().getGio()))
                    return x.getCa().getGio().compareTo(y.getCa().getGio());
                return x.getCa().getMa().compareTo(y.getCa().getMa());
            }
            
        });
        for(Lich i: c)
        {
            System.out.println(i);
        }
    }
}
