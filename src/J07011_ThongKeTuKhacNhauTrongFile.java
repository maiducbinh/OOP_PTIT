
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class J07011_ThongKeTuKhacNhauTrongFile {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("VANBAN.in"));
        //Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, Long> mp = new HashMap<>();
        ArrayList<String> arr = new ArrayList<>();
        String s = "";
        while (n-- > 0) {
            s += sc.nextLine() + " ";
        }
        //Loi: tach tu sai
        String[] x = s.trim().toLowerCase().split("\\W+");
        for (String i : x) {
            if (mp.containsKey(i)) {
                mp.put(i, (long)mp.get(i) + 1);
            } else {
                arr.add(i);
                mp.put(i, (long)1);
            }
        }
        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (mp.get(o1) != mp.get(o2)) {
                    if(mp.get(o1) > mp.get(o2)) return -1;
                    else return 1;
                }
                return o1.compareTo(o2);
            }
        });
        for (String i : arr) {
            System.out.println(i + " " + mp.get(i));
        }
    }
}
