
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;


public class J07015_SoNguyenToFileNhiPhan {
    public static boolean prime(int x)
    {
        if(x < 2) return false;
        for(int i = 2; i <= Math.sqrt(x); i++)
            if(x % i == 0) return false;
        return true;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream sc = new ObjectInputStream(new FileInputStream("SONGUYEN.in"));
        ArrayList<Integer> a = (ArrayList<Integer>) sc.readObject();
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for(int i: a)
            if(prime(i) == true)
            {
                if(mp.containsKey(i)) mp.put(i, mp.get(i) + 1);
                else mp.put(i, 1);
            }
        for(int i: mp.keySet())
            System.out.println(i + " " + mp.get(i));
    }
}
