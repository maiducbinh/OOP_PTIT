
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;


public class J07029_SoNguyenToLonNhat {
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
        ObjectInputStream sc = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<Integer> a = (ArrayList<Integer>)sc.readObject();
        HashMap<Integer, Integer> mp = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i: a)
            if(prime[i] == 1)
            {
                if(mp.containsKey(i))
                    mp.put(i, mp.get(i) + 1);
                else mp.put(i, 1);
            }
        for(int i: mp.keySet())
            ans.add(i);
        Collections.sort(ans, new Comparator<Integer>(){
            @Override
            public int compare(Integer t, Integer t1) {
                return -(t - t1);
            }
        });
        for(int i = 0; i < 10; i++)
            System.out.println(ans.get(i) + " " + mp.get(ans.get(i)));
    }
    
}
