
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
/*class ThiSinh{
    private String name, dob;
    private float d1, d2, d3;

    ThiSinh(String name, String dob, float d1, float d2, float d3) {
        this.name = name;
        this.dob = dob;
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
    }

    @Override
    public String toString() {
        float tong = d1 + d2 + d3;
        String s = "" + tong;
        return name + " " + dob + " " + String.format("%.1f", tong) ;
    }
    
}
public class J04005_KhaiBaoLopThiSinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ThiSinh a = new ThiSinh(sc.nextLine(), sc.next(), sc.nextFloat(), sc.nextFloat(), sc.nextFloat());
        System.out.println(a);
    }
}
