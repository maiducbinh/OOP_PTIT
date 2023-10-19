
import java.util.Scanner;


public class J03019_XauConLonNhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String ans = "";
        int k = 0;
        for(char i = 'z'; i >= 'a'; i--)
            for(int j = k; j < s.length(); j++)
                if(s.charAt(j) == i){
                    System.out.print(s.substring(j, j + 1));
                    k = j;
                }
    }
}
