
import java.util.Scanner;

class GiaoVien{
    private String ma, ten;
    private long luong;

    GiaoVien(String ma, String ten, long luong) {
        this.ma = ma;
        this.ten = ten;
        this.luong = luong;
    }
    
    public long phuCap(){
        String t = ma.substring(0, 2);
        if(t.equals("HT")) return (long)2e6;
        else if(t.equals("HP")) return (long)9e5;
        else return (long)5e5;
    }
    public String chucVu()
    {
        return ma.substring(0, 2);
    }
    public long bacLuong(){
        String t = ma.substring(2);
        return (t.charAt(0) - '0') * 10 + (t.charAt(1) - '0');
    }
    public long thuNhap()
    {
        return luong * bacLuong() + phuCap();
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + bacLuong() + " " + phuCap() + " " + thuNhap();
    }
    
    
}
public class J04015_KhaiBaoLopVaDoiTuong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GiaoVien a = new GiaoVien(sc.nextLine(), sc.nextLine(), sc.nextLong());
        System.out.println(a);
    }
}
