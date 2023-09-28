
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class SV implements Comparable<SV>{
    private String ten, loai, ma;
    private double lt, th, thi, tong;
    static int stt = 1;
    public SV(String ten, double lt, double th, double thi) {
        this.ten = chuanHoa(ten);
        this.lt = lt;
        this.th = th;
        this.thi = thi;
        this.tong = lt * 0.25 + th * 0.35 + thi * 0.4;
        if(this.tong >= 8.0) this.loai = "GIOI";
        else if(this.tong >= 6.5) this.loai = "KHA";
        else if(this.tong >= 5.0) this.loai = "TRUNG BINH";
        else this.loai = "KEM";
        this.ma = String.format("SV%02d", stt++);
    }
    public String chuanHoa(String s){
        String ans = "";
        String[] x = s.trim().toLowerCase().split("\\s+");
        for(String i: x)
            ans += i.substring(0, 1).toUpperCase() + i.substring(1) + " ";
        return ans.trim();
    }
    public String toString(){
        return ma + " " + ten + " " + String.format("%.2f", tong) + " " + loai;
    }
    @Override
    public int compareTo(SV o) {
        if(this.tong > o.tong)
            return -1;
        return 1;
    }
    
}
        
public class J07055_BangDiem {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("BANGDIEM.in"));
        //Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<SV> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            SV x = new SV(sc.nextLine(), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()));
            arr.add(x);
        }
        Collections.sort(arr);
        for(SV i: arr)
            System.out.println(i);
    }
}
