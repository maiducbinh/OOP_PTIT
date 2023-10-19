
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
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
public class J08011_LietKeVaDem {
    public static boolean check(String s)
    {
        for(int i = 0; i < s.length() - 1; i++)
            if(s.charAt(i) - s.charAt(i + 1) > 0)
                return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<>();
        LinkedHashMap<String, Integer> mp = new LinkedHashMap<>();
        while(sc.hasNext())
        {
            String s = sc.next();
            // System.out.println(s);
            if(check(s))
            {
                if(!mp.containsKey(s))
                    mp.put(s, 1);
                else mp.put(s, mp.get(s) + 1);
            }
        }
        for(String s: mp.keySet())
            arr.add(s);
        Collections.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String t, String t1) {
                if(mp.get(t) > mp.get(t1)) return -1;
                else return 1;
            }
        });
        for(String s: arr)
            System.out.println(s);
    }
}
