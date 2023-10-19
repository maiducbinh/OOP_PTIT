
import static java.lang.Character.isDigit;
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
public class J03024_SoUuThe {
    public static boolean check1(String s)
    {
        if(s.charAt(0) == '0') return false;
        for(int i = 0; i < s.length(); i++)
            if(!isDigit(s.charAt(i))) return false;
        return true;
    }
    public static boolean check2(String s)
    {
        int chan = 0;
        for(int i = 0; i < s.length(); i++)
            if((s.charAt(i) - '0') % 2 == 0) chan++;
        if(s.length() % 2 == 0 && chan > s.length() - chan)
            return true;
        if(s.length() % 2 == 1 && chan < s.length() - chan)
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
            if(check1(s) == false)
                System.out.println("INVALID");
            else
            {
                if(check2(s) == true)
                    System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}
