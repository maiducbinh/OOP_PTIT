
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 84912
 */
public class J08026_BienDoiST {
    public static void xuLy(long x, long y)
    {
        if(x > y)
        {
            System.out.println(x - y);
            return;
        }
        HashMap<Long, Integer> mp = new HashMap<>();
        Queue<Long> q = new LinkedList<>();
        q.add(x);
        mp.put(x, 0);
        while(!q.isEmpty())
        {
            long tmp = q.poll();
            if(tmp == y)
            {
                System.out.println(mp.get(tmp));
                return;
            }
            //Thieu kiem tra dieu kien
            if(tmp - 1 > 0 && !mp.containsKey(tmp - 1)){
                q.add(tmp - 1);
                mp.put(tmp - 1, mp.get(tmp) + 1);
            }
            if(tmp < y && !mp.containsKey(tmp * 2))
            {
                q.add(tmp * 2);
                mp.put(tmp * 2, mp.get(tmp) + 1);
            }
        }
        //System.out.println("-1");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            long x = sc.nextLong();
            long y = sc.nextLong();
            xuLy(x, y);
        }
    }
}
