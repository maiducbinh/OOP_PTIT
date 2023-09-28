/*
import java.util.Scanner;

class PhanSo{
    private long tu, mau;
    PhanSo(long tu, long mau)
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
    public PhanSo cong(PhanSo b)
    {
        long Tu = this.tu * b.mau + this.mau * b.tu;
        long Mau = this.mau * b.mau;
        PhanSo ans = new PhanSo(Tu, Mau);
        ans.toiGian();
        return ans;
    }
    public String toString()
    {
        return tu + "/" + mau;
    }
}
public class J04004_TongPhanSo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhanSo a = new PhanSo(sc.nextLong(), sc.nextLong());
        PhanSo b = new PhanSo(sc.nextLong(), sc.nextLong());
        a.toiGian();
        b.toiGian();
        System.out.println(a.cong(b));
    }
}
