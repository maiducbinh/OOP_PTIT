
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
public class J02022_SoXaCach {
    static int n;
    static int[] a = new int[15], dd = new int[15];
    public static boolean check()
    {
        for(int i = 2; i <= n; i++)
            if(Math.abs(a[i] - a[i - 1]) == 1)
                return false;
        return true;
    }
    public static void Out()
    {
        if(check() == true) 
        {
            for(int i = 1; i <= n; i++)
            {
                System.out.print(a[i]);
            }
            System.out.println("");
        }
    }
    public static void Try(int i)
    {
        for(int j = 1; j <= n; j++)
            if(dd[j] == 0)
            {
                a[i] = j;
                dd[j] = 1;
                if(i == n) Out();
                else Try(i + 1);
                dd[j] = 0;
            }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            n = sc.nextInt();
            for(int i = 1; i <= n; i++) dd[i] = 0;
            Try(1);
            System.out.println("");
        }
    }
}
