
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

class WordSet{
    private ArrayList<String> arr;
    private TreeSet<String> se;
    WordSet(String file) throws FileNotFoundException{
        arr = new ArrayList<>();
        se = new TreeSet<>();
        Scanner sc = new Scanner(new File(file));
        while(sc.hasNext()){
            String s = sc.next().toLowerCase();
            arr.add(s);
            se.add(s);
        }
    }
    public String difference(WordSet x){
        String ans = "";
        TreeMap<String, Integer> mp = new TreeMap<>();
        for(String i: this.arr)
            mp.put(i, 1);
        for(String i: x.arr)
            if(mp.containsKey(i) && mp.get(i) == 1)
                mp.put(i, 2);
        //for(String i: this.arr)
        //    if(mp.get(i) == 1)
        //        ans += i + " ";
        for(String i: this.se)
            if(!x.se.contains(i))
                 ans += i + " ";
        return ans.trim();
    }
}
public class J07024_Hieu2TapTu {
    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.difference(s2));
        System.out.println(s2.difference(s1));
    }
}
