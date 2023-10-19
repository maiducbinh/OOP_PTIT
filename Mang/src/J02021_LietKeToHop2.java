
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
public class J02021_LietKeToHop2 {
    static int n, k, ok;
    static int[] a = new int[15];
    public static void sinh()
    {
        int i = k;
        while(i > 0 && a[i] == n - k + i) i--;
        if(i == 0)
        {
            ok = 1;
        }
        else 
        {
            a[i]++;
            for(int j = i + 1; j <= k; j++)
                a[j] = a[j - 1] + 1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        ok = 0;
        int cnt = 0;
        for(int i = 1; i <= k; i++) a[i] = i;
        while(ok == 0)
        {
            cnt++;
            for(int i = 1; i <= k; i++) 
                System.out.print(a[i]);
            System.out.print(" ");
            sinh();
        }
        System.out.println("");
        System.out.println("Tong cong co " + cnt + " to hop");
    }
}
