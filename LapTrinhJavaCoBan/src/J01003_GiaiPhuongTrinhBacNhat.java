
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
public class J01003_GiaiPhuongTrinhBacNhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, b;
        a = sc.nextDouble();
        b = sc.nextDouble();
        if(a == 0)
        {
            if(b != 0)
                System.out.println("VN");
            else System.out.println("VSN");
        }
        else
        {
            System.out.printf("%.2f", -b/a);
        }
    }
}
