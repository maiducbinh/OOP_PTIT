
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
public class J02034_BoSungDaySo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dd = new int[205];
        int mx = 0;
        for(int i = 0; i < n; i++)
        {
            int x = sc.nextInt();
            mx = Math.max(mx, x);
            dd[x]++;
        }
        boolean ok = true;
        for(int i = 1; i <= mx; i++)
            if(dd[i] == 0)
            {
                System.out.println(i);
                ok = false;
            }
        if(ok == true)
            System.out.println("Excellent!");
    }
}
