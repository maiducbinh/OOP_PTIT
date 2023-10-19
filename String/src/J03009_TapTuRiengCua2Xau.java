
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
public class J03009_TapTuRiengCua2Xau {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0)
        {
            String x = sc.nextLine();
            String y = sc.nextLine();
            //System.out.println(x + " " + y);
            HashMap<String, Integer> mp = new HashMap<>();
            String[] a = x.split("\\s+");
            String[] b = y.split("\\s+");
            for(int i = 0; i < a.length; i++)
                mp.put(a[i], 1);
            for(int i = 0; i < b.length; i++)
                if(mp.containsKey(b[i]))
                    mp.put(b[i], 2);
            ArrayList<String> arr = new ArrayList<>();
            // Loi: truy cap vao tu chua co trong xau
            for(int i = 0; i < a.length; i++)
                if(mp.containsKey(a[i]) && mp.get(a[i]) == 1)
                {
                    arr.add(a[i]);
                    mp.remove(a[i]);
                }
            arr.sort(new Comparator<String>(){
                @Override
                public int compare(String t, String t1) {
                    return t.compareTo(t1);
                }
            });
            for(String i: arr) System.out.print(i + " ");
            System.out.println("");
        }
    }
}
