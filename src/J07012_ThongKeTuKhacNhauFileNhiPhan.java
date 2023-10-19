
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class J07012_ThongKeTuKhacNhauFileNhiPhan {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream sc = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<String> arr = (ArrayList<String>) sc.readObject();
        ArrayList<String> ans = new ArrayList<>();
        HashMap<String, Integer> mp = new HashMap<>();
        for (String i : arr) {
            String[] x = i.toLowerCase().split("\\W+");
            for (String j : x) {
                //Them dieu kien j co the = ""
                if(j.equals("")) continue;
                if (mp.containsKey(j)) {
                    mp.put(j, mp.get(j) + 1);
                } else {
                    mp.put(j, 1);
                    ans.add(j);
                }
            }
        }
        Collections.sort(ans, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (mp.get(o2) != mp.get(o1)) {
                    if(mp.get(o1) > mp.get(o2)) return -1;
                    else return 1;
                }
                return o1.compareTo(o2);
            }
        });
        for (String i : ans) {
            System.out.println(i + " " + mp.get(i));
        }
    }
}
