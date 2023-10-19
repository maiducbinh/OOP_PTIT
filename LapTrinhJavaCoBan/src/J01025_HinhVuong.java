
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
public class J01025_HinhVuong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[8];
        for(int i = 0; i < 8; i++)
            a[i] = sc.nextInt();
        int x1, y1, x2, y2;
        x1 = Math.min(a[0], a[4]);
        y1 = Math.min(a[1], a[5]);
        x2 = Math.max(a[2], a[6]);
        y2 = Math.max(a[3], a[7]);
        int side = Math.max(x2 - x1, y2 - y1);
        System.out.println(side * side);
    }
}
