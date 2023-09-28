
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class SinhVien implements Comparable<SinhVien>{
    private String ma, hoTen, sdt, email;
    private String ho, dem, ten;
    public SinhVien(String ma, String ten, String sdt, String email) {
        this.ma = ma;
        this.hoTen = ten;
        this.sdt = sdt;
        this.email = email;
        String[] a = ten.split("\\s+");
        this.ten = a[a.length - 1];
        this.ho = a[0];
        this.dem = "";
        for(int i = 1; i < a.length - 1; i++)
            this.dem += a[i];
    }
    public String toString(){
        return ma + " " + hoTen + " " + sdt + " " + email;
    }
    @Override
    public int compareTo(SinhVien o) {
        if(!this.ten.equals(o.ten)){
            return this.ten.compareTo(o.ten);
        }
        else if(!this.ho.equals(o.ho)){
            return this.ho.compareTo(o.ho);
        }
        else if(!this.dem.equals(o.dem))
            return this.dem.compareTo(o.dem);
        return this.ma.compareTo(o.ma);
    }
    
}
public class J07081_SapXepDanhSachSinhVien {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        //Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<SinhVien> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            SinhVien x = new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            arr.add(x);
        }
        Collections.sort(arr);
        for(SinhVien i: arr)
            System.out.println(i);
    }
}
