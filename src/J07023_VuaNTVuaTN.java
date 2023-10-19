
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.TreeMap;

public class J07023_VuaNTVuaTN {
    public static boolean isPrime(int n){
        if(n < 2) return false;
        for(int i = 2; i <= Math.sqrt(n); i++)
            if(n % i == 0) return false;
        return true;
    }
    public static boolean isPalin(int n){
        String s = n + "";
        int len = s.length();
        for(int i = 0; i <= len / 2; i++)
            if(s.charAt(i) != s.charAt(len - i - 1)) return false;
        return true;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream sc1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ArrayList<Integer> arr1 = (ArrayList<Integer>) sc1.readObject();
        ObjectInputStream sc2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> arr2 = (ArrayList<Integer>) sc2.readObject();
        TreeMap<Integer, Integer> mp1 = new TreeMap<>();
        TreeMap<Integer, Integer> mp2 = new TreeMap<>();
        for(int i: arr1){
            if((isPrime(i) == true) && (isPalin(i) == true)){
                if(!mp1.containsKey(i))
                    mp1.put(i, 1);
                else mp1.put(i, mp1.get(i) + 1);
            }
        }
        for(int i: arr2){
            if(isPrime(i) && isPalin(i)){
                if(!mp2.containsKey(i))
                    mp2.put(i, 1);
                else mp2.put(i, mp2.get(i) + 1);
            }
        }
        for(int i: mp1.keySet())
            for(int j: mp2.keySet())
                if(i == j)
                    System.out.println(i + " " + mp1.get(i) + " " + mp2.get(j));
    }
}
