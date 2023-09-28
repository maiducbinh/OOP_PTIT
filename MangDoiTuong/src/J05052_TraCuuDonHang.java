
import java.util.Scanner;

class MatHang{
    private String ten, ma;
    private long gia, luong;
    MatHang(String ten, String ma, long gia, long luong){
        this.ten = ten;
        this.ma = ma;
        this.gia = gia;
        this.luong = luong;
    }
    public String soThuTu(){
        return ma.substring(1, 4);
    }
    public long giamGia(){
        if(ma.charAt(4) == '1')
            return gia * luong / 2;
        else return gia * luong * 30 / 100;
    }
    public long thanhTien(){
        return gia * luong - giamGia();
    }
    public String toString(){
        return ten + " " + ma + " " + soThuTu() + " " + giamGia() + " " + thanhTien();
    }
}
public class J05052_TraCuuDonHang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while(n-->0){
            MatHang x = new MatHang(sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine()), Long.parseLong(sc.nextLine()));
            System.out.println(x);
        }
    }
}
