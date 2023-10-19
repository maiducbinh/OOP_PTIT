/*
import java.util.Scanner;

class NhanVien{
    private String ma, ten, gioiTinh, dob, addr, thue, hd;
    static int stt = 1;
    public NhanVien(Scanner sc) {
        this.ma = String.format("%05d", stt++);
        this.ten = sc.nextLine();
        this.gioiTinh = sc.nextLine();
        this.dob = sc.nextLine();
        this.addr = sc.nextLine();
        this.thue = sc.nextLine();
        this.hd = sc.nextLine();
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + gioiTinh + " " + dob + " " + addr + " " + thue + " " + hd;
    }
    
}
public class J05006_NV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while(n-->0){
            NhanVien x = new NhanVien(sc);
            System.out.println(x);
        }
    }
}
