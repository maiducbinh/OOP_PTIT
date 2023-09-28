
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
public class J01011_BC_UC {
    public static long gcd(long a, long b)
    {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    public static long lcm(long a, long b)
    {
        return a * b / gcd(a, b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++)
        {
            long a, b;
            a = sc.nextLong();
            b = sc.nextLong();
            System.out.println(lcm(a, b) + " " + gcd(a, b));
        }
    }
}
