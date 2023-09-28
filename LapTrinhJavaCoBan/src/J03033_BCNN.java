
import java.math.BigInteger;
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
public class J03033_BCNN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < t; i++)
        {
            String a, b;
            a = sc.next();
            b = sc.next();
            BigInteger x = new BigInteger(a);
            BigInteger y = new BigInteger(b);
            BigInteger gcd = x.gcd(y);
            BigInteger lcm = x.multiply(y);
            lcm = lcm.divide(gcd);
            System.out.println(lcm);
        }
    }
}
