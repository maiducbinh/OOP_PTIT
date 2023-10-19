
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
public class J01018_SoKhongLienKe {
    static boolean check(String s)
    {
        int sum = 0;
        for(int i = 0; i < s.length() - 1; i++)
        {
            if(Math.abs((s.charAt(i) - '0') - (s.charAt(i + 1) - '0')) != 2) 
                return false;
            sum += (s.charAt(i) - '0');
        }
        sum += s.charAt(s.length() - 1) - '0';
        if(sum % 10 == 0) return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < t; i++)
        {
            String s = sc.next();
            if(check(s) == true)
                System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
