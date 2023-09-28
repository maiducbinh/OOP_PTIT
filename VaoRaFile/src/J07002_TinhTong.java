
import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Character.isDigit;
import java.util.Scanner;


public class J07002_TinhTong {
    public static boolean check(String s)
    {
        if(s.length() > 9) return false;
        for(char i: s.toCharArray())
            if(!isDigit(i))
                return false;
        return true;
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        long sum = 0;
        while(sc.hasNext())
        {
            String s = sc.next();
            if(check(s))
            {
                sum += Integer.parseInt(s);
            }
        }
        System.out.println(sum);
    }
}
