
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
public class J01021_TinhLuyThua {
    public static long mod = (long)1e9 + 7;
    
    public static long powMod(long a, long b)
    {
        if(b == 0) return 1;
        if(b == 1) return a;
        long tmp = powMod(a, b / 2);
        if(b % 2 == 0) return (tmp % mod) * (tmp % mod) % mod;
        else return (tmp % mod) * (tmp % mod) % mod * (a % mod) % mod;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            long a, b;
            a = sc.nextLong();
            b = sc.nextLong();
            if(a == 0 && b == 0) break;
            else System.out.println(powMod(a, b));
        }
    }
}
