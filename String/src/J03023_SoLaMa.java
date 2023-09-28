
import java.util.*;


public class J03023_SoLaMa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HashMap<Character, Integer> mp = new HashMap<>();
        mp.put('I', 1);
        mp.put('V', 5);
        mp.put('X', 10);
        mp.put('L', 50);
        mp.put('C', 100);
        mp.put('D', 500);
        mp.put('M', 1000);
        while(n-->0){
            String s = sc.nextLine().trim();
            int len = s.length();
            long res = mp.get(s.charAt(len - 1));
            for(int i = len - 1; i >= 1; i--)
                if(mp.get(s.charAt(i)) > mp.get(s.charAt(i - 1)))
                    res -= mp.get(s.charAt(i - 1));
                else res += mp.get(s.charAt(i - 1));
            System.out.println(res);
        }
    }
}
