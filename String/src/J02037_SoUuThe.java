
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 84912
 */
public class J02037_SoUuThe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0)
        {
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            int l = 0, chan = 0;
            while(st.hasMoreTokens())
            {
                l++;
                String tmp = st.nextToken();
                if((tmp.charAt(tmp.length() - 1) - '0') % 2 == 0)
                    chan++;
            }
            //System.out.println(l + " " + chan);
            if(l % 2 == 0 && chan > l - chan)
                System.out.println("YES");
            else if(l % 2 == 1 && chan < l - chan)
                System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
