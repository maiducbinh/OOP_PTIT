
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class SP implements Comparable<SP> {

    private String ma, ten;
    private int gia, bh;

    public SP(String ma, String ten, int gia, int bh) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.bh = bh;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + gia + " " + bh;
    }

    @Override
    public int compareTo(SP o) {
        if (this.gia == o.gia) {
            return this.ma.compareTo(o.ma);
        }
        return o.gia - this.gia;
    }

}

public class J07048_DanhSachSanPham2 {

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("SANPHAM.in"));
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<SP> arr = new ArrayList<>();
        while (t-- > 0) {
            SP x = new SP(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()));
            arr.add(x);
        }
        Collections.sort(arr);
        for (SP i : arr) {
            System.out.println(i);
        }
    }
}
