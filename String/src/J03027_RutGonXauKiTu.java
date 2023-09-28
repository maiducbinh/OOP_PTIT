
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
public class J03027_RutGonXauKiTu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder s = new StringBuilder(sc.next());
        int i = 0;
        while(i < s.length() - 1)
        {
            if(s.charAt(i) == s.charAt(i + 1))
            {
                s.delete(i, i + 2);
                i = 0;
            }
            else i++;
        }
        if(s.toString().isEmpty())
            System.out.println("Empty String");
        else System.out.println(s);
    }
}
