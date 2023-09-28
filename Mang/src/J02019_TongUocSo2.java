
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
public class J02019_TongUocSo2 {
    public static int[] dp = new int[1000005];
    public static void init()
    {
        dp[0] = dp[1] = 0;
        for(int i = 1; i <= 1000000; i++)
            for(int j = 2 * i; j <= 1000000; j += i)
                dp[j] += i;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        init();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int cnt = 0;
        for(int i = a; i <= b; i++)
        {
            if(dp[i] > i) cnt++;
        }
        System.out.println(cnt);
    }
}
