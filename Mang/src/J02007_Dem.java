
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
public class J02007_Dem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 1; i <= t; i++)
        {
            System.out.println("Test " + i + ":");
            int n = sc.nextInt();
            int[] dd = new int[100005], a = new int[1005];
            for(int j = 0; j < 100005; j++) dd[j] = 0;
            for(int j = 0; j < n; j++)
            {
                a[j] = sc.nextInt();
                dd[a[j]] += 1;
            }
            for(int j = 0; j < n; j++)
                if(dd[a[j]] >= 1)
                {
                    System.out.println(a[j] + " xuat hien " + dd[a[j]] + " lan");
                    dd[a[j]] = 0;
                }
        }
    }
}
