
import java.util.ArrayList;
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
public class J01010_CatDoi {
    public static String Split(String s)
    {
        char[] arr = s.toCharArray();
        for(int i = 0; i < s.length(); i++)
            if(arr[i] == '8' || arr[i] == '9') arr[i] = '0';
            else if(arr[i] != '1' && arr[i] != '0') 
                return "INVALID";
        String ans = "";
        int i = 0;
        while(i < s.length() && arr[i] == '0') i++;
        if(i == s.length()) return "INVALID";
        for(int j = i; j < s.length(); j++) 
            ans += arr[j];
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < t; i++)
        {
            String s = sc.next();
            System.out.println(Split(s));
        }
    }
}
