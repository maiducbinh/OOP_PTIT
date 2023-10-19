
import java.util.Scanner;

class DaThuc{
    private int[] a = new int[10005];
    DaThuc(String s){
        String[] x = s.split("[ *x^+]+");
        for(int i = 0; i < x.length - 1; i += 2){
            a[Integer.parseInt(x[i + 1])] = Integer.parseInt(x[i]);
        }
    }
    DaThuc(){
        
    }
    public DaThuc cong(DaThuc x){
        DaThuc ans = new DaThuc();
        for(int i = 0; i <= 10000; i++)
            ans.a[i] = x.a[i] + this.a[i];
        return ans;
    }
    public String toString(){
        String ans = "";
        for(int i = 10000; i >= 0; i--)
            if(a[i] != 0)
                ans += a[i] + "*x^" + i + " + ";
        return ans.substring(0, ans.length() - 3);
    }
}
public class J05063_TongDaThuc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            DaThuc p = new DaThuc(sc.nextLine());
            DaThuc q = new DaThuc(sc.nextLine());
            DaThuc r = p.cong(q);
            System.out.println(r);
        }
    }
}
