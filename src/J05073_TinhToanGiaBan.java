
import java.util.Scanner;

class DonHang{
    private String ma;
    private double gia, num;

    public DonHang(String ma, double gia, double num) {
        this.ma = ma;
        this.gia = gia;
        this.num = num;
    }
    public double thue(){
        if(ma.charAt(0) == 'T') return 0.29;
        else if(ma.charAt(0) == 'C') return 0.1;
        else if(ma.charAt(0) == 'D') return 0.08;
        return 0.02;
    }
    public double phi(){
        if(ma.charAt(0) == 'T') return 0.04;
        else if(ma.charAt(0) == 'C') return 0.03;
        else if(ma.charAt(0) == 'D') return 0.025;
        return 0.005;
    }
    public double giamThue(){
        if(ma.charAt(ma.length() - 1) == 'C') return 0.05;
        return 0;
    }
    public double gia(){
        double tax = gia * num * thue();
        tax = tax - tax * giamThue();
        double tong = gia * num + tax + gia * num * phi();
        tong = tong * 1.2;
        return tong / num;
    }
    public String toString(){
        return ma + " " + String.format("%.2f", gia());
    }
}
public class J05073_TinhToanGiaBan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while(n-->0){
            String[] x = sc.nextLine().split(" ");
            System.out.println(new DonHang(x[0], Double.parseDouble(x[1]), Double.parseDouble(x[2])));
        }
    }
}
