
import java.text.DecimalFormat;
import java.util.Scanner;

/*class Point{
    private double x, y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double distance(Point b)
    {
        return Math.sqrt((this.x - b.x) * (this.x - b.x) + (this.y - b.y) * (this.y - b.y));
    }
}

public class J04008_ChuViTamGiac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            Point a = new Point(sc.nextDouble(), sc.nextDouble());
            Point b = new Point(sc.nextDouble(), sc.nextDouble());
            Point c = new Point(sc.nextDouble(), sc.nextDouble());
            double c1 = a.distance(b);
            double c2 = b.distance(c);
            double c3 = c.distance(a);
            if(c1 + c2 > c3 && c2 + c3 > c1 && c3 + c1 > c2)
            {
                // quen xuong dong
                System.out.printf("%.3f\n", (c1 + c2 + c3));
            }
            else System.out.println("INVALID");
        }
    }
}
