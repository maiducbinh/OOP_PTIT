
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Phong{
    private String ma, ten;
    private double gia, phi;

    public Phong(String ma, String ten, double gia, double phi) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.phi = phi;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public double getGia() {
        return gia;
    }

    public double getPhi() {
        return phi;
    }
    
}

class KH{
    private String ma, ten, maPhong;
    private Date den, di;
    private Phong phong;
    private long ngay;
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    static int stt = 1;
    public KH(String ten, String maPhong, String den, String di) throws ParseException {
        this.ten = ten;
        this.maPhong = maPhong;
        this.den = df.parse(den);
        this.di = df.parse(di);
        this.ma = String.format("KH%02d", stt++);
        this.ngay = (this.di.getTime() - this.den.getTime()) / ((long)1000 * 60 * 60 * 24);
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    public long getNgay() {
        return ngay;
    }

    public String getMaPhong() {
        return maPhong.substring(2, 3);
    }
    public double giamGia(){
        if(ngay < 10) return 0;
        else if(ngay < 20) return 0.02;
        else if(ngay < 30) return 0.04;
        return 0.06;
    }
    public double tinhTien(){
        long day = ngay;
        if(ngay == 0) day = 1;
        double tong = day * phong.getGia() * (1 + phong.getPhi());
        return tong * (1 - giamGia());
    }
    public String toString(){
        return ma + " " + ten + " " + maPhong + " " + ngay + " " + String.format("%.2f", tinhTien());
    }
}
public class J07047_QuanLyKhachSan {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("DATA.in"));
        ArrayList<Phong> a = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            // Loi: IR do nhap, hien sai ngay
            String s[] = sc.nextLine().split(" ");
            Phong x = new Phong(s[0], s[1], Double.parseDouble(s[2]), Double.parseDouble(s[3]));
            a.add(x);
        }
        ArrayList<KH> b = new ArrayList<>();
        int m = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < m; i++){
            KH x = new KH(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            for(Phong j: a)
                if(x.getMaPhong().equals(j.getMa())){
                    x.setPhong(j);
                }
            b.add(x);
        }
        b.sort(Comparator.comparing(KH::getNgay).reversed());
        for(KH i: b)
        {
            System.out.println(i);
        }
        
    }
}
