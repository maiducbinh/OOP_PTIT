
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
public class J01014_UocSoNguyenToLonNhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++)
        {
            long n = sc.nextLong();
            long ans = 0;
            for(int j = 2; j <= Math.sqrt(n); j++)
                if(n % j == 0)
                {
                    ans = Math.max(ans, j);
                    while(n % j == 0)
                    {
                        n /= j;
                    }
                }
            if(n > 1) ans = Math.max(ans, n);
            System.out.println(ans);
        }
    }
}
