
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
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
public class J02005_Giao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[105], dd1 = new int[1005];
        int[] b = new int[105], dd2 = new int[1005];
        for(int i = 0; i < 1005; i++) 
        {
            dd1[i] = 0;
            dd2[i] = 0;
        }
        for(int i = 0; i < n; i++)
        {
            a[i] = sc.nextInt();
            dd1[a[i]] = 1;
        }
        for(int j = 0; j < m; j++)
        {
            b[j] = sc.nextInt();
            dd2[b[j]] = 1;
        }
        for(int i = 0; i < 1005; i++)
            if(dd1[i] == 1 && dd2[i] == 1)
                System.out.print(i + " ");
    }
}
