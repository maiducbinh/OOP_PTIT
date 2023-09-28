
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
public class J03021_DienThoaiCucGach {
    public static String convert(char x)
    {
        if (x <= 'C')
            return "2";
        else if (x <= 'F')
            return "3";
        else if (x <= 'I')
            return "4";
        else if (x <= 'L')
            return "5";
        else if (x <= 'O')
            return "6";
        else if (x <= 'S')
            return "7";
        else if (x <= 'V')
            return "8";
        return "9";
    }
    public static boolean palin(String s)
    {
        for(int i = 0; i <= s.length() / 2; i++)
            if(s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0)
        {
            String s = sc.next();
            s = s.toUpperCase();
            String x = "";
            // Loi convert sai
            for(int i = 0; i < s.length(); i++)
                x += convert(s.charAt(i));
            if(palin(x) == true)
                System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
