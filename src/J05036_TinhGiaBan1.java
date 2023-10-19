/*
import java.util.ArrayList;
import java.util.Scanner;

class Hang{
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
        return thanhTien() + Math.round((double)thanhTien() * 2 / 100);
    }
    @Override
    public String toString() {
        return ma + " " + ten + " " + donVi + " " + getPhi() + " " + thanhTien() + " " + giaBan();
    }
    
    
}
public class J05036_TinhGiaBan1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Hang> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            Hang x = new Hang(sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine()), Long.parseLong(sc.nextLine()));
            arr.add(x);
        }
        for(Hang i: arr)
            System.out.println(i);
        
    }
}
