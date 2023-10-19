
import java.util.HashMap;
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
public class J02016_BoBaSoPytago {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            long[] a = new long[n];
            HashMap<Long, Integer> mp = new HashMap<>();
            for(int i = 0; i < n; i++)
            {
                a[i] = sc.nextInt();
                a[i] *= a[i];
                if(!mp.containsKey(a[i]))
                    mp.put(a[i], 1);
            }
            boolean ok = false;
            outer: for(int i = 0; i < n; i++)
            {
                for(int j = i + 1; j < n; j++)
                    if(mp.containsKey(a[i] + a[j]))
                    {
                        ok = true;
                        break outer;
                    }
            }
            System.out.println(ok == true? "YES": "NO");
        }
    }
}
