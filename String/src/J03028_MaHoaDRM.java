
import java.util.Scanner;

public class J03028_MaHoaDRM {
    public static String DRM(String s){
        int len = s.length();
        String l = s.substring(0, len);
        String r = s.substring(len);
        int m1 = 0, m2 = 0;
        for(char i: l.toCharArray())
            m1 += i - 'a';
        for(char i: r.toCharArray())
            m2 += i - 'a';
        String nl = "", nr = "";
        for(char i: l.toCharArray()){
            nl += (char)((i + m1) % 25);
        }
        for(char i: r.toCharArray())
            nr += (char)((i + m2) % 25);
        return nl;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while(n-->0){
            String s = sc.next();
            System.out.println(DRM(s));
        }
    }
}
