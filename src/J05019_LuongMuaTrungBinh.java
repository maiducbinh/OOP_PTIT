
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

class Tram{
    private String ten, ma;
    SimpleDateFormat df = new SimpleDateFormat("HH:mm");
    private Date st, end;
    static int stt = 1;
    private int luong;
    private double time;
    public Tram(String ten, String st, String end, int luong) throws ParseException {
        this.ten = ten;
        this.st = df.parse(st);
        this.end = df.parse(end);
        this.luong = luong;
        this.ma = String.format("T%02d", stt++);
        time = (double)(this.end.getTime() - this.st.getTime()) / (1000 * 60 * 60);
    }
    
    public void addLuong(int n){
        luong += n;
    }

    public String getTen() {
        return ten;
    }
    public void addTime(String s, String e) throws ParseException{
        Date x = df.parse(s);
        Date y = df.parse(e);
        time += (double)(y.getTime() - x.getTime()) / (1000 * 60 * 60);
    }
    public double getLuongTB(){
        return (double)luong / time;
    }
    
    public String toString(){
        return ma + " " + ten + " " + String.format("%.2f", getLuongTB());
    }
}
public class J05019_LuongMuaTrungBinh {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Tram> a = new ArrayList<>();
        HashSet<String> se = new HashSet<>();
        for(int i = 0; i < n; i++){
            String ten = sc.nextLine();
            String st = sc.nextLine();
            String end = sc.nextLine();
            int num = Integer.parseInt(sc.nextLine());
            boolean ok = false;
            for(Tram j: a)
                if(j.getTen().equals(ten)){
                    j.addLuong(num);
                    j.addTime(st, end);
                    ok = true;
                    break;
                }
            if(!ok){
                Tram x = new Tram(ten, st, end, num);
                a.add(x);
            }
        }
        for(Tram i: a)
        {
            System.out.println(i);
        }
    }
}
