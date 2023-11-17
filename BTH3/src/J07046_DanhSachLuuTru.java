
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Khach implements Comparable<Khach>{
    private String ma, ten, phong;
    private Date den, di;
    private long ngay;
    static int stt = 1;
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    public Khach(String ten, String phong, String den, String di) throws ParseException {
        this.ma = String.format("KH%02d", stt++);
        this.ten = ten;
        this.phong = phong;
        this.den = df.parse(den);
        this.di = df.parse(di);
        ngay = (this.di.getTime() - this.den.getTime()) / (long)(1000 * 60 * 60 * 24);
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getPhong() {
        return phong;
    }

    public Date getDen() {
        return den;
    }

    public Date getDi() {
        return di;
    }

    public static int getStt() {
        return stt;
    }

    public SimpleDateFormat getDf() {
        return df;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public void setDen(Date den) {
        this.den = den;
    }

    public void setDi(Date di) {
        this.di = di;
    }

    public static void setStt(int stt) {
        Khach.stt = stt;
    }

    public void setDf(SimpleDateFormat df) {
        this.df = df;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + phong + " " + ngay;
    }

    public long getNgay() {
        return ngay;
    }

    @Override
    public int compareTo(Khach o) {
        return (int) (o.ngay - this.ngay);
    }
    
}
public class J07046_DanhSachLuuTru {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("KHACH.in"));
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<Khach> arr = new ArrayList<>();
        while(t --> 0){
            Khach x = new Khach(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            arr.add(x);
        }
        Collections.sort(arr);
        for(Khach i: arr)
        {
            System.out.println(i);
        }
    }
}
