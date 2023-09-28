
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
public class J02101_InMaTran {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int[][] a = new int[105][105];
            for(int i = 1; i <= n; i++)
                for(int j = 1; j <= n; j++)
                    a[i][j] = sc.nextInt();
            for(int i = 1; i <= n; i++)
                if(i % 2 == 1)
                {
                    for(int j = 1; j <= n; j++)
                        System.out.print(a[i][j] + " ");
                }
                else
                {
                    for(int j = n; j >= 1; j--)
                        System.out.print(a[i][j] + " ");
                }
            System.out.println("");
        }
    }
}
