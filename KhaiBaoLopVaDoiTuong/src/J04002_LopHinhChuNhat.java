
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
public class J04002_LopHinhChuNhat {
    public static class HCN{
        private int w, l;
        private String c;
        HCN(int w, int l, String c){
            this.w = w;
            this.l = l;
            this.c = c;
        }
        public int findArea()
        {
            return this.w * this.l;
        }
        public int findPerimeter()
        {
            return (this.w + this.l) * 2;
        }
        public String getColor()
        {
            return c.substring(0, 1).toUpperCase() + c.substring(1).toLowerCase();
        }
        public String toString()
        {
            if(w > 0 && l > 0)
            {
                return findPerimeter() + " " + findArea() + " " + getColor();
            }
            return "INVALID";
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        String s = sc.next();
        HCN h = new HCN(a, b, s);
        System.out.print(h);
    }
}
