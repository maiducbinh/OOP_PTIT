
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class MonHoc{
    private String ma, ten;
    private int tin;

    public MonHoc(String ma, String ten, int tin) {
        this.ma = ma;
        this.ten = ten;
        this.tin = tin;
    }

    public String getTen() {
        return ten;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + tin;
    }
    
}
public class J07034_DanhSachMonHoc {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        //Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<MonHoc> a = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            MonHoc x = new MonHoc(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()));
            a.add(x);
        }
        Collections.sort(a, new Comparator<MonHoc>(){
            @Override
            public int compare(MonHoc t, MonHoc t1) {
                return t.getTen().compareTo(t1.getTen());
            }
        });
        for(MonHoc i: a)
            System.out.println(i);
    }
}
