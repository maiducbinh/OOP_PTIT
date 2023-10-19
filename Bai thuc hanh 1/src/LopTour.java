
import java.util.Scanner;

class Tour{
    private String ma, tu, den;
    private int soNguoi;
    private double gia;
    static int stt = 1;

    public Tour(String tu, String den, int soNguoi, double gia) {
        
        this.tu = tu;
        this.den = den;
        this.soNguoi = soNguoi;
        this.gia = gia;
    }
    public String getMa(){
        return tu + "-" + den + "*" + String.format("%03d", stt++);
    }
    public double getThanhTien(){
        if(soNguoi < 5) return (double)soNguoi * gia;
        else if(soNguoi <= 10) return (double)soNguoi * gia - (double)soNguoi * gia * 0.1;
        return (double)soNguoi * gia * 0.8;
    }
    public String toString(){
        return getMa() + " " + soNguoi + " " + String.format("%.1f", gia) + " " + String.format("%.1f", getThanhTien());
    }
}
public class LopTour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while(n-->0){
            Tour x = new Tour(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()), Double.parseDouble(sc.nextLine()));
            System.out.println(x);
        }
    }
}
