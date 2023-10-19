
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Obj implements Comparable<Obj>{
    private String ma;
    private int nhap;
    Obj(String ma, int nhap){
        this.ma = ma;
        this.nhap = nhap;
    }
    public int xuat(){
        if(this.ma.charAt(0) == 'A') return (int)Math.round((double)nhap * 0.6);
        return (int)Math.round((double)nhap * 0.7);
    }
    public int donGia(){
        if(this.ma.charAt(4) == 'Y') return 110000;
        return 135000;
    }
    public long tien(){
        return (long)xuat() * donGia();
    }
    public char getNhom(){
        return ma.charAt(0);
    }
    /*
    Nếu Mã hàng có ký tự đầu là A và ký tự cuối là Y thì Thuế = 8% của Tiền
Nếu Mã hàng có ký tự đầu là A và ký tự cuối là N thì Thuế = 11% của Tiền
Nếu Mã hàng có ký tự đầu là B và ký tự cuối là Y thì Thuế = 17% của Tiền
Nếu Mã hàng có ký tự đầu là B và ký tự cuối là N thì Thuế = 22% của Tiền.
    */
    public long thue(){
        if(ma.charAt(0) == 'A' && ma.charAt(4) == 'Y') return (long)Math.round((double)tien() * 0.08);
        else if(ma.charAt(0) == 'A' && ma.charAt(4) == 'N') return (long)Math.round((double)tien() * 0.11);
        else if(ma.charAt(0) == 'B' && ma.charAt(4) == 'Y') return (long)Math.round((double)tien() * 0.17);
        return (long)Math.round((double)tien() * 0.22);
    }
    public int compareTo(Obj t){
        if(this.thue() > t.thue()) return -1;
        return 1;
    }
    public String toString(){
        return ma + " " + nhap + " " + xuat() + " " + donGia() + " " + tien() + " " + thue();
    }
}
public class J05049_LietKeNhapXuatHangTheoNhom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Obj> arr = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            Obj x = new Obj(sc.nextLine(), Integer.parseInt(sc.nextLine()));
            arr.add(x);
        }
        //Collections.sort(arr);
        //char nhom = sc.nextLine().charAt(0);
        for(Obj i: arr)
            System.out.println(i);
    }
}
