
import java.util.LinkedList;
import java.util.Queue;
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
public class J08024_So0Va9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            Queue<Long> q = new LinkedList<>();
            q.add((long)9);
            long ans;
            while(true)
            {
                long tmp = q.poll();
                if(tmp % n == 0)
                {
                    ans = tmp;
                    break;
                }
                q.add(tmp * 10);
                q.add(tmp * 10 + 9);
            }
            System.out.println(ans);
        }
        
    }
}
