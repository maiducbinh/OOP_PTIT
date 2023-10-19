
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
public class J01007_KiemTraSoFibonacci {
    public static long[] fibo = new long[100];
    public static void init()
    {
        fibo[0] = 0;
        fibo[1] = 1;
        fibo[2] = 1;
        for(int i = 3; i <= 92; i++)
            fibo[i] = fibo[i - 1] + fibo[i - 2];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        init();
        int t = sc.nextInt();
        for(int i = 0; i < t; i++)
        {
            long n = sc.nextLong();
            boolean ok = false;
            for(int j = 0; j <= 92; j++)
                if(fibo[j] == n)
                {
                    ok = true;
                    break;
                }
            if(ok == true)
                System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
