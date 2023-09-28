
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
public class J08025_QuayHinhVuong {
    public static boolean check(ArrayList<Integer> x, ArrayList<Integer> y)
    {
        for(int i = 0; i < 6; i++)
            if(x.get(i) != y.get(i)) return false;
        return true;
    }
    public static void rotate1(ArrayList<Integer> x)
    {
        ArrayList<Integer> tmp = new ArrayList<>(x);
        x.set(0, tmp.get(3));
        x.set(1, tmp.get(0));
        x.set(4, tmp.get(1));
        x.set(3, tmp.get(4));
    }
    public static void rotate2(ArrayList<Integer> x)
    {
        ArrayList<Integer> tmp = new ArrayList<>(x);
        x.set(1, tmp.get(4));
        x.set(2, tmp.get(1));
        x.set(5, tmp.get(2));
        x.set(4, tmp.get(5));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            ArrayList<Integer> a = new ArrayList<>(), b = new ArrayList<>();
            for(int i = 0; i < 6; i++)
            {
                int x = sc.nextInt();
                a.add(x);
            }
            for(int i = 0; i < 6; i++)
            {
                int x = sc.nextInt();
                b.add(x);
            }
            HashMap<ArrayList<Integer>, Integer> mp = new HashMap<>();
            Queue<ArrayList> q = new LinkedList<>();
            // System.out.println(q.peek());
            q.add(a);
            mp.put(a, 0);
            while(true)
            {
                ArrayList<Integer> tmp = q.poll();
                //System.out.println(tmp);
                if(check(tmp, b))
                {
                    System.out.println(mp.get(tmp));
                    break;
                }
                ArrayList<Integer> t1 = new ArrayList<>(tmp);
                ArrayList<Integer> t2 = new ArrayList<>(tmp);
                rotate1(t1);
                rotate2(t2);
                mp.put(t1, mp.get(tmp) + 1);
                mp.put(t2, mp.get(tmp) + 1);
                q.add(t1); q.add(t2);
            }
        }
    }
}
