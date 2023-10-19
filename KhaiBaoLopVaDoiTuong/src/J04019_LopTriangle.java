/*
import java.util.Scanner;

class Point{
    private double x, y;
    Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    public static Point nextPoint(Scanner sc){
        Point ans = new Point(sc.nextDouble(), sc.nextDouble());
        return ans;
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
class Triangle{
    private Point a, b, c;
    Triangle(Point a, Point b, Point c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public boolean valid(){
        double c1 = a.distance(b);
        double c2 = a.distance(c);
        double c3 = b.distance(c);
        if(c1 + c2 > c3 && c1 + c3 > c2 && c2 + c3 > c1)
            return true;
        return false;
    }
    public String getPerimeter(){
        double c1 = a.distance(b);
        double c2 = a.distance(c);
        double c3 = b.distance(c);
        return String.format("%.3f", c1 + c2 + c3);
    }
}
public class J04019_LopTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            // Su dung ham static de goi thong qua ten ham chu ko can doi tuong cu the
            Triangle a = new Triangle(Point.nextPoint(sc), Point.nextPoint(sc), Point.nextPoint(sc));
            if(!a.valid()){
                System.out.println("INVALID");
            } else{
                System.out.println(a.getPerimeter());
            }
        }
    }
}
