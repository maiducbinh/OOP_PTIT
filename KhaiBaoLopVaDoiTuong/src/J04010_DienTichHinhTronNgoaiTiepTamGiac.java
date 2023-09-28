
import java.util.Scanner;

class Point{
    private double x, y;
    Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public double distance(Point i){
        double x = i.getX(), y = i.getY();
        return Math.sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y));
    }
}
public class J04010_DienTichHinhTronNgoaiTiepTamGiac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            Point a = new Point(sc.nextDouble(), sc.nextDouble());
            Point b = new Point(sc.nextDouble(), sc.nextDouble());
            Point c = new Point(sc.nextDouble(), sc.nextDouble());
            double c1 = a.distance(b);
            double c2 = a.distance(c);
            double c3 = b.distance(c);
            if(c1 + c2 > c3 && c1 + c3 > c2 && c2 + c3 > c1){
                double s = 0.25 * Math.sqrt((c1 + c2 + c3) * (c1 + c2 - c3) * (c1 + c3 - c2) * (c2 + c3 - c1));
                double r = c1 * c2 * c3 / (4 * s);
                // Loi: quen xuong dong
                System.out.printf("%.2f\n", s);
            }
            else System.out.println("INVALID");
        }
    }
}
