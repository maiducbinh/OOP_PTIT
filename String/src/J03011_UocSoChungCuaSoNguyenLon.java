
import java.math.BigInteger;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 84912
 */
public class J03011_UocSoChungCuaSoNguyenLon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0)
        {
            String x = sc.next();
            String y = sc.next();
            BigInteger a = new BigInteger(x);
            BigInteger b = new BigInteger(y);
            System.out.println(a.gcd(b));
        }
    }
}
