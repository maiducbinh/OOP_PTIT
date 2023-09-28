
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
public class J03025_XauDoiXung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0)
        {
            String s = sc.next();
            int cnt = 0;
            for(int i = 0; i < s.length()/2; i++)
                if(s.charAt(i) != s.charAt(s.length() - i - 1))
                    cnt++;
            if(s.length() % 2 == 1 && cnt <= 1)
                System.out.println("YES");
            else if(s.length() % 2 == 0 && cnt == 1)
                System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
