
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
public class J01009_TongGiaiThua {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        long sum = 0, gt = 1;
        for(int i = 1; i <= s; i++)
        {
            gt *= i;
            sum += gt;
        }
        System.out.println(sum);
    }
}
