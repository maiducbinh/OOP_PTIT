
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
public class J02036_USCLN {
    public static int gcd(int a, int b)
    {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    public static int lcm(int a, int b)
    {
        return a * b / gcd(a, b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int[] a = new int[n], b = new int[n + 1];
            for(int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            b[0] = a[0];
            b[n] = a[n - 1];
            for(int i = 1; i < n; i++)
                b[i] = lcm(a[i], a[i - 1]);
            for(int i: b) System.out.print(i + " ");
            System.out.println("");
        }
    }
}
