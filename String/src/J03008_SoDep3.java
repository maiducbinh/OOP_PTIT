
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
public class J03008_SoDep3 {
    public static boolean palin(String s)
    {
        for(int i = 0; i <= s.length() / 2; i++)
            if(s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        return true;
    }
    public static boolean check(String s)
    {
        int sum = 0;
        for(int i = 0; i < s.length(); i++)
            if(s.charAt(i) != '2' && s.charAt(i) != '3' && s.charAt(i) != '5' && s.charAt(i) != '7')
                    return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0)
        {
            String s = sc.next();
            if(palin(s) && check(s))
                System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
