
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class SV3{
    private String ma, ten, sdt, bt, nhom;
    
    public SV3(String ma, String ten, String sdt) {
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
    }

    public String getMa() {
        return ma;
    }

    public void setBt(String bt) {
        this.bt = bt;
    }

    public void setNhom(String nhom) {
        this.nhom = nhom;
    }
    public String toString(){
        return ma + " " + ten + " " + sdt + " " + nhom + " " + bt;
    }
}
public class J07027_QuanLyBaiTapNhom {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File("SINHVIEN.in"));
        int n = Integer.parseInt(sc1.nextLine());
        ArrayList<SV3> a = new ArrayList<>();
        for(int i = 0; i < n; i++){
            SV3 x = new SV3(sc1.nextLine(), sc1.nextLine(), sc1.nextLine());
            a.add(x);
        }
        ArrayList<String> b = new ArrayList<>();
        Scanner sc2 = new Scanner(new File("BAITAP.in"));
        int m = Integer.parseInt(sc2.nextLine());
        for(int i = 0; i < m; i++){
            b.add(sc2.nextLine());
        }
        Scanner sc3 = new Scanner(new File("NHOM.in"));
        for(int i = 0; i < n; i++){
            String[] x = sc3.nextLine().split(" ");
            for(SV3 j: a)
                if(j.getMa().equals(x[0])){
                    j.setNhom(x[1]);
                    j.setBt(b.get(Integer.parseInt(x[1]) - 1));
                }
        }
        a.sort(Comparator.comparing(SV3::getMa));
        for(SV3 i: a)
        {
            System.out.println(i);
        }
    }
}
