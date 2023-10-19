
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;


public class J07005_SoKhacNhau2 {
    public static void main(String[] args) throws IOException {
        File file = new File("DATA.IN");
        Scanner sc = new Scanner(file);
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        int n = (int)1e5;
        while(n-->0)
        {
            int x = sc.nextInt();
            if(mp.containsKey(x)) mp.put(x, mp.get(x) + 1);
            else mp.put(x, 1);
        }
        for(int i: mp.keySet())
            System.out.println(i + " " + mp.get(i));
        sc.close();
    }
}
