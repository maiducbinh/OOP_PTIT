
/*import java.util.Scanner;

class SinhVien{
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
    
}
public class J05004_DanhSachDoiTuongSV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while(n-->0){
            SinhVien x = new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()));
            System.out.println(x);
        }
    }
}
