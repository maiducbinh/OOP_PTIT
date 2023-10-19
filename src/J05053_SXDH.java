
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class DonHang implements Comparable<DonHang>{
    private String ten, ma, stt;
    private long gia, num;

    public DonHang(String ten, String ma, long gia, long num) {
        this.ten = ten;
        this.ma = ma;
        this.gia = gia;
        this.num = num;
        this.stt = ma.substring(1, 4);
    }
    public long giamGia(){
        if(ma.charAt(4) == '1') return gia * num / 2;
        return gia * num * 30 / 100;
    }
    public long thanhTien(){
        return gia * num - giamGia();
    }
    public String toString(){
        return ten + " " + ma + " " + stt + " " + giamGia() + " " + thanhTien();
    }

    @Override
    public int compareTo(DonHang o) {
        return this.stt.compareTo(o.stt);
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
public class J05053_SXDH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<DonHang> arr = new ArrayList<>();
        while(n-->0){
            DonHang x = new DonHang(sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine()), Long.parseLong(sc.nextLine()));
            arr.add(x);
        }
        Collections.sort(arr);
        for(DonHang i: arr)
            System.out.println(i);
    }
}
