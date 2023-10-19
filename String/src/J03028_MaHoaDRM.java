
import java.util.Scanner;

public class J03028_MaHoaDRM {
    public static String DRM(String s){
        int len = s.length() / 2;
        String l = s.substring(0, len);
        String r = s.substring(len);
        int m1 = 0, m2 = 0;
        for(char i: l.toCharArray())
            m1 += i - 'A';
        for(char i: r.toCharArray())
            m2 += i - 'A';
        String nl = "", nr = "";
        for(char i: l.toCharArray()){
            nl += (char)(((i - 'A') + m1) % 26 + 'A');
        }
        for(char i: r.toCharArray())
            nr += (char)(((i - 'A') + m2) % 26 + 'A');
        String ans = "";
        for(int i = 0; i < len; i++)
            ans += (char)(((nl.charAt(i) - 'A') + (nr.charAt(i) - 'A')) % 26 + 'A');
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while(n-->0){
            String s = sc.nextLine();
            System.out.println(DRM(s));
        }
    }
}
