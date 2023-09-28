
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
public class J01016_ChuSo4Va7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int cnt = 0;
        while(n != 0)
        {
            long last = n % 10;
            if(last == 7 || last == 4) cnt++;
            n /= 10;
        }
        if(cnt == 4 ||cnt == 7)
            System.out.println("YES");
        else System.out.println("NO");
    }
}
