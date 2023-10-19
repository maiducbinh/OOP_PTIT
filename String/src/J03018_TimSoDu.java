
import java.math.BigInteger;
import java.util.Scanner;


public class J03018_TimSoDu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            BigInteger n = new BigInteger(sc.nextLine());
            BigInteger m = new BigInteger("4");
            if(n.mod(m).equals(new BigInteger("0")))
                System.out.println(4);
            else System.out.println(0);
        }
    }
}
