
import java.util.Arrays;
import java.util.*;

class WordSet{
    private String[] a;
    WordSet(String s){
        //s = s.toLowerCase();
        a = s.trim().split("\\s+");
        // For each ko the thay doi gia tri
        //for(String i: a)
            //i = i.toLowerCase();
        for(int i = 0; i < a.length; i++)
            a[i] = a[i].toLowerCase();
        Arrays.sort(a);
    }
    public String union(WordSet b){
        TreeSet<String> se = new TreeSet<>();
        for(String i: this.a)
            se.add(i);
        for(String i: b.a)
            se.add(i);
        String ans = "";
        for(String i: se)
            ans += i + " ";
        return ans;
    }
    public String intersection(WordSet b)
    {
        TreeMap<String, Integer> mp = new TreeMap<>();
        for(String i: this.a)
            mp.put(i, 1);
        for(String i: b.a)
            if(mp.containsKey(i))
                mp.put(i, 2);
        String ans = "";
        for(String i: mp.keySet())
            if(mp.get(i) == 2)
                ans += i + " ";
        return ans;
    }
}

public class J04022_WordSet {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        WordSet s1 = new WordSet(in.nextLine());
        WordSet s2 = new WordSet(in.nextLine());
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}
