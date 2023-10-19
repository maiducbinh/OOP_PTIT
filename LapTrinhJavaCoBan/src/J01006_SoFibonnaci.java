
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
public class J01006_SoFibonnaci {
    public static long[] fibo = new long[100];
    public static void init()
    {
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
            int n = sc.nextInt();
            System.out.println(fibo[n]);
        }
    }
}
