
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 84912
 */
public class SoDep4 {
    public static boolean check(String s){
        int n = s.length();
        for(int i = 0; i <= n / 2; i++)
            if(!((s.charAt(i) == s.charAt(n - i - 1)) && (s.charAt(i) == '6' || s.charAt(i) == '8')))
                return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while(n-->0){
            String s = sc.next();
            System.out.println(check(s)? "YES": "NO");
        }
    }
}
