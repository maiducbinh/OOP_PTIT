
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
public class J01008_PhanTichThuaSoNguyenTo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 1; i <= t; i++)
        {
            System.out.print("Test " + i + ": ");
            int n = sc.nextInt();
            for(int j = 2; j <= Math.sqrt(n); j++)
            {
                int cnt = 0;
                if(n % j == 0)
                {
                    while(n % j == 0)
                    {
                        cnt++;
                        n /= j;
                    }
                    System.out.print(j + "(" + cnt + ")" + " ");
                }
            }
            if(n > 1) System.out.print(n + "(1)");
            System.out.println("");
        }
    }
}
