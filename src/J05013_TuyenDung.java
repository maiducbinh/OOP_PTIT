
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class ThiSinh{
    private String ma, ten;
    static int stt = 1;
    private double th, lt;

    public ThiSinh(String ten, double th, double lt) {
        this.ten = ten;
        this.th = normalize(th);
        this.lt = normalize(lt);
        this.ma = String.format("TS%02d", stt++);
    }
    public double normalize(double x){
        if(x > 10)
            return x / 10;
        return x;
    }
    public double diemTB(){
        return (lt + th) / 2;
    }
    public String status(){
        if(diemTB() < 5) return "TRUOT";
        else if(diemTB() < 8) return "CAN NHAC";
        else if(diemTB() <= 9.5) return "DAT";
        return "XUAT SAC";
    }
    public String toString(){
        //Loi: quen lam tron
        return ma + " " + ten + " " + String.format("%.2f", diemTB()) + " " + status();
    }
}
public class J05013_TuyenDung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ThiSinh> a = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        while(n-->0){
            a.add(new ThiSinh(sc.nextLine(), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine())));
        }
        a.sort(Comparator.comparing(ThiSinh::diemTB).reversed());
        for(ThiSinh i: a)
        {
            System.out.println(i);
        }
    }
}
