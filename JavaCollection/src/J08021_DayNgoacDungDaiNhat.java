
import java.util.Scanner;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 84912
 */
public class J08021_DayNgoacDungDaiNhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0)
        {
            String s = sc.next();
            Stack<Character> st = new Stack<>();
            int cnt = 0, mx = 0;
            for(int i = 0; i < s.length(); i++)
            {
                if(st.empty()) st.push(s.charAt(i));
                else
                {
                    if(st.peek() == '(' && s.charAt(i) == ')')
                    {
                        st.pop();
                        cnt += 2;
                        mx = Math.max(mx, cnt);
                    }
                    else {
                        cnt = 0;
                        st.push(s.charAt(i));
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
