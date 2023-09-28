
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class ThiSinh implements Comparable<ThiSinh>{
    private String ma, ten, danToc;
    private int kv;
    private double diem;
    static int stt = 1;
    public ThiSinh(String ten, double diem, String danToc, int kv) {
        this.ma = String.format("TS%02d", stt++);
        this.ten = ten;
        this.danToc = danToc;
        this.kv = kv;
        this.diem = diem;
        if(kv == 1) this.diem += 1.5;
        else if(kv == 2) this.diem += 1;
        if(!danToc.equals("Kinh"))
            this.diem += 1.5;
    }
    public String chuanHoa(){
        String[] a = this.ten.trim().split("\\s+");
        String ans = "";
        for(String i: a)
            ans += i.substring(0, 1).toUpperCase() + i.substring(1).toLowerCase() + " ";
        return ans.trim();
    }
    
    @Override
    public int compareTo(ThiSinh o) {
        if(this.diem > o.diem) return -1;
        return 1;
    }

    @Override
    public String toString() {
        String tt;
        if(diem >= 20.5) tt = "Do";
        else tt = "Truot";
        return ma + " " + chuanHoa() + " " + String.format("%.1f", diem) + " " + tt;
    }
    
}
public class J07057_DiemTuyenSinh {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner sc = new Scanner(new File("THISINH.in"));
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<ThiSinh> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            ThiSinh x = new ThiSinh(sc.nextLine(), Double.parseDouble(sc.nextLine()), sc.nextLine(), Integer.parseInt(sc.nextLine()));
            arr.add(x);
        }
        Collections.sort(arr);
        for(ThiSinh i: arr)
            System.out.println(i);
    }
}
