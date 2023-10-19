
import java.math.BigInteger;
import java.util.Scanner;


public class J03016_ChiaHetCho11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            BigInteger a = new BigInteger(sc.next());
            BigInteger b = new BigInteger("11");
            BigInteger ans = a.mod(b);
            if(ans.equals(new BigInteger("0")))
                System.out.println("1");
            else System.out.println("0");
        }
    }
}
