
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;
import java.util.*;


public class J07040_LietKeTheoThuTuXuatHien {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream sc1 = new ObjectInputStream(new FileInputStream("NHIPHAN.in"));
        Scanner sc2 = new Scanner(new File("VANBAN.in"));
        ArrayList<String> a = (ArrayList<String>)sc1.readObject();
        LinkedHashMap<String, Integer> mp = new LinkedHashMap<>();
        while(sc2.hasNextLine()){
            String x = sc2.nextLine();
            String[] arr = x.trim().toLowerCase().split("\\s+");
            for(String j: arr)
                mp.put(j, 1);
        }
        for(String i: a)
        {
            String x = i;
            x = x.trim().toLowerCase();
            String[] arr = x.split("\\s+");
            for(String j: arr)
                if(mp.containsKey(j) && mp.get(j) == 1)
                    mp.put(j, 2);
        }
        for(String i: mp.keySet())
            if(mp.get(i) == 2)
                System.out.println(i);
    }
}
