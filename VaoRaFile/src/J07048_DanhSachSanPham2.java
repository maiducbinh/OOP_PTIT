
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class SanPham implements Comparable<SanPham>{
    private String ma, ten;
    private int gia, han;

    public SanPham(String ma, String ten, int gia, int han) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.han = han;
    }

    public String getMa() {
        return ma;
    }

    public int getGia() {
        return gia;
    }

    @Override
    // Loi: sort sai
    public int compareTo(SanPham t) {
        if(this.gia != t.getGia())
            return t.getGia() - this.gia;
        return this.ma.compareTo(t.getMa());
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + gia + " " + han;
    }
    
}
public class J07048_DanhSachSanPham2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SANPHAM.in"));
        //Scanner sc = new Scanner(System.in);
        ArrayList<SanPham> a = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++)
        {
            SanPham x = new SanPham(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()));
            a.add(x);
        }
        Collections.sort(a);
        for(SanPham i: a)
            System.out.println(i);
    }  
}
