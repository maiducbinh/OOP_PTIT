
import java.util.*;


public class J03031_XauDayDU {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            String s = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine());
            HashSet<Character> se = new HashSet<>();
            for(char i: s.toCharArray())
                se.add(i);
            System.out.println(se.size() + k >= ('z' - 'a' + 1)? "YES": "NO");
        }
    }
}
