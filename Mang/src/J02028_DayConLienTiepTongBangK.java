
import java.util.Arrays;
import java.util.HashSet;
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
public class J02028_DayConLienTiepTongBangK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            long k = sc.nextLong();
            long[] a = new long[n + 1];
            a[0] = 0;
            for(int i = 1; i <= n; i++)
            {
                a[i] = sc.nextLong();
                a[i] = a[i] + a[i - 1];
            }
            boolean ok = false;
            for(int i = 0; i < n; i++)
            {
                if(Arrays.binarySearch(a, i + 1, a.length, a[i] + k) >= 0)
                {
                    ok = true;
                    break;
                }
            }
            System.out.println(ok == true? "YES": "NO");
        }
    }
}
