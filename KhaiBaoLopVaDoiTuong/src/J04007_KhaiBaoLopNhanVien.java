
import java.util.Scanner;

class NhanVien{
    String ma, ten, gioiTinh, dob, address, maThue, ngayKi;

    NhanVien(String ten, String gioiTinh, String dob, String address, String maThue, String ngayKi) {
        this.ma = "00001";
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.dob = dob;
        this.address = address;
        this.maThue = maThue;
        this.ngayKi = ngayKi;
    }

    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " + this.gioiTinh + " " + this.dob + " " + this.address + " " + this.maThue + " " + this.ngayKi;
    }
    
}
public class J04007_KhaiBaoLopNhanVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Note: su dung toan bo la nextLine, ko nen xe ke next()
        String ten = sc.nextLine();
        String gioiTinh = sc.nextLine();
        String dob = sc.nextLine();
        String addr = sc.nextLine();
        String thue = sc.nextLine();
        String ngay = sc.nextLine();
        NhanVien a = new NhanVien(ten, gioiTinh, dob, addr, thue, ngay);
        System.out.println(a);
    }
}
