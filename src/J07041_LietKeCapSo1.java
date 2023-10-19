package test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

class Pair implements Serializable, Comparable<Pair>{
    private int first, second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }
    
    public int compareTo(Pair o) {
        return this.first - o.first;
    }
    
    public String toString(){
        return "(" + first + ", " + second + ")";
    }
}
public class J07041_LietKeCapSo1 {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream sc = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<Pair> arr = (ArrayList<Pair>) sc.readObject();
        TreeSet<Pair> ts = new TreeSet<>();
        Collections.sort(arr);
        for(Pair i: arr)
            if((i.getFirst() < i.getSecond()) && !ts.contains(i)){
                System.out.println(i);
                ts.add(i);
            }
    }
}
