
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
// Loi: lay thua chi tieu neu co nhieu ng = diem trung tuyen

class TS{
    private String ma, ten;
    private double t, l, h;

    public TS(String ma, String ten, double t, double l, double h) {
        this.ma = ma;
        this.ten = ten;
        this.t = t;
        this.l = l;
        this.h = h;
    }
    public String uuTien(){
        if(ma.charAt(2) == '1') return "0.5";
        else if(ma.charAt(2) == '2') return "1";
        return "2.5";
    }
    
    public double tong(){
        return t * 2 + l + h + Double.parseDouble(uuTien());
    }

    public String getMa() {
        return ma;
    }
    
    public String toString(){
        String kq = "";
        if(tong() == (int)tong()) kq += (int)tong();
        else kq = String.format("%.1f", tong());
        return ma + " " + ten + " " + uuTien() + " " + kq;
    }
}
public class J05059_XacDinhDanhSachTrungTuyen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<TS> a = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            TS x = new TS(sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()));
            a.add(x);
        }
        Collections.sort(a, new Comparator<TS>() {
            @Override
            public int compare(TS x, TS y) {
                if(x.tong() != y.tong())
                {
                    if(x.tong() > y.tong()) return -1;
                    return 1;
                }
                return x.getMa().compareTo(y.getMa());
            }
        });
        int ct = Integer.parseInt(sc.nextLine());
        int cnt = 0;
        double diem = 0;
        for(TS i: a){
            if(cnt < ct){
                diem = i.tong();
                cnt++;
            }
            else break;
        }
        System.out.println(String.format("%.1f", diem));
        cnt = 0;
        for(TS i: a){
            if(i.tong() >= diem){
                System.out.println(i + " TRUNG TUYEN");
                
            }
            else System.out.println(i + " TRUOT");
        }
    }
}
