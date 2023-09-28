
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class ThiSinh implements Comparable<ThiSinh>{
    private String ma, ten, state;

    public void setState(String state) {
        this.state = state;
    }
    private double t, l, h, tong;

    public ThiSinh(String ma, String ten, double t, double l, double h) {
        this.ma = ma;
        this.ten = chuanHoa(ten);
        this.t = t;
        this.l = l;
        this.h = h;
        this.tong = t * 2 + l + h + uuTien();
    }
    public String chuanHoa(String s){
        String ans = "";
        String[] x = s.trim().toLowerCase().split("\\s+");
        for(String i: x)
            ans += i.substring(0, 1).toUpperCase() + i.substring(1) + " ";
        return ans.trim();
    }
    public double uuTien(){
        if(ma.charAt(2) == '1') return 0.5;
        else if(ma.charAt(2) == '2') return 1.0;
        return 2.5;
    }

    public double getTong() {
        return tong;
    }
    public String toString(){
        //double tong = t * 2 + l + h + uuTien();
        String ans;
        if(tong == (int)tong)
            ans = (int)tong + "";
        else ans = String.format("%.1f", tong);
        return ma + " " + ten + " " + (new DecimalFormat().format(uuTien())) + " " + (new DecimalFormat().format(tong)) + " " + state;
    } 
    @Override
    public int compareTo(ThiSinh o) {
        if(this.tong != o.tong){
            if(this.tong > o.tong) return -1;
            else return 1;
        }
        return this.ma.compareTo(o.ma);
    }
    
}
public class J07052_DanhSachTrungTuyen {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("THISINH.in"));
        //Scanner sc = new Scanner(System.in);
        ArrayList<ThiSinh> arr = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            ThiSinh x = new ThiSinh(sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()));
            arr.add(x);
        }
        Collections.sort(arr);
        int chiTieu = Integer.parseInt(sc.nextLine());
        int cnt = 0;
        if (chiTieu > arr.size())
            chiTieu = arr.size();
        double diemChuan = arr.get(chiTieu - 1).getTong();
        System.out.printf("%.1f\n", diemChuan);
        for (ThiSinh i : arr)
        {
            if (i.getTong() >= diemChuan)
                i.setState("TRUNG TUYEN");
            else
                i.setState("TRUOT");
            System.out.println(i);
        }
    }
}
