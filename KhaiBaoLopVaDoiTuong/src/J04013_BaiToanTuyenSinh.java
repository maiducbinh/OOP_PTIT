
import java.util.Scanner;

class ThiSinh{
    private String ma, ten;
    private double toan, li, hoa, tong;
    ThiSinh(String ma, String ten, double toan, double li, double hoa){
        this.ma = ma;
        this.ten = ten;
        this.toan = toan;
        this.li = li;
        this.hoa = hoa;
    }
    public double diemUuTien(){
        String s = this.ma.substring(0, 3);
        if(s.equals("KV1")) return 0.5;
        else if(s.equals("KV2")) return 1;
        else return 2.5;
    }
    public String toString(){
        String ans = "";
        if(diemUuTien() == (int)diemUuTien())
            ans += String.format("%.0f", diemUuTien()) + " ";
        else ans += String.format("%.1f", diemUuTien()) + " ";
        tong = toan * 2 + li + hoa;
        if(tong == (int)tong)
            ans += String.format("%.0f", tong);
        else ans += String.format("%.1f", tong);
        String kq;
        if(tong + diemUuTien() >= 24) kq = "TRUNG TUYEN";
        else kq = "TRUOT";
        
        return ma + " " + ten + " " + ans + " " + kq;
    }
}
public class J04013_BaiToanTuyenSinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ThiSinh x = new ThiSinh(sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()));
        System.out.println(x);
    }
}
