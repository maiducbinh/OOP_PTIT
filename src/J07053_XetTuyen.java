
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Examinee{
    private String ten, dob, ma;
    private double lt, th;
    static int stt = 1;
    public Examinee(String ten, String dob, double lt, double th) {
        this.ten = chuanHoa(ten);
        this.dob = dob;
        this.lt = lt;
        this.th = th;
        this.ma = String.format("PH%02d", stt++);
    }
    public String chuanHoa(String s){
        String ans = "";
        String[] x = s.trim().toLowerCase().split("\\s+");
        for(String i: x)
            ans += i.substring(0, 1).toUpperCase() + i.substring(1) + " ";
        return ans.trim();
    }
    public double thuong(){
        if(lt >= 8 && th >= 8) return 1;
        else if(lt >= 7.5 && th >= 7.5) return 0.5;
        return 0;
    }
    public int getTB(){
        double tong = (th + lt) / 2 + thuong();
        if(tong > 10) tong = 10;
        return (int)Math.round(tong);
    }
    public int getTuoi(){
        String[] x = dob.split("/");
        return 2021 - Integer.parseInt(x[2]);
    }
    public String toString()
    {
        String loai = "";
        if(getTB() < 5) loai = "Truot";
        else if(getTB() <= 6) loai = "Trung binh";
        else if(getTB() == 7) loai = "Kha";
        else if(getTB() == 8) loai = " Gioi";
        else if(getTB() == 9 || getTB() == 10) loai = "Xuat sac";
        return ma + " " + ten + " " + getTuoi() + " " + getTB() + " " + loai;
    }

}
public class J07053_XetTuyen {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("XETTUYEN.in"));
        //Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while(n-->0){
            Examinee x = new Examinee(sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()));
            System.out.println(x);
        }
    }
}
