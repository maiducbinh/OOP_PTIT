
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
public class J08023_HinhChuNhatLonNhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            long[] h = new long[n + 1];
            for(int i = 0; i < n; i++)
                h[i] = sc.nextLong();
            Stack<Long> st = new Stack<>();
            int i = 0;
            while(i < n)
            {
                if(st.empty() || (!st.empty() && h[i] > h[st.top()]))
            }
        }
    }
}
