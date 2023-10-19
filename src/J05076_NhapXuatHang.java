
import java.util.*;
import java.util.Scanner;

class Hang2{
    private String ma, ten;
    private char loai;
    private long nhap, xuat, gia;

    public void setNhap(long nhap) {
        this.nhap = nhap;
    }

    public void setXuat(long xuat) {
        this.xuat = xuat;
    }

    public String getMa() {
        return ma;
    }

    public void setGia(long gia) {
        this.gia = gia;
    }
    public Hang2(String ma, String ten, char loai) {
        this.ma = ma;
        this.ten = ten;
        this.loai = loai;
    }
    public long giaXuat(){
        if(loai == 'A') return gia * xuat * 8 / 100 + gia * xuat;
        else if(loai == 'B') return gia * xuat * 5 / 100 + gia * xuat;
        return gia * xuat * 2 / 100 + gia * xuat;
    }
    public String toString(){
        return ma + " " + ten + " " + gia * nhap + " " + giaXuat();
    }
}
public class J05076_NhapXuatHang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Hang2> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            Hang2 x = new Hang2(sc.nextLine(), sc.nextLine(), sc.nextLine().charAt(0));
            arr.add(x);
        }
        int m = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < m; i++){
            String[] x = sc.nextLine().split(" ");
            for(Hang2 j: arr)
                if(j.getMa().equals(x[0])){
                    j.setNhap(Long.parseLong(x[1]));
                    j.setGia(Long.parseLong(x[2]));
                    j.setXuat(Long.parseLong(x[3]));
                    System.out.println(j);
                    break;
                }
        }
    }
}
