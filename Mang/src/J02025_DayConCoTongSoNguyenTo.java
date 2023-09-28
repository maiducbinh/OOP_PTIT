
import java.util.Arrays;
import java.util.Comparator;
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
public class J02025_DayConCoTongSoNguyenTo {
    static int[] x = new int[20];
    static int n;
    static Integer[] a = new Integer[20];
    public static boolean prime(int n)
    {
        if(n < 2) return false;
        for(int i = 2; i <= Math.sqrt(n); i++)
            if(n % i == 0) return false;
        return true;
    }
    public static void Out()
    {
        int sum = 0;
        for(int i = 1; i <= n; i++) sum += a[i] * x[i];
        if(prime(sum))
        {
            for(int i = 1; i <= n; i++)
                if(x[i] == 1)
                    System.out.print(a[i] + " ");
            System.out.println("");
        }
    }
    public static void Try(int i)
    {
        for(int j = 0; j <= 1; j++)
        {
            x[i] = j;
            if(i == n) Out();
            else Try(i + 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            n = sc.nextInt();
            // Integer[] a = new Integer[n + 1]; 
            for(int i = 1; i <= n; i++)
                a[i] = sc.nextInt();
            Arrays.sort(a, 1, n + 1, new Comparator<Integer>(){
                @Override
                public int compare(Integer x, Integer y) {
                    if(x > y) return -1;
                    else return 1;
                }
            });
            Try(1);
        }
    }
}
