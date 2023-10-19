
import java.util.HashSet;
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
public class J03038_DanhDauChuCai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Character> st = new HashSet<>();
        String s = sc.next();
        for(char x: s.toCharArray())
            st.add(x);
        System.out.println(st.size());
    }
}
