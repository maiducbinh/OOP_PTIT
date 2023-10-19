
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class TS{
    private String ma, ten;
    private double t, l, h, tong;

    TS(String ma, String ten, double t, double l, double h) {
        this.ma = ma;
        this.ten = ten;
        this.t = t;
        this.l = l;
        this.h = h;
        this.tong = t * 2 + l + h + uuTien();
    }
    public double uuTien(){
        if(ma.charAt(2) == '1') return 0.5;
        else if(ma.charAt(2) == '2') return 1;
        return 2.5;
    }

    public double getTong() {
        return tong;
    }
    
    public String toString(){
        String u = "", t = "";
        if(uuTien() == (int)uuTien())
            u += (int)uuTien() + "";
        else u += String.format("%.1f", uuTien());
        if(tong == (int)tong)
            t += (int)tong + "";
        else t += String.format("%.1f", tong);
        String tt;
        if(tong >= 24)
            tt = "TRUNG TUYEN";
        else tt = "TRUOT";
        return ma + " " + ten + " " + u + " " + t + " " + tt; 
    }
    
}
public class J05058_SXKQTS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<TS> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            TS x = new TS(sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()));
            arr.add(x);
        }
        arr.sort(Comparator.comparing(TS::getTong).reversed());
        for(TS i: arr)
            System.out.println(i);
    }
}
