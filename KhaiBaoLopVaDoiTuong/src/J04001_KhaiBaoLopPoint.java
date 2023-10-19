
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 84912
 */

public class J04001_KhaiBaoLopPoint {
    static class Point{
        private double x, y;
        public Point(){
            
        }
        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
        public void Point(Point p)
        {
            this.x = p.x;
            this.y = p.y;
        }
        public double getX()
        {
            return x;
        }
        public double getY(){
            return y;
        }
        public double distant(Point secondPoint)
        {
            double dx = this.x - secondPoint.x;
            double dy = this.y - secondPoint.y;
            double res = Math.sqrt((dx * dx) + (dy * dy));
            return res;
        }
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();
            Point a = new Point(x1, y1);
            Point b = new Point(x2, y2);
            System.out.printf("%.4f\n", a.distant(b));
        }
    }
}
