
import java.util.Scanner;

class SinhVien{
    private String msv, ten, lop, dob;
    private double gpa;
    
    SinhVien(String ten, String lop, String dob, double gpa) {
        this.msv = "B20DCCN001";
        this.ten = ten;
        this.lop = lop;
        this.dob = dob;
        this.gpa = gpa;
    }
    public String chuanHoa(String ngay)
    {
        String ans = "";
        String[] s = ngay.split("/");
        while(s[0].length() < 2) s[0] = "0" + s[0];
        ans += s[0] + "/";
        while(s[1].length() < 2) s[1] = "0" + s[1];
        ans += s[1] + "/";
        while(s[2].length() < 4) s[2] = "0" + s[2];
        ans += s[2];
        return ans;
    }

    @Override
    public String toString() {
        String ns = chuanHoa(this.dob);
        return this.msv + " " + this.ten + " " + this.lop + " " + ns + " " + String.format("%.2f", this.gpa);
    }
    
}
public class J04006_KhaiBaoLopSinhVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ten = sc.nextLine();
        String lop = sc.next();
        String dob = sc.next();
        double gpa = sc.nextDouble();
        SinhVien a = new SinhVien(ten, lop, dob, gpa);
        System.out.println(a);
    }
}
