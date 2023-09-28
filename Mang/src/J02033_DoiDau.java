
import java.util.PriorityQueue;
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
public class J02033_DoiDau {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        for(int i = 0; i < n; i++)
        {
            int x = sc.nextInt();
            sum += x;
            pq.add(x);
        }
        while(k-->0)
        {
            int x = pq.poll();
            sum += -2 * x;
            pq.add(-x);
        }
        System.out.println(sum);
    }
}
