
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
public class J02009_XepHang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[][] a = new Integer[n][2];
        for(int i = 0; i < n; i++)
        {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }
        Arrays.sort(a, new Comparator<Integer[]>(){
            @Override
            public int compare(Integer[] x, Integer[] y) {
                if(x[0] < y[0]) return -1;
                else return 1;
            }
        });
        long ans = 0;
        for(int i = 0; i < n; i++)
        {
            if(ans < a[i][0])
                ans = a[i][0] + a[i][1];
            else ans += a[i][1];
        }
        System.out.println(ans);
        
    }
}
