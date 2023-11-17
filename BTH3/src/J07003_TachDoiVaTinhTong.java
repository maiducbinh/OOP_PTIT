
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class J07003_TachDoiVaTinhTong {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        String s = sc.next();
        while(s.length() != 1){
            BigInteger a = new BigInteger(s.substring(0, s.length() / 2));
            BigInteger b = new BigInteger(s.substring(s.length() / 2));
            s = a.add(b).toString();
            System.out.println(s);
        }
    }
}
