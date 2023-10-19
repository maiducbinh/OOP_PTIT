
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;


public class J07030_CapSoNguyenTo {
    static int maxn = (int)1e6 + 5;
    static int[] prime = new int[maxn];
    public static void sieve(){
        prime[0] = prime[1] = 0;
        for(int i = 2; i < maxn; i++)
            prime[i] = 1;
        for(int i = 2; i < Math.sqrt(maxn); i++)
            if(prime[i] == 1)
                for(int j = i * i; j < maxn; j += i)
                    prime[j] = 0;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        sieve();
        ObjectInputStream sc1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ArrayList<Integer> a = (ArrayList<Integer>)sc1.readObject();
        ObjectInputStream sc2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> b = (ArrayList<Integer>)sc2.readObject();
        TreeSet<Integer> s1 = new TreeSet<>(a);
        TreeSet<Integer> s2 = new TreeSet<>(b);
        for(int i: s1)
            if(prime[i] == 1 && prime[1000000 - i] == 1 && s2.contains(1000000 - i) && i < 1000000 - i)
                System.out.println(i + " " + (1000000 - i));
    }
    
}
