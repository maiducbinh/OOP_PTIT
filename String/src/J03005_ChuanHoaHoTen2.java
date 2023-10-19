
import java.util.ArrayList;
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
public class J03005_ChuanHoaHoTen2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0)
        {
            String s = sc.nextLine();
            ArrayList<String> arr = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(s);
            while(st.hasMoreTokens())
            {
                String tmp = st.nextToken();
                tmp = tmp.substring(0, 1).toUpperCase() + tmp.substring(1).toLowerCase();
                arr.add(tmp);
            }
            for(int i = 1; i < arr.size(); i++)
                if(i != arr.size() - 1) System.out.print(arr.get(i) + " ");
                else System.out.print(arr.get(i) + ", ");
            System.out.println(arr.get(0).toUpperCase());
        }
    }
}
