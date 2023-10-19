
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

class Khach implements Comparable<Khach>{
    private String ten, phong, ma;
    private Date di, den;
    private long dv, ngay, gia;
    static int stt = 1;
    public Khach(String ten, String phong, String di, String den, long dv) throws ParseException {
        this.ma = String.format("KH%02d", stt++);
        this.ten = chuanHoa(ten);
        this.phong = phong;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        this.di = df.parse(di);
        this.den = df.parse(den);
        this.dv = dv;
        this.ngay = (this.den.getTime() - this.di.getTime()) / (1000l * 60 * 60 * 24) + 1;
        this.gia = this.ngay * tang() + dv;
    }
    public String chuanHoa(String s){
        String[] x = s.trim().toLowerCase().split("\\s+");
        String ans = "";
        for(String i: x)
            ans += i.substring(0, 1).toUpperCase() + i.substring(1) + " ";
        return ans.trim();
    }
    public long tang(){
        if(phong.charAt(0) == '1') return 25;
        else if(phong.charAt(0) == '2') return 34;
        else if(phong.charAt(0) == '3') return 50;
        return 80;
    }
    public String toString(){
        return ma + " " + ten + " " + phong.trim() + " " + ngay + " " + gia;
    }
    @Override
    public int compareTo(Khach o) {
        if(this.gia > o.gia) return -1;
        return 1;
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
public class J07051_TinhTienPhong {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        //Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Khach> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            Khach x = new Khach(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine()));
            arr.add(x);
        }
        Collections.sort(arr);
        for(Khach i: arr)
            System.out.println(i);
    }
}
