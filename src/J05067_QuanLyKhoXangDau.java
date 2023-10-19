
import java.util.Scanner;

class Hang{
    private String ma;
    private long num;

    public Hang(String ma, long num) {
        this.ma = ma;
        this.num = num;
    }
    public String hangSX(){
        String t = ma.substring(ma.length() - 2);
        if(t.equals("BP")) return "British Petro";
        else if(t.equals("ES")) return "Esso";
        else if(t.equals("SH")) return "Shell";
        else if(t.equals("CA")) return "Castrol";
        else if(t.equals("MO")) return "Mobil";
        return "Trong Nuoc";
    }
    public long gia(){
        char x = ma.charAt(0);
        if(x == 'X') return 128000;
        else if(x == 'D') return 11200;
        return 9700;
    }
    public long thue(){
        if(hangSX().equals("Trong Nuoc")) return 0;
        char x = ma.charAt(0);
        if(x == 'X') return gia() * num * 3 / 100;
        else if(x == 'D') return (long)(gia() * num * 0.035);
        return (long) (gia() * num * 0.02);
    }
    public String toString(){
        return ma + " " + hangSX() + " " + gia() + " " + thue() + " " + (gia() * num + thue());
    }
}
public class J05067_QuanLyKhoXangDau {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while(n-->0){
            String[] s = sc.nextLine().split(" ");
            Hang x = new Hang(s[0], Long.parseLong(s[1]));
            System.out.println(x);
        }
    }
}
