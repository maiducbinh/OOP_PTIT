
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class GV{
    private String ten, ma, maGV;
    private double tin, cm;
    static int stt = 1;

    public GV(String ten, String ma, double tin, double cm) {
        this.ten = ten;
        this.ma = ma;
        this.tin = tin;
        this.cm = cm;
        this.maGV = String.format("GV%02d", stt++);
    }
    public double diemUuTien(){
        if(ma.charAt(1) == '1') return 2;
        else if(ma.charAt(1) == '2') return 1.5;
        else if(ma.charAt(1) == '3') return 1;
        return 0;
    }
    public String mon(){
        if(ma.charAt(0) == 'A') return "TOAN";
        else if(ma.charAt(0) == 'B') return "LY";
        return "HOA";
    }
    public double tong(){
        return tin * 2 + cm + diemUuTien();
    }
    public String status(){
        if(tong() >= 18) return "TRUNG TUYEN";
        return "LOAI";
    }
    public String toString(){
        return maGV + " " + ten + " " + mon() + " " + String.format("%.1f", tong()) + " " + status();
    }
}
public class J05014_TuyenGiaoVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<GV> a = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        while(n-->0){
            GV x = new GV(sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()));
            a.add(x);
        }
        a.sort(Comparator.comparing(GV::tong).reversed());
        for(GV i: a)
        {
            System.out.println(i);
        }
    }
}
