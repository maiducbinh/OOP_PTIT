
import java.util.ArrayList;
import java.util.Scanner;

class Mon{
    private String ma, ten;
    private double h;

    public Mon(String s) {
        String[] x = s.split(" ");
        this.ma = x[0];
        this.ten = "";
        for(int i = 1; i < x.length; i++)
            this.ten += x[i] + " ";
        this.ten = this.ten.trim();
    }
    Mon(String ma, String ten, double h){
        this.ma = ma;
        this.ten = ten;
        this.h = h;
    }
    public double getH() {
        return h;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }
    public String toString(){
        return ten + " " + h;
    }
}

class GV{
    private String ma, ten;
    private double h;
    private ArrayList<Mon> a;
    public GV(String s) {
        a = new ArrayList<>();
        h = 0;
        String[] x = s.split(" ");
        this.ma = x[0];
        this.ten = "";
        for(int i = 1; i < x.length; i++)
            this.ten += x[i] + " ";
        this.ten = this.ten.trim();
    }
    
    public double getHour(){
        for(Mon i: a)
            h += i.getH();
        return h;
    }

    public void addMon(Mon mon) {
        a.add(mon);
    }


    public String getMa() {
        return ma;
    }
    public String toString(){
        String ans = "Giang vien: " + ten + "\n";
        for(Mon i: a){
            ans += i.toString() + "\n";
        }
        ans += "Tong: " + String.format("%.2f", getHour());
        return ans;
        
    }
}
public class J06008_TInhGioChuanChoTungGiangVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Mon> a = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            Mon x = new Mon(sc.nextLine());
            a.add(x);
        }
        int m = Integer.parseInt(sc.nextLine());
        ArrayList<GV> b = new ArrayList<>();
        for(int i = 0; i < m; i++){
            GV x = new GV(sc.nextLine());
            b.add(x);
        }
        int k = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < k; i++){
            String[] x = sc.nextLine().split(" ");
            String ma = x[0];
            String mon = x[1];
            double h = Double.parseDouble(x[2]);
            for(GV y: b)
                if(y.getMa().equals(ma)){
                    for(Mon z: a)
                        if(z.getMa().equals(mon)){
                            y.addMon(new Mon(mon, z.getTen(), h));
                            break;
                        }
                }
        }
        String ma = sc.nextLine();
        for(GV i: b)
            if(i.getMa().equals(ma))
            {
                System.out.println(i);
                break;
            }
    }
}
