
import java.util.Scanner;

class Staff{
    private String ten, chucVu, ma;
    private long luongNgay, ngay;
    static int stt = 1;
    static long tong = 0;
    public Staff(String ten, long luongNgay, long ngay, String chucVu) {
        this.ma = String.format("NV%02d", stt++);
        this.ten = ten;
        this.chucVu = chucVu;
        this.luongNgay = luongNgay;
        this.ngay = ngay;
    }
    public long luongThang(){
        return luongNgay * ngay;
    }
    public long thuong(){
        if(ngay >= 25) return luongThang() * 20 / 100;
        else if(ngay >= 22) return luongThang() * 10 / 100;
        return 0;
    }
    /*
    Nếu chức vụ là GD: 250000  
PGĐ: 200000 
TP:180000
NV: 150000    
    */
    public long phuCap(){
        if(chucVu.equals("GD")) return 250000;
        else if(chucVu.equals("PGD")) return 200000;
        else if(chucVu.equals("TP")) return 180000;
        return 150000;
    }

    @Override
    public String toString() {
        long linh = luongThang() + thuong() + phuCap();
        tong += linh;
        return ma + " " + ten + " " + luongThang() + " " + thuong() + " " + phuCap() + " " + linh;
    }
    
}
public class J05038_BangKeTienLuong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while(n-->0){
            Staff x = new Staff(sc.nextLine(), Long.parseLong(sc.nextLine()), Long.parseLong(sc.nextLine()), sc.nextLine());
            System.out.println(x);
        }
        System.out.println("Tong chi phi tien luong: " + Staff.tong);
    }
}
