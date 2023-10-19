
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
public class J01022_XauNhiPhan {
    public static long[] fibo = new long[100];
    static void init()
    {
        fibo[1] = 1;
        fibo[2] = 1;
        for(int i = 3; i < 93; i++)
            fibo[i] = fibo[i - 1] + fibo[i - 2];
    }
    static int solve(int n, long k)
    {
        if(n == 1) return 0;
        if(n == 2) return 1;
        if(k <= fibo[n - 2])
            return solve(n - 2, k);
        else 
            return solve(n - 1, k - fibo[n - 2]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        init();
        int t = sc.nextInt();
        for(int i = 0; i < t; i++)
        {
            int n = sc.nextInt();
            long k = sc.nextLong();
            System.out.println(solve(n, k));
        }
    }
}
