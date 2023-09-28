
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class ThiSinh implements Comparable<ThiSinh>{
    private int ma;
    private String ten, dob;
    private double m1, m2, m3, tong;
    static int stt = 1;
    public ThiSinh(String ten, String dob, double m1, double m2, double m3) {
        this.ma = stt++;
        this.ten = ten;
        this.dob = dob;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.tong = m1 + m2 + m3;
    }

    public double getTong() {
        return tong;
    }
    
    
    @Override
    public int compareTo(ThiSinh t) {
        if(this.tong != t.tong){
            if(this.tong > t.tong) return -1;
            return 1;
        }
        return this.ma - t.ma;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + dob + " " + tong;
    }
    
    
}
public class J05009_TimThuKhoa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ThiSinh> arr = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            ThiSinh x = new ThiSinh(sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()));
            arr.add(x);
        }
        Collections.sort(arr);
        for(int i = 0; i < n; i++)
            if(arr.get(i).getTong() == arr.get(0).getTong())
                System.out.println(arr.get(i));
    }
}
