import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
// Loi: quen dau cach
class Cuaro{
    private String ten, dvi, den, ma;

    public Cuaro(String ten, String dvi, String den) {
        this.ten = ten;
        this.dvi = dvi;
        this.den = den;
        this.ma = "";
        String x[] = dvi.split(" ");
        for(String i: x)
            this.ma += i.substring(0, 1);
        String[] y = ten.split(" ");
        for(String i: y)
            this.ma += i.substring(0, 1);
    }
    public int vanToc(){
        double h = (double)(den.charAt(0) - '6');
        double m = (double)Integer.parseInt(den.substring(2, 4));
        int v = (int) Math.round((double)(120 / (h + m / 60)));
        return v;
    }

    public String getDen() {
        return den;
    }

    public String toString(){
        // Loi: quen dau cach
        return ma + " " + ten + " " + dvi + " " + vanToc() + " Km/h";
    }
}
public class J05015_DuaXeDap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Cuaro> a = new ArrayList<>();
        for(int i = 0; i < n; i++){
            Cuaro x = new Cuaro(sc.nextLine(), sc.nextLine(), sc.nextLine());
            a.add(x);
        }
        a.sort(Comparator.comparing(Cuaro::getDen));
        for(Cuaro i: a)
        {
            System.out.println(i);
        }
    }
}