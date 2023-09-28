
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
public class J03010_DiaChiEmail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        HashMap<String, Integer> mp = new HashMap<>();
        while(t-->0)
        {
            String s = sc.nextLine();
            ArrayList<String> a = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(s);
            while(st.hasMoreTokens())
            {
                String tmp = st.nextToken();
                a.add(tmp.toLowerCase());
            }
            int n = a.size();
            String ans = "";
            ans += a.get(n - 1);
            for(int i = 0; i < a.size() - 1; i++)
                ans += a.get(i).charAt(0);
            if(!mp.containsKey(ans)) 
            {
                System.out.println(ans + "@ptit.edu.vn");
                mp.put(ans, 1);
            }
            else
            {
                mp.put(ans, mp.get(ans) + 1);
                System.out.println(ans + mp.get(ans) + "@ptit.edu.vn");
            }
        }
    }
}
