
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
public class J02014_DiemCanBang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t--> 0)
        {
            int n = sc.nextInt();
            int[] a = new int[n], pre = new int[n];
            for(int i = 0; i < n; i++)
            {
                a[i] = sc.nextInt();
                if(i > 0) pre[i] = pre[i - 1] + a[i];
                else pre[0] = a[0];
            }
            int idx = -1;
            for(int i = 0; i < n; i++)
                if(pre[i] - a[i] == pre[n - 1] - pre[i])
                {
                    idx = i + 1;
                    break;
                }
            System.out.println(idx);
        }
    }
}
