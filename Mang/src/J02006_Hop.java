
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
public class J02006_Hop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[105], b = new int[105], dd = new int[1005];
        for(int i = 0; i < 1005; i++) 
        {
            dd[i] = 0;
        }
        for(int i = 0; i < n; i++)
        {
            a[i] = sc.nextInt();
            dd[a[i]] = 1;
        }
        for(int i = 0; i < m; i++)
        {
            b[i] = sc.nextInt();
            dd[b[i]] = 1;
        }
        for(int i = 0; i < 1005; i++)
            if(dd[i] == 1) System.out.print(i + " ");
    }
}
