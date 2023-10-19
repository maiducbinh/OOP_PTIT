
import java.util.Scanner;

class Point{
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
}

public class J05008_DienTichDaGiac {
    public static void area(Point a[], int n)
    {
        double s = 0;
        for(int i = 0; i < n - 1; i++)
            s += a[i].getX() * a[i + 1].getY();
        s += a[n - 1].getX() * a[0].getY();
        for(int i = 1; i < n; i++)
            s -= a[i].getX() * a[i - 1].getY();
        s -= a[0].getX() * a[n - 1].getY();
        System.out.printf("%.3f\n", Math.abs((double) s / 2));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            Point a[] = new Point[n];
            for(int i = 0; i < n; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                Point b = new Point(x, y);
                a[i] = b;
            }
            area(a, n);
        }
    }
}
