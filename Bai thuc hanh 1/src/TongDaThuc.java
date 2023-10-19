
import java.util.Scanner;

class DaThuc{
    private int[] p;
    private String s;
    DaThuc(String str){
        p = new int[10005];
        String s = str;
        s = s.replace('*', ' ');
        s = s.replace('x', ' ');
        s = s.replace('^', ' ');
        s = s.replace('+', ' ');
        String[] t = s.split("\\s+");
        for(int i = 0; i + 1 < t.length; i += 2)
            p[Integer.parseInt(t[i + 1])] = Integer.parseInt(t[i]);
    }

    private DaThuc() {
        p = new int[100005];
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public DaThuc cong(DaThuc x){
        DaThuc res = new DaThuc();
        for(int i = 10000; i >= 0; i--)
            res.p[i] = this.p[i] + x.p[i];
        return res;
    }
    public void out(){
        String s = "";
        for(int i = 10000; i >= 0; i--)
            if(this.p[i] != 0)
                s += (p[i] + "*x^" + i + " + ");
        System.out.println(s.substring(0, s.length() - 3));
    }
}
public class TongDaThuc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);       
            DaThuc p = new DaThuc(sc.nextLine());
            DaThuc q = new DaThuc(sc.nextLine());
            DaThuc r = p.cong(q);
            r.out();
    }
}
