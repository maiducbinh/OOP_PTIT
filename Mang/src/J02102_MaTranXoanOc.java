
import java.util.ArrayList;
import java.util.Arrays;
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
public class J02102_MaTranXoanOc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        int[][] a = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
            {
                a[i][j] = sc.nextInt();
                arr.add(a[i][j]);
            }
        arr.sort((x,y) -> x.compareTo(y));
        int k = 0, h1 = 1, h2 = n, c1 = 1, c2 = n;
        while(h1 <= h2 && c1 <= c2)
        {
            for(int i = c1; i <= c2; i++)
                a[h1][i] = arr.get(k++);
            h1++;
            for(int j = h1; j <= h2; j++)
                a[j][c2] = arr.get(k++);
            c2--;
            for(int i = c2; i >= c1; i--)
                a[h2][i] = arr.get(k++);
            h2--;
            for(int j = h2; j >= h1; j--)
                a[j][c1] = arr.get(k++);
            c1++;
        }
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= n; j++)
                System.out.print(a[i][j] + " ");
            System.out.println("");
        }
    }
}
