
import java.util.Scanner;


public class J01020_DayDuCacChuSo {
    public static boolean check(long x){
        String s = x + "";
        int a[] = new int[20];
        for(char i: s.toCharArray()) a[i - '0']++;
        for(int i = 0; i <= 9; i++)
            if(a[i] == 0) return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            long n = sc.nextLong();
            if(n == 0){
                System.out.println("Impossible");
                continue;
            }
            int dd[] = new int[20];
            for(int i = 1;; i++){
                long m = n * i;
                String s = "" + m;
                for(char j: s.toCharArray())
                    dd[j - '0']++;
                boolean ok = true;
                for(int j = 0; j <= 9; j++)
                    if(dd[j] == 0) ok = false;
                if(ok) {
                    System.out.println(m);
                    break;
                }
            }
        }
    }
}
