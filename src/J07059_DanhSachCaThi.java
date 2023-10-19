
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Thi implements Comparable<Thi>{
    private String ma, ngay, gio, phong;
    private int d, mo, y, h, m;
    static int stt = 1;
    public Thi(String ngay, String gio, String phong) {
        this.ma = String.format("C%03d", stt++);
        this.ngay = ngay;
        this.gio = gio;
        this.phong = phong;
        String[] a = this.ngay.split("/");
        this.d = Integer.parseInt(a[0]);
        this.mo = Integer.parseInt(a[1]);
        this.y = Integer.parseInt(a[2]);
        String[] b = this.gio.split(":");
        this.h = Integer.parseInt(b[0]);
        this.m = Integer.parseInt(b[1]);
    }
    
    @Override
    public int compareTo(Thi o) {
        if(this.y != o.y){
            return -(o.y - this.y);
        }
        else if(this.mo != o.mo){
            return -(o.mo - this.mo);
        }
        else if(this.d != o.d){
            return -(o.d - this.d);
        }
        else if(this.h != o.h)
            return -o.h + this.h;
        return -o.m + this.m;
    }

    @Override
    public String toString() {
        return ma + " " + ngay + " " + gio + " " + phong;
    }
    
}
public class J07059_DanhSachCaThi {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner sc = new Scanner(new File("CATHI.in"));
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Thi> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            Thi x = new Thi(sc.nextLine(), sc.nextLine(), sc.nextLine());
            arr.add(x);
        }
        Collections.sort(arr);
        for(Thi i: arr)
            System.out.println(i);
    }
}
