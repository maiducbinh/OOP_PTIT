
import java.util.Scanner;

public class thu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long m = sc.nextLong();
            if (n % m != 0) {
                System.out.println("-1\n");
            } else {
                long cnt = 0;
                while (n > 1) {
                    if (n % 2 == 1) {
                        n++;
                    } else {
                        n /= 2;
                    }
                    cnt++;
                }
                System.out.println(cnt);
            }
        }
    }
}
