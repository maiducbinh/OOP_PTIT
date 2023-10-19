
package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream sc = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<Pair> arr = (ArrayList<Pair>) sc.readObject();
        TreeSet<String> ts = new TreeSet<>();
        Collections.sort(arr);
        //Loi: phai su dung String thi set moi phan biet duoc
        for(Pair i: arr)
            if((i.getFirst() < i.getSecond()) && !ts.contains(i.toString())){
                ts.add(i.toString());
                System.out.println(i);
            }
    }
}
