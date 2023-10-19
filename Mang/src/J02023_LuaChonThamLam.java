
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
public class J02023_LuaChonThamLam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        if(n * 9 < s || (n > 1 && s == 0))
        {
            System.out.println("-1 -1");
        }
        else 
        {
            int[] a = new int[n], b = new int[n];
            int sum = s - 1;
            for(int i = n - 1; i >= 0; i--)
                if(sum >= 9)
                {
                    a[i] = 9;
                    sum -= 9;
                }
                else
                {
                    a[i] = sum;
                    sum = 0;
                }
            a[0] += 1;
            for(int i: a) System.out.print(i);
            System.out.print(" ");
            
            for(int i = 0; i < n; i++)
                if(s >= 9)
                {
                    b[i] = 9;
                    s -= 9;
                }
                else {
                    b[i] = s;
                    s = 0;
                }
            for(int i: b) System.out.print(i);
        }
    }
}
