
import java.util.Scanner;

class PhanSo{
    // Loi: kieu du lieu
    private long tu, mau;
    PhanSo(long tu, long mau){
        this.tu = tu;
        this.mau = mau;
    }
    public long gcd(long a, long b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    public void rutGon(){
        long g = gcd(this.tu, this.mau);
        this.tu /= g;
        this.mau /= g;
    }
    public PhanSo cong(PhanSo b){
        long msc = this.mau * b.mau / gcd(this.mau, b.mau);
        long t = this.tu * (msc / this.mau) + b.tu * (msc / b.mau);
        PhanSo kq = new PhanSo(t, msc);
        kq.rutGon();
        return kq;
    }
    public PhanSo nhan(PhanSo b){
        long t = this.tu * b.tu;
        long m = this.mau * b.mau;
        PhanSo kq = new PhanSo(t, m);
        kq.rutGon();
        return kq;
    }

    @Override
    public String toString() {
        return tu + "/" + mau;
    }
    
}
public class J04014_TinhToanPhanSo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-->0){
            PhanSo a = new PhanSo(sc.nextLong(), sc.nextLong());
            a.rutGon();
            PhanSo b = new PhanSo(sc.nextLong(), sc.nextLong());
            b.rutGon();
            PhanSo c = (a.cong(b)).nhan(a.cong(b));
            PhanSo d = a.nhan(b.nhan(c));
            System.out.println(c + " " + d);
        }
    }
}
