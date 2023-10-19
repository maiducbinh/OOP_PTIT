
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;


public class J07006_SoKhacNhauTrongFile3 {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream sc = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<Integer> a = (ArrayList<Integer>)sc.readObject();
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for(int i: a)
            if(mp.containsKey(i))
                mp.put(i, mp.get(i) + 1);
            else mp.put(i, 1);
        for(int i: mp.keySet())
            System.out.println(i + " " + mp.get(i));
    }
}
