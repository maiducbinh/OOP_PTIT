
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class SV{
    private String ten, lop, ma;
    private Date dob;
    private double gpa;
    static int stt = 1;
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    SV(String ten, String lop, String dob, double gpa) throws ParseException{
        this.ten = chuanHoa(ten);
        this.lop = lop;
        this.ma = String.format("B20DCCN%03d", stt++);
        this.dob = df.parse(dob);
        this.gpa = gpa;
    }
    public String chuanHoa(String s){
        String[] x = s.trim().toLowerCase().split("\\s+");
        String ans = "";
        for(String i: x)
            ans += i.substring(0, 1).toUpperCase() + i.substring(1) + " ";
        return ans.trim();
    }
    public String toString(){
        return ma + " " + ten + " " + lop + " " + df.format(dob) + " " + String.format("%.2f", gpa);
    }
}
public class J07018_ChuanHoaDanhSachSinhVien {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int n = Integer.parseInt(sc.nextLine());
        while(n-->0){
            SV x = new SV(sc.nextLine(), sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()));
            System.out.println(x);
        }
    }
}
