
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Thi implements Comparable<Thi>{
    private String ma, ten, hinhThuc;
    Thi(String ma, String ten, String hinhThuc){
        this.ma = ma;
        this.ten = ten;
        this.hinhThuc = hinhThuc;
    }

    public String getMa() {
        return ma;
    }

    @Override
    public int compareTo(Thi t) {
        return this.ma.compareTo(t.getMa());
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + hinhThuc;
    }
    
}
public class J07058_DanhSachMonThi {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Thi> a = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            Thi x = new Thi(sc.nextLine(), sc.nextLine(), sc.nextLine());
            a.add(x);
        }
        Collections.sort(a);
        for(Thi i: a)
            System.out.println(i);
    }
}
