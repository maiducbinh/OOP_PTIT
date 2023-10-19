
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Hang{
    private String ma, ten;
    private long num, gia, ck, tien;

    Hang(String ma, String ten, long num, long gia, long ck) {
        this.ma = ma;
        this.ten = ten;
        this.num = num;
        this.gia = gia;
        this.ck = ck;
        this.tien = num * gia - ck;
    }

    public long getTien() {
        return tien;
    }
    public String toString(){
        return ma + " " + ten + " " + num + " " + gia + " " + ck + " " + tien;
    }
    
}
public class J05012_TinhTien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Hang> arr = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            Hang x = new Hang(sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine()), Long.parseLong(sc.nextLine()), Long.parseLong(sc.nextLine()));
            arr.add(x);
        }
        arr.sort(Comparator.comparing(Hang::getTien).reversed());
        for(Hang i: arr)
            System.out.println(i);
    }
}
