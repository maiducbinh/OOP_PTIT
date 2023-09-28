
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
public class J02035_QuayPhai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            long[] a = new long[n + 1];
            for(int i = 1; i <= n; i++)
                a[i] = sc.nextLong();
            int idx = 0;
            for(int i = 1; i < n; i++)
                if(a[i] > a[i + 1])
                {
                    idx = i;
                    break;
                }
            System.out.println(idx);
        }
    }
}
