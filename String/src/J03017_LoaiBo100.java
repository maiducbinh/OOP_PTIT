
import java.util.Scanner;


public class J03017_LoaiBo100 {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int test = Integer.parseInt(input.nextLine());
        while(test-->0)
        {
            int max = 0;
            String s = input.nextLine();
            String k = s;
            int res = s.length();
            while(true)
            {
                res = s.length();
                k = s.replace("100", "");
                if(k.compareTo(s)==0)
                {
                    break;
                }
                s = k;
                max = Math.max(res-s.length(),max);
            }
            System.out.println(max);
        }
    }
}
