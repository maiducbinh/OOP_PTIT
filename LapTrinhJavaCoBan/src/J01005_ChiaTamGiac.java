
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
public class J01005_ChiaTamGiac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            double n, h;
            n = sc.nextDouble();
            h = sc.nextDouble();
            for(int i = 1; i < n; i++)
                System.out.printf("%.6f ", h * Math.sqrt(i / n));
            System.out.println("");
        }
    }
}
