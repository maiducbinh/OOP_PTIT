
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
public class J02017_ThuGonDaySo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        {
            int n = sc.nextInt();
            Stack<Integer> st = new Stack<>();
            while(n-->0)
            {
                int x = sc.nextInt();
                if(!st.empty() && (st.peek() + x) % 2 == 0)
                    st.pop();
                else st.push(x);
            }
            System.out.println(st.size());
        }
    }
}
