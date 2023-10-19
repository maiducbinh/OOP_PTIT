
import java.util.Scanner;

class NhanVien{
    private String ma, ten, chuVu;
    private long luong, ngay;
    NhanVien(String ten, long luong, long ngay, String chucVu){
        this.ma = "NV01";
        this.ten = ten;
        this.luong = luong;
        this.ngay = ngay;
        this.chucVu = chucVu;
        this.luong = luong * ngay;
    }
    public long thuong(){
        if(ngay >= 25) return luong / 5;
        else if(ngay >= 22) return luong / 10;
        else return 0;
    }
    /*
    GD: 250000  
PGD: 200000 
TP: 180000
NV: 150000
    */
    public long phuCap(){
        if(chucVu.equals("GD")) return 250000;
        else if(chucVu.equals("PGD")) return 200000;
        else if(chucVu.equals("TP")) return 180000;
        else return 150000;
    }
    public String toString(){
        return ma + " " + ten + " " + luong + " " + thuong() + " " + phuCap() + " " + (luong + thuong() + phuCap());
    }
}
public class J04012_BaiToanTinhCong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NhanVien x = new NhanVien(sc.nextLine(), Long.parseLong(sc.nextLine()), Long.parseLong(sc.nextLine()), sc.nextLine());
        System.out.println(x);
    }
}
