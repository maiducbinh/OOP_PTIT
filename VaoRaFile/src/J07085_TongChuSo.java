
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.util.ArrayList;


public class J07085_TongChuSo {
    public static long tong(String s){
        long ans = 0;
        for(char i: s.toCharArray())
            ans += i - '0';
        return ans;
    }
    public static String so(String s){
        String ans = "";
        for(int i = 0; i < s.length(); i++)
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') ans += s.substring(i, i + 1);
        String tmp = ans;
        // Loi: xu li so 0
        BigInteger a = new BigInteger(ans);
        return a.toString();
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream sc = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<String> arr = (ArrayList<String>)sc.readObject();
        for(String i: arr){
            String x = so(i);
            System.out.println(x + " " + tong(x));
        }
    }
}
