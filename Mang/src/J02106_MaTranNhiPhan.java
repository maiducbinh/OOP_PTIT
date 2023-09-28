
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
public class J02106_MaTranNhiPhan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n + 1][4];
        int cnt = 0;
        for(int i = 1; i <= n; i++)
        {
            int cnt1 = 0, cnt0 = 0;
            for(int j = 1; j <= 3; j++)
            {
                a[i][j] = sc.nextInt();
                if(a[i][j]== 1) cnt1++;
                else cnt0++;
            }
            if(cnt1 > cnt0) cnt++;
        }
        System.out.println(cnt);
    }
}
