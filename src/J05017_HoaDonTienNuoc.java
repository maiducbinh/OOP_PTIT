
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
// Loi: 
class KH{
    private String ma, ten;
    private long cu, moi, so;
    static int stt = 1;

    public KH(String ten, long cu, long moi) {
        this.ten = ten;
        this.cu = cu;
        this.moi = moi;
        so = moi - cu;
        this.ma = String.format("KH%02d", stt++);
    }
    
    public double tien(){
        if(so <= 50) return (double)(so * 100) * (102) / 100;
        else if(so <= 100) return (double)((so - 50) * 150 + 100 * 50) * 103 / 100;
        return (double)((so - 100) * 200 + 50 * 100 + 50 * 150) * 105 / 100;
    }
    
    public String toString(){
        return ma + " " + ten + " " + String.format("%.0f", tien());
    }
}
public class J05017_HoaDonTienNuoc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<KH> a = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            KH x = new KH(sc.nextLine(), Long.parseLong(sc.nextLine()), Long.parseLong(sc.nextLine()));
            a.add(x);
        }
        a.sort(Comparator.comparing(KH::tien).reversed());
        for(KH i: a)
        {
            System.out.println(i);
        }
    }
}
