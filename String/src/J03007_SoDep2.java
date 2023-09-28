
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
public class J03007_SoDep2 {
    public static boolean palin(String s)
    {
        for(int i = 0; i <= s.length() / 2; i++)
            if(s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        return true;
    }
    public static boolean checkSum(String s)
    {
        int sum = 0;
        for(int i = 0; i < s.length(); i++)
            sum += (s.charAt(i) - '0');
        if(sum % 10 == 0)
            return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0)
        {
            String s = sc.next();
            if(palin(s) && checkSum(s) && s.charAt(0) == '8')
                System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
