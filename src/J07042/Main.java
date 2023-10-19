package test;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {
    public static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream sc = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<Pair> arr = (ArrayList<Pair>) sc.readObject();
        HashSet<String> se = new HashSet<>();
        Collections.sort(arr);
        for(Pair i: arr)
            if(i.getFirst() < i.getSecond() && gcd(i.getFirst(), i.getSecond()) == 1 && !se.contains(i.toString())){
                se.add(i.toString());
                System.out.println(i);
            }
        
    }
}
