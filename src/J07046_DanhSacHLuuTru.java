import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

class KhachHang implements Comparable<KhachHang>{
    private String ma, ten, phong;
    private int ngay;
    static int stt = 1;
    private Date den, di;
    public KhachHang(String ten, String phong, String den, String di) throws ParseException {
        this.ma = String.format("KH%02d", stt++);
        this.ten = ten;
        this.phong = phong;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        this.den = df.parse(den);
        this.di = df.parse(di);
        // Loi: mat mat du lieu khi doi kieu du lieu, nen tinh xong moi chuyen sang int
        this.ngay = (int)((this.di.getTime() - this.den.getTime()) / (1000 * 60 * 60 * 24)); //tinh theo don vi mili giay
    }
    public String toString(){
        return ma + " " + ten + " " + phong + " " + ngay;
    }

    @Override
    public int compareTo(KhachHang o) {
        return (int)(o.ngay - this.ngay);
    }
}
public class J07046_DanhSacHLuuTru {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("KHACH.in"));
        //Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<KhachHang> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            KhachHang x = new KhachHang(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            arr.add(x);
        }
        Collections.sort(arr);
        for(KhachHang i: arr)
            System.out.println(i);
    }
}