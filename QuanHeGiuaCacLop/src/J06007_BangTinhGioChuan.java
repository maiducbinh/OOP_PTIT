
import java.util.ArrayList;
import java.util.Scanner;

class Mon{
    private String ma, ten;

    public Mon(String s) {
        String[] x = s.split(" ");
        this.ma = x[0];
        this.ten = "";
        for(int i = 1; i < x.length; i++)
            this.ten += x[i] + " ";
        this.ten = this.ten.trim();
    }
    
}

class GV{
    private String ma, ten;
    private double h;
    public GV(String s) {
        h = 0;
        String[] x = s.split(" ");
        this.ma = x[0];
        this.ten = "";
        for(int i = 1; i < x.length; i++)
            this.ten += x[i] + " ";
        this.ten = this.ten.trim();
    }
    
    public void addHour(double x){
        h += x;
    }

    public String getMa() {
        return ma;
    }
    public String toString(){
        return ten + " " + String.format("%.2f", h);
    }
}
public class J06007_BangTinhGioChuan {
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
            double h = Double.parseDouble(x[2]);
            for(GV j: b)
                if(j.getMa().equals(ma))
                    j.addHour(h);
        }
        for(GV i: b)
            System.out.println(i);
    }
}
