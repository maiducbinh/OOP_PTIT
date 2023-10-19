import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class SinhVien implements Comparable<SinhVien>{
    private String ma, ten, dob, lop;
    private double gpa;
    static int stt = 1;

    public SinhVien(String ten, String lop, String dob, double gpa) {
        this.ma = String.format("B20DCCN%03d", stt++);
        this.ten = ten;
        String[] a = dob.split("/");
        this.dob = String.format("%02d/%02d/%04d", Integer.parseInt(a[0]), Integer.parseInt(a[1]), Integer.parseInt(a[2]));
        this.lop = lop;
        this.gpa = gpa;
    }
    public String chuanHoa(String s){
        String[] ans = s.trim().split("\\s+");
        String res = "";
        for(int i = 0; i < ans.length; i++)
            res += ans[i].substring(0, 1).toUpperCase() + ans[i].substring(1).toLowerCase() + " ";
        res.trim();
        return res;
    }
    @Override
    public String toString() {
        return ma + " " + chuanHoa(ten) + " " + lop + " " + dob + " " + String.format("%.2f", gpa);
    }

    public double getGpa() {
        return gpa;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getDob() {
        return dob;
    }

    public String getLop() {
        return lop;
    }

    public static int getStt() {
        return stt;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public static void setStt(int stt) {
        SinhVien.stt = stt;
    }

    @Override
    public int compareTo(SinhVien t) {
        if(this.gpa > t.gpa)
            return -1;
        return 1;
    }
    
}
public class J05005_SV3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SinhVien> arr = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++)
        {
            SinhVien x = new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()));
            arr.add(x);
        }
        Collections.sort(arr);
        for(SinhVien i: arr)
            System.out.println(i);
    }
}
