
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Hang implements Comparable<Hang>{
    private String ma, ten, donVi;
    private long gia, num;
    static int stt = 1;
    public Hang(String ten, String donVi, long gia, long num) {
        this.ma = String.format("MH%02d", stt++);
        this.ten = ten;
        this.donVi = donVi;
        this.gia = gia;
        this.num = num;
    }
    // Loi: lam tron sai
    public long getPhi(){
        return Math.round(((double)gia * num) * 5 / 100);
    }
    public long thanhTien(){
        return gia * num + getPhi();
    }
    public long giaBan(){
        double price = ((double)(thanhTien() + Math.round((double)thanhTien() * 2 / 100)) / num);
        return (long) Math.ceil((thanhTien() * 1.02 / num) / 100) * 100;
    }
    public int compareTo(Hang t){
        if(this.giaBan() > t.giaBan())
            return -1;
        return 1;
    }
    @Override
    public String toString() {
        return ma + " " + ten + " " + donVi + " " + getPhi() + " " + thanhTien() + " " + giaBan();
    }
    
    
}
public class J05037_TinhGiaBan2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Hang> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            Hang x = new Hang(sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine()), Long.parseLong(sc.nextLine()));
            arr.add(x);
        }
        Collections.sort(arr);
        for(Hang i: arr)
            System.out.println(i);
        
    }
}
