
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

// Quan he N - N => tach 3 quan he

class Mon{
    private String ma, ten;
    private int tc;
    private double diem;

    public Mon(String ma, String ten, int tc) {
        this.ma = ma;
        this.ten = ten;
        this.tc = tc;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public int getTc() {
        return tc;
    }

    public double getDiem() {
        return diem;
    }
    
}

class SV{
    private String ma, ten, lop, email;

    public SV(String ma, String ten, String lop, String email) {
        this.ma = ma;
        this.ten = chuanHoa(ten);
        this.lop = lop;
        this.email = email;
    }
    public String chuanHoa(String s){
        String x[] = s.trim().toLowerCase().split("\\s+");
        String ans = "";
        for(String i: x)
            ans += i.substring(0, 1).toUpperCase() + i.substring(1) + " ";
        return ans.trim();
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

    public String getEmail() {
        return email;
    }
    
    public String toString(){
        return ma + " " + ten + " " + lop;
    }
}

class Diem{
    private SV sv;
    private Mon mon;
    private double diem;

    public Diem(SV sv, Mon mon, double diem) {
        this.sv = sv;
        this.mon = mon;
        this.diem = diem;
    }

    public SV getSv() {
        return sv;
    }

    public Mon getMon() {
        return mon;
    }

    public double getDiem() {
        return diem;
    }
    
    // Loi: ep kieu va dau cach
    public String toString(){
        String d = "";
        if(diem == (int)diem) d += (int)diem;
        else d += diem;
        return sv + " " + d;
    }
}
public class J07035_BangDiemTheoMonHoc {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File("SINHVIEN.in"));
        ArrayList<SV> a = new ArrayList<>();
        int n = Integer.parseInt(sc1.nextLine());
        for(int i = 0; i < n; i++){
            SV x = new SV(sc1.nextLine(), sc1.nextLine(), sc1.nextLine(), sc1.nextLine());
            a.add(x);
        }
        Scanner sc2 = new Scanner(new File("MONHOC.in"));
        int m = Integer.parseInt(sc2.nextLine());
        ArrayList<Mon> b = new ArrayList<>();
        for(int i = 0; i < m; i++){
            Mon x = new Mon(sc2.nextLine(), sc2.nextLine(), Integer.parseInt(sc2.nextLine()));
            b.add(x);
        }
        a.sort(Comparator.comparing(SV::getMa));
        Scanner sc3 = new Scanner(new File("BANGDIEM.in"));
        int k = Integer.parseInt(sc3.nextLine());
        ArrayList<Diem> c = new ArrayList<>();
        for(int i = 0; i < k; i++){
            String[] s = sc3.nextLine().split(" ");
            for(SV x: a)
                for(Mon y: b){
                    if(x.getMa().equals(s[0]) && y.getMa().equals(s[1])){
                        Diem z = new Diem(x, y, Double.parseDouble(s[2]));
                        c.add(z);
                    }
                }
        }
        c.sort(Comparator.comparing(Diem::getDiem).reversed());
        int q = Integer.parseInt(sc3.nextLine());
        while(q-->0){
            String ma = sc3.nextLine();
            for(Mon i: b)
                if(i.getMa().equals(ma))
                {
                    System.out.println("BANG DIEM MON " + i.getTen() + ":");
                    break;
                }
            for(Diem i: c)
                if(i.getMon().getMa().equals(ma))
                {
                    System.out.println(i);
                }
        }
    }
}
