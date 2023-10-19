
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
public class J03006_SoDep1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0)
        {
            String s = sc.next();
            boolean ok = true;
            for(int i = 0; i < s.length(); i++)
                if((s.charAt(i) - '0') % 2 == 1)
                {
                    ok = false;
                    break;
                }
            System.out.println(ok? "YES": "NO");
        }
    }
}
