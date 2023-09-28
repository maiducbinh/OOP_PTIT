
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
public class J01012_UocSoChiaHetCho2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++)
        {
            int n = sc.nextInt();
            int cnt = 0;
            for(int j = 1; j <= Math.sqrt(n); j++)
                if(n % j == 0)
                {
                    if(j % 2 == 0) cnt++;
                    if((n / j) != j && (n / j) % 2 == 0) cnt++;
                }
            System.out.println(cnt);
        }
    }
}
