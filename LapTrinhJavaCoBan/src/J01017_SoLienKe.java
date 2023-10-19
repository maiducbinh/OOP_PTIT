
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
public class J01017_SoLienKe {
    public static boolean check(long n)
    {
        long pre = n % 10;
        n /= 10;
        while(n != 0)
        {
            long last = n % 10;
            if(Math.abs(last - pre) != 1) return false;
            pre = last;
            n /= 10;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++)
        {
            long n = sc.nextLong();
            if(check(n) == true)
                System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
