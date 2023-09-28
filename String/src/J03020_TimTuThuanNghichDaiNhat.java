
import java.util.*;


public class J03020_TimTuThuanNghichDaiNhat {
    public static boolean palin(String s){
        int n = s.length();
        for(int i = 0; i <= n / 2; i++)
            if(s.charAt(i) != s.charAt(n - i - 1)) return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, Integer> mp = new LinkedHashMap<>();
        while(sc.hasNext()){
            String s = sc.next();
            if(palin(s)){
                if(mp.containsKey(s))
                    mp.put(s, mp.get(s) + 1);
                else mp.put(s, 1);
            }
        }
        int mx = 0;
        for(String i: mp.keySet())
            mx = Math.max(mx, i.length());
        for(String i: mp.keySet())
            if(i.length() == mx)
                System.out.println(i + " " + mp.get(i));
    }
}
