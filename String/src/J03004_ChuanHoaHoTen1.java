
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
public class J03004_ChuanHoaHoTen1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0)
        {
            String s = sc.nextLine();
            StringTokenizer st = new StringTokenizer(s);
            while(st.hasMoreTokens())
            {
                String tmp = st.nextToken();
                tmp = tmp.toLowerCase();
                tmp = tmp.substring(0, 1).toUpperCase() + tmp.substring(1);
                System.out.print(tmp + " ");
            }
            System.out.println("");
        }   
    }
}
