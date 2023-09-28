
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
public class J08020_KiemTraDayNgoacDung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0)
        {
            String s = sc.next();
            Stack<Character> st = new Stack<>();
            for(int i = 0; i < s.length(); i++)
            {
                if(st.empty()) st.push(s.charAt(i));
                else
                {
                    if(st.peek() == '(' && s.charAt(i) == ')')
                        st.pop();
                    else if(st.peek() == '[' && s.charAt(i) == ']')
                        st.pop();
                    else if(st.peek() == '{' && s.charAt(i) == '}')
                        st.pop();
                    else st.push(s.charAt(i)); // thieu push
                }
            }
            System.out.println(st.isEmpty()? "YES": "NO");
        }
    }
}
