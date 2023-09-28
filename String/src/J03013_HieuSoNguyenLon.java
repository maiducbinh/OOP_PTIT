
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
public class J03013_HieuSoNguyenLon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0)
        {
            BigInteger a = new BigInteger(sc.next());
            BigInteger b = new BigInteger(sc.next());
            BigInteger ans = a.subtract(b).abs();
            int n = Math.max(String.valueOf(a).length(), String.valueOf(b).length());
            System.out.println(String.format("%0" + n + "d", ans));
        }
    }
}
