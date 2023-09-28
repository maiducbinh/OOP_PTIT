
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
public class J01024_SoTamPhan {
    static boolean check(String s)
    {
        for(int i = 0; i < s.length(); i++)
            if(s.charAt(i) != '0' && s.charAt(i) != '1' && s.charAt(i) != '2') 
                return false;
        return true;
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
