
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class NhanVien implements Comparable<NhanVien>{
    private String ma, ten, gioiTinh, dob, addr, thue, hd;
    private int ngay, thang, nam;
    static int stt = 1;
    public NhanVien(Scanner sc) {
        this.ma = String.format("%05d", stt++);
        this.ten = sc.nextLine();
        this.gioiTinh = sc.nextLine();
        this.dob = sc.nextLine();
        this.addr = sc.nextLine();
        this.thue = sc.nextLine();
        this.hd = sc.nextLine();
        String[] a = this.dob.split("/");
        this.ngay = Integer.parseInt(a[0]);
        this.thang = Integer.parseInt(a[1]);
        this.nam = Integer.parseInt(a[2]);
    }
    
    @Override
    public String toString() {
        return ma + " " + ten + " " + gioiTinh + " " + dob + " " + addr + " " + thue + " " + hd;
    }

    @Override
    public int compareTo(NhanVien t) {
        if(this.nam != t.nam){
            return (this.nam - t.nam); 
        }
        else if(this.thang != t.thang){
            return this.thang - t.thang;
        }
        return this.ngay - t.ngay;
    }
    
}
public class J05007_SXNV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<NhanVien> arr = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            NhanVien x = new NhanVien(sc);
            arr.add(x);
        }
        Collections.sort(arr);
        for(NhanVien i: arr)
            System.out.println(i);
    }
}
