
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class SV1 implements Comparable<SV1>{
    private String ten, ma;
    private double d1, d2, d3, tb;
    static int stt = 1;
    public SV1(String ten, double d1, double d2, double d3) {
        this.ten = chuanHoa(ten);
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
        this.tb = (d1 * 3 + d2 * 3 + d3 * 2) / 8;
        this.ma = String.format("SV%02d", stt++);
    }
    public String chuanHoa(String s){
        String ans = "";
        String[] x = s.trim().toLowerCase().split("\\s+");
        for(String i: x)
            ans += i.substring(0, 1).toUpperCase() + i.substring(1) + " ";
        return ans.trim();
    }

    public double getTb() {
        return tb;
    }
    
    public String toString(){
        return ma + " " + ten + " " + String.format("%.2f", tb);
    }
    
    @Override
    public int compareTo(SV1 o) {
        if(this.tb > o.tb) return -1;
        return 1;
    }
    
}
public class J07054_TinhDiemTrungBinh {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("BANGDIEM.in"));
        //Scanner sc = new Scanner(System.in);
        ArrayList<SV1> arr = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            SV1 x = new SV1(sc.nextLine(), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()));
            arr.add(x);
        }
        Collections.sort(arr);
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if((i == 0) || (i > 0 && arr.get(i).getTb() != arr.get(i - 1).getTb()))
            {
                System.out.println(arr.get(i) + " " + (i + 1));
                cnt = i + 1;
            }
            else System.out.println(arr.get(i) + " " + cnt);
        }
    }
}
