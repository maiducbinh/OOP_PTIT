
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
// Loi: ko dc sort sv
class SV{
    private String ten;
    private double gpa;
    private int rl;

    public SV(String ten, double gpa, int rl) {
        this.ten = ten;
        this.gpa = gpa;
        this.rl = rl;
    }

    public double getGpa() {
        return gpa;
    }
    public String loai(){
        if(gpa >= 3.6 && rl >= 90) return "XUATSAC";
        else if(gpa >= 3.2 && rl >= 80) return "GIOI";
        else if(gpa >= 2.5 && rl >= 70) return "KHA";
        return "KHONG";
    }
    public String toString(){
        return ten;
    }
}
public class J05062_HocBongSinhVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SV> a = new ArrayList<>();
        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        ArrayList<Double> b = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String ten = sc.nextLine();
            String x[] = sc.nextLine().split(" ");
            double gpa = Double.parseDouble(x[0]);
            int rl = Integer.parseInt(x[1]);
            SV sv = new SV(ten, gpa, rl);
            b.add(gpa);
            a.add(sv);
        }
        Collections.sort(b, new Comparator<Double>(){
            @Override
            public int compare(Double x, Double y) {
                if(x >= y) return -1;
                return 1;
            }
            
        });
        double gpa = 0;
        int cnt = 0;
        for(double i: b)
            if(cnt < m){
                cnt++;
                gpa = i;
            }
        for(SV i: a){
            if(i.getGpa() >= gpa){
                System.out.println(i + ": " + i.loai());
            }else System.out.println(i + ": KHONG");
        }
    }
}
