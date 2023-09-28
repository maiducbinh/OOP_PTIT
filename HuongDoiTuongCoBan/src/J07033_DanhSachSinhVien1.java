
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class SinhVien implements Comparable<SinhVien>{
    private String ma, ten, lop, mail;

    public SinhVien(String ma, String ten, String lop, String mail) {
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
        this.mail = mail;
    }
    public String chuanHoa(String x){
        String[] a = x.trim().split("\\s+");
        String ans = "";
        for(String i: a)
            ans += i.substring(0, 1).toUpperCase() + i.substring(1).toLowerCase() + " ";
        return ans;
    }
    public String getMa() {
        return ma;
    }
    
    @Override
    public int compareTo(SinhVien t) {
        return this.ma.compareTo(t.getMa());
    }

    @Override
    public String toString() {
        return ma + " " + chuanHoa(ten) + " " + lop + " " + mail;
    }
    
}
public class J07033_DanhSachSinhVien1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        ArrayList<SinhVien> a = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++)
        {
            SinhVien x = new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            a.add(x);
        }
        Collections.sort(a);
        for(SinhVien i: a)
            System.out.println(i);
    }
}
