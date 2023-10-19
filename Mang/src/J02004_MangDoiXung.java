
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
public class J02004_MangDoiXung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++)
        {
            int n = sc.nextInt();
            int[] a = new int[105];
            for(int j = 0; j < n; j++)
                a[j] = sc.nextInt();
            boolean flag = true;
            for(int j = 0; j <= n / 2; j++)
                if(a[j] != a[n - j - 1]) flag = false;
            if(flag == true) 
                System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
