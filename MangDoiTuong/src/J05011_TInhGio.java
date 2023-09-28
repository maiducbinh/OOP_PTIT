
import java.util.*;

class Gamer implements Comparable<Gamer>{
    private String ma, ten, in, out;
    private int time;
    public Gamer(String ma, String ten, String in, String out) {
        this.ma = ma;
        this.ten = ten;
        this.in = in;
        this.out = out;
    }
    
    public int getTime(){
        String[] a = in.split(":");
        int vao = Integer.parseInt(a[0]) * 60 + Integer.parseInt(a[1]);
        String[] b = out.split(":");
        int ra = Integer.parseInt(b[0]) * 60 + Integer.parseInt(b[1]);
        time = ra - vao;
        return time;
    }
    @Override
    public int compareTo(Gamer t) {
        return -(this.getTime() - t.getTime());
    }

    @Override
    public String toString() {
        int h = getTime();
        return ma + " " + ten + " " + h / 60 + " gio " + h % 60 + " phut";
    }
    
}
public class J05011_TInhGio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Gamer> arr = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            Gamer x = new Gamer(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            arr.add(x);
        }
        Collections.sort(arr);
        for(Gamer i: arr)
            System.out.println(i);
    }
}
