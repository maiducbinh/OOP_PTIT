
import java.util.Scanner;

class SoPhuc{
    private long a, b;
    SoPhuc(){
        
    }
    SoPhuc(long a, long b){
        this.a = a;
        this.b = b;
    }
    public SoPhuc cong(SoPhuc x){
        SoPhuc ans = new SoPhuc();
        ans.a = this.a + x.a;
        ans.b = this.b + x.b;
        return ans;
    }
    public SoPhuc nhan(SoPhuc x){
        SoPhuc ans = new SoPhuc();
        ans.a = this.a * x.a - this.b * x.b;
        ans.b = this.a * x.b + this.b * x.a;
        return ans;
    }

    @Override
    public String toString() {
        String ans = "";
        ans += Long.toString(a) + " ";
        if(b > 0) ans += "+ ";
        else ans += "- ";
        ans += Math.abs(b) + "i";
        return ans;
    }
    
}
public class J04018_SoPhuc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            SoPhuc x = new SoPhuc(sc.nextLong(), sc.nextLong());
            SoPhuc y = new SoPhuc(sc.nextLong(), sc.nextLong());
            SoPhuc c = (x.cong(y)).nhan(x);
            SoPhuc d = (x.cong(y)).nhan(x.cong(y));
            System.out.println(c + ", " + d);
        }
    }
}
