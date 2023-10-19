package test;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class Pair implements Serializable, Comparable<Pair>
{
    private int first, second;

    public Pair(int first, int second)
    {
        this.first = first;
        this.second = second;
    }

    public int getFirst()
    {
        return first;
    }

    public int getSecond()
    {
        return second;
    }

    @Override
    public int compareTo(Pair o)
    {
        return this.first - o.first;
    }

    @Override
    public String toString()
    {
        return "(" + first + ", " + second + ")";
    }
}
        
public class J07042_LietKeCapSo2 {
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
