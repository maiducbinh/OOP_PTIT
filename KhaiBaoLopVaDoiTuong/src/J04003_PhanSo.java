/*
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

class PhanSo1{
    private long tu, mau;
    PhanSo1(long tu, long mau)
    {
        this.tu = tu;
        this.mau = mau;
    }
    public long gcd(long a, long b)
    {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    public void toiGian()
    {
        long uoc = gcd(this.tu, this.mau);
        this.tu /= uoc;
        this.mau /= uoc;
    }
    public String toString()
    {
        return tu + "/" + mau;
    }
}
public class J04003_PhanSo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhanSo1 p = new PhanSo1(sc.nextLong(), sc.nextLong());
        p.toiGian();
        System.out.println(p);
    }
}
