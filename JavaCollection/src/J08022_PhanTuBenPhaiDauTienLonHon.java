
import java.util.Queue;
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
public class J08022_PhanTuBenPhaiDauTienLonHon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int[] a = new int[n], res = new int[n];
            for(int i = 0; i < n; i++)
            {
                a[i] = sc.nextInt();
                res[i] = -1;
            }
            Stack<Integer> st = new Stack<>();
            for(int i = 0; i < n; i++)
            {
                if(st.empty()) st.push(i);
                else 
                {
                    while(!st.empty() && a[i] > a[st.peek()])
                    {
                        res[st.peek()] = a[i];
                        st.pop();
                    }
                    st.push(i);
                }
            }
            for(int i: res) System.out.print(i + " ");
            System.out.println("");
        }
    }
}
