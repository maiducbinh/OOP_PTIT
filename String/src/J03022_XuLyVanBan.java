
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 84912
 */
public class J03022_XuLyVanBan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "";
        while(sc.hasNextLine())
            s += sc.nextLine();
        String[] a = s.split("[.?!]");
        for(String i: a){
            String[] b = i.trim().toLowerCase().split("\\s+");
            b[0] = b[0].substring(0, 1).toUpperCase() + b[0].substring(1);
            for(String j: b)
                System.out.print(j + " ");
            System.out.println("");
        }
    }
}
