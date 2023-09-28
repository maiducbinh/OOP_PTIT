
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
public class J08010_TimTuThuanNghichDaiNhat {
    public static boolean palin(String s)
    {
        for(int i = 0; i <= s.length() / 2; i++)
            if(s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, Integer> mp = new LinkedHashMap<>();
        int mx = 0;
        while(sc.hasNext())
        {
            String s = sc.next();
            if(palin(s) == true)
            {
                mx = Math.max(mx, s.length());
                if(mp.containsKey(s)) mp.put(s, mp.get(s) + 1);
                else mp.put(s, 1);
            }
        }
        ArrayList<String> arr = new ArrayList<>();
        for(String s: mp.keySet())
            if(s.length() == mx) arr.add(s);
        //System.out.println(mx);
        for(String s: arr)
            System.out.println(s + " " + mp.get(s));
    }
}
