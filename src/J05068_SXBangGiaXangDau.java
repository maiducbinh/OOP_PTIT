import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Hang1{
    private String ma;
    private long num;

    public Hang1(String ma, long num) {
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
    public long thanhTien(){
        return (gia() * num + thue());
    }
    public String toString(){
        return ma + " " + hangSX() + " " + gia() + " " + thue() + " " + (gia() * num + thue());
    }
}
public class J05068_SXBangGiaXangDau {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Hang1> arr = new ArrayList<>();
        while(n-->0){
            String[] s = sc.nextLine().split(" ");
            Hang1 x = new Hang1(s[0], Long.parseLong(s[1]));
            arr.add(x);
        }
        arr.sort(Comparator.comparing(Hang1::thanhTien).reversed());
        for(Hang1 i: arr)
            System.out.println(i);
    }
}
