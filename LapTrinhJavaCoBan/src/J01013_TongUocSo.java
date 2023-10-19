
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
public class J01013_TongUocSo {
    public static int[] p = new int[2000011];
    public static void sieve()
    {
        p[0] = 0; p[1] = 1;
        for(int i = 2; i <= 2000000; i++)
            p[i] = i;
        for(int i = 2; i <= 1500; i++)
            if(p[i] == i)
                for(int j = i * i; j <= 2000000; j += i)
                    if(p[j] == j) p[j] = i;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sieve();
        int t = sc.nextInt();
        long s = 0;
        for(int i = 0; i < t; i++)
        {
            int n = sc.nextInt();
            while(n > 1)
            {
                s += p[n];
                n /= p[n];
            }
        }
        System.out.println(s);
    }
}
