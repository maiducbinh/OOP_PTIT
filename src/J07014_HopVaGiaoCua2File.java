
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

class WordSet {

    private ArrayList<String> a;
    // Loi: dau cach giua ca tu khi in va phai chua tu in thuong
    WordSet(String file) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(file));
        a = new ArrayList<>();
        while (sc.hasNext()) {
            String s = sc.next().toLowerCase().trim();
            a.add(s);
        }
    }

    public String union(WordSet x) {
        TreeSet<String> se = new TreeSet<>();
        String ans = "";
        for (String i : this.a) {
            se.add(i);
        }
        for (String i : x.a) {
            se.add(i);
        }
        for (String i : se) {
            ans += i + " ";
        }
        return ans.trim();
    }
    public String intersection(WordSet x){
        TreeMap<String, Integer> mp = new TreeMap<>();
        String ans = "";
        for(String i: this.a)
            mp.put(i, 1);
        for(String i: x.a)
            if(mp.containsKey(i) && mp.get(i) == 1)
                mp.put(i, 2);
        for(String i: mp.keySet())
            if(mp.get(i) == 2)
                ans += i + " ";
        return ans.trim();
    }
}

public class J07014_HopVaGiaoCua2File {

    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}
