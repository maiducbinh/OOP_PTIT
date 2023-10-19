
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
public class J02008_BSCuaNSo {
    static long gcd(long a, long b)
    {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    static long lcm(long a, long b)
    {
        return a * b / gcd(a, b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            long n = sc.nextInt();
            long l = 1;
            for(long i = 1; i <= n; i++)
                l = lcm(l, i);
            System.out.println(l);
        }
    }
}
