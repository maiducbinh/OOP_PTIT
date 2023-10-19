
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class TS2{
    private String ten, dob, ma;
    private double lt, th;
    private int dtb, age;
    static int stt = 1;
    public TS2(String ten, String dob, double lt, double th) {
        this.ten = ten;
        this.dob = dob;
        this.age = 2021 - Integer.parseInt(dob.substring(dob.length() - 4));
        this.lt = lt;
        this.th = th;
        this.ma = String.format("PH%02d", stt++);
        this.dtb = (int) (Math.round((lt + th) / 2) + thuong());
        if(dtb > 10) dtb = 10;
    }
    public double thuong(){
        if(lt >= 8 && th >= 8) return 1;
        else if(lt >= 7.5 && th >= 7.5) return 0.5;
        return 0;
    }
    public String xepLoai(){
        if(dtb < 5) return "Truot";
        else if(dtb >= 5 && dtb <= 6) return "Trung binh";
        else if(dtb == 7) return "Kha";
        else if(dtb == 8) return "Gioi";
        return "Xuat sac";
    }
    public String toString(){ 
        return ma + " " + ten + " " + age + " " + dtb + " " + xepLoai();
    }

    public int getDtb() {
        return dtb;
    }
}
public class J05061_SXKQXT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<TS2> arr = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            TS2 x = new TS2(sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()));
            arr.add(x);
        }
        arr.sort(Comparator.comparing(TS2::getDtb).reversed());
        for(TS2 i: arr)
            System.out.println(i);
    }
}
