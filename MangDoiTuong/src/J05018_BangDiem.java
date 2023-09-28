
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class HocSinh implements Comparable<HocSinh>{
    private String ma, ten;
    private double toan, tv, nn, ly, hoa, sinh, su, dia, gdcd, cn, tong;
    static int stt = 1;

    public HocSinh(String ten, double toan, double tv, double nn, double ly, double hoa, double sinh, double su, double dia, double gdcd, double cn) {
        this.ma = String.format("HS%02d", stt++);
        this.ten = ten;
        this.toan = toan;
        this.tv = tv;
        this.nn = nn;
        this.ly = ly;
        this.hoa = hoa;
        this.sinh = sinh;
        this.su = su;
        this.dia = dia;
        this.gdcd = gdcd;
        this.cn = cn;
        this.tong = (toan * 2 + tv * 2 + nn + ly + hoa + sinh + su + dia + gdcd + cn) / 12; 
        this.tong = Math.round(this.tong * 10.0) / 10.0;
        
    }
    
    @Override
    public int compareTo(HocSinh t) {
        if(this.tong > t.tong) return -1;
        return 1;
    }

    @Override
    public String toString() {
        String loai = "";
        if(tong >= 9) loai = "XUAT SAC";
        else if(tong >= 8) loai = "GIOI";
        else if(tong >= 7) loai = "KHA";
        else if(tong >= 5) loai = "TB";
        else loai = "YEU";
        DecimalFormat df = new DecimalFormat("#.#");
        
        return ma + " " + ten + " " + String.format("%.1f", tong) + " " + loai;
    }
    
    
    
}
public class J05018_BangDiem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<HocSinh> arr = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            HocSinh x = new HocSinh(sc.nextLine(), Double.parseDouble(sc.next()), Double.parseDouble(sc.next()), Double.parseDouble(sc.next()), Double.parseDouble(sc.next()), Double.parseDouble(sc.next()), Double.parseDouble(sc.next()), Double.parseDouble(sc.next()), Double.parseDouble(sc.next()), Double.parseDouble(sc.next()), Double.parseDouble(sc.next()));
            sc.nextLine();
            arr.add(x);
        }
        Collections.sort(arr);
        for(HocSinh i: arr)
            System.out.println(i);
    }
}
