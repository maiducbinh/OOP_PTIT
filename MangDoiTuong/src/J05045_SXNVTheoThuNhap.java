
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class NhanVien implements Comparable<NhanVien>{
    private String ten, chucVu, ma;
    private long spd, ngay;
    static int stt = 1;
    public NhanVien(String ten, String chucVu, long spd, long ngay) {
        this.ten = ten;
        this.chucVu = chucVu;
        this.spd = spd;
        this.ngay = ngay;
        this.ma = String.format("NV%02d", stt++);
    }
    public long luong(){
        return this.spd * this.ngay;
    }
    /*
    Phụ cấp chức vụ được quy định như sau (đơn vị nghìn đồng):

GD: 500
PGD: 400
TP: 300
KT: 250
Các trường hợp khác: 100.
    */
    public long phuCap(){
        if(this.chucVu.equals("GD")) return 500;
        else if(this.chucVu.equals("PGD")) return 400;
        else if(this.chucVu.equals("TP")) return 300;
        else if(this.chucVu.equals("KT")) return 250;
        return 100;
    }
    /*
    Mỗi tháng sẽ có tạm ứng. Quy tắc tính tạm ứng như sau:

Nếu (Phụ cấp chức vụ + Lương)*2/3 < 25000 thì  Tạm ứng = (Phụ cấp chức vụ + Lương)*2/3 (làm tròn - round - đến hàng ngàn)
Ngược lại:  Tạm ứng = 25000
    */
    public long tamUng(){
        double x = (double)(phuCap() + luong()) * 2 / 3;
        if(x < 25000) return (long)Math.round((double)x / 1000) * 1000;
        return 25000;
    }
    public long conLai(){
        return luong() + phuCap() - tamUng();
    }
    public String toString(){
        return ma + " " + ten + " " + phuCap() + " " + luong() + " " + tamUng() + " " + conLai();
    }
    // Loi: so sanh nham 
    @Override
    public int compareTo(NhanVien t) {
        if(this.luong() + this.phuCap() > t.luong() + t.phuCap()) return -1;
        return 1;
    }
}
public class J05045_SXNVTheoThuNhap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<NhanVien> arr = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            NhanVien x = new NhanVien(sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine()), Long.parseLong(sc.nextLine()));
            arr.add(x);
        }
        Collections.sort(arr);
        for(NhanVien i: arr)
            System.out.println(i);
    }
}
