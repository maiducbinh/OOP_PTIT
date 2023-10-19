
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class KH implements Comparable<KH>{
    private String ten, ma;
    private char loai;
    private long dau, cuoi, tong, so;
    static int stt = 1;
    public KH(String ten, char loai, long dau, long cuoi) {
        this.ma = String.format("KH%02d", stt++);
        this.ten = chuanHoa(ten);
        this.loai = loai;
        this.dau = dau;
        this.cuoi = cuoi;
        this.so = cuoi - dau;
        this.tong = tienTrong() + tienVuot() + thue();
    }
    public String chuanHoa(String s){
        String ans = "";
        String[] x = s.trim().toLowerCase().split("\\s+");
        for(String i: x)
            ans += i.substring(0, 1).toUpperCase() + i.substring(1) + " ";
        return ans.trim();
    }
    public long dinhMuc(){
        if(loai == 'A') return 100;
        else if(loai == 'B') return 500;
        return 200;
    }
    public long tienTrong(){
        if(so < dinhMuc()) return so * 450;
        return dinhMuc() * 450;
    }
    public long tienVuot(){
        if(so > dinhMuc()) return (so - dinhMuc()) * 1000;
        return 0;
    }
    public long thue(){
        return tienVuot() * 5 / 100;
    }
    public String toString(){
        return ma + " " + ten + " " + tienTrong() + " " + tienVuot() + " " + thue() + " " + tong; 
    }
    @Override
    public int compareTo(KH o) {
        if(this.tong > o.tong)
            return -1;
        return 1;
    }
    
}
public class J07056_TinhTienDien {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        //Scanner sc = new Scanner(System.in);
        ArrayList<KH> arr = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            KH x = new KH(sc.nextLine(), sc.next().charAt(0), Long.parseLong(sc.next()), Long.parseLong(sc.next()));
            sc.nextLine();
            arr.add(x);
        }
        Collections.sort(arr);
        for(KH i: arr)
            System.out.println(i);
    }
}
