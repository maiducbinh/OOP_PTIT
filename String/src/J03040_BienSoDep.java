
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
public class J03040_BienSoDep {
    public static boolean check(String s)
    {
        boolean ok1 = true, ok2 = true, ok3 = true, ok4 = true;
        for(int i = 0; i < 4; i++)
            if(s.charAt(i) >= s.charAt(i + 1)) ok1 = false;
        for(int i = 0; i < 2; i++)
            if(s.charAt(i) != s.charAt(i + 1)) ok2 = false;
        if(s.charAt(3) != s.charAt(4)) ok2 = false;
        for(int i = 0; i < 5; i++)
            if(s.charAt(i) != '6' && s.charAt(i) != '8') ok3 = false;
        if(ok1 == true || ok2 == true || ok3 == true)
            return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0)
        {
            String x = sc.next();
            String s = x.substring(5, 8) + x.substring(9);
            if(check(s) == true)
                System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
