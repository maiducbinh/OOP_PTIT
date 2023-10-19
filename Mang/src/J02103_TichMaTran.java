
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 84912
 */
public class J02103_TichMaTran {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int _ = 1; _ <= t; _++)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] a = new int[n + 1][m + 1], at = new int[m + 1][n + 1], p = new int[n + 1][n + 1];
            for(int i = 1; i <= n; i++)
                for(int j = 1; j <= m; j++)
                {
                    a[i][j] = sc.nextInt();
                    at[j][i] = a[i][j];
                }
            for(int i = 1; i <= n; i++)
            {
                for(int j = 1; j <= n; j++)
                {
                    p[i][j] = 0;
                    for(int k = 1; k <= m; k++)
                        p[i][j] += a[i][k] * at[k][j];
                }
            }
            System.out.println("Test " + _ +  ":");
            for(int i = 1; i <= n; i++)
            {
                for(int j = 1; j <= n; j++)
                {
                    System.out.print(p[i][j] + " ");
                }
                System.out.println("");
            }
        }
    }
}
