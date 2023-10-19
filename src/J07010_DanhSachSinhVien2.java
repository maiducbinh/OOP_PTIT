import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class SinhVien{
    private String msv, name, lop, dob;
    private double gpa;
    static int cnt = 1;
    SinhVien(String name, String lop, String dob, double gpa)
    {
        this.msv = "B20DCCN" + String.format("%03d", cnt);
        cnt++;
        this.name = name;
        this.lop = lop;
        this.dob = dob;
        this.gpa = gpa;
    }
    public void chuanHoa(){
        String[] t = this.dob.split("/");
        String ans = "";
        while(t[0].length() < 2) t[0] = "0" + t[0];
        while(t[1].length() < 2) t[1] = "0" + t[1];
        while(t[2].length() < 4) t[2] = "0" + t[2];
        ans = t[0] + "/" + t[1] + "/" + t[2];
        this.dob = ans;
    }
    @Override
    public String toString() {
        return msv + " " + name + " " + lop + " " + dob + " " + String.format("%.2f", gpa);
    }

    
}
public class J07010_DanhSachSinhVien2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SV.in"));
        //Scanner sc = new Scanner(System.in);
        // Loi do nhap lien quan den String => de sc.nextLine() o dau vong lap
        ArrayList<SinhVien> a = new ArrayList<>();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++)
        {
            sc.nextLine();
            SinhVien x = new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextDouble());
            //sc.nextLine();
            x.chuanHoa();
            a.add(x);
        }
        for(SinhVien i: a)
            System.out.println(i);
    }
}