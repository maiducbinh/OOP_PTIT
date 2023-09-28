
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;


public class J07032_SoThuanNghich {
    private static boolean check(int x)
    {
        String s = Integer.toString(x);
        if(s.length() == 1 || s.length() % 2 == 0) return false;
        for(int i = 0; i <= s.length() / 2; i++)
        {
            if((s.charAt(i) - '0') % 2 == 0) return false;
            if(s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream sc1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream sc2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> a = (ArrayList<Integer>)sc1.readObject();
        ArrayList<Integer> b = (ArrayList<Integer>)sc2.readObject();
        HashSet<Integer> s1 = new HashSet<>(a);
        HashSet<Integer> s2 = new HashSet<>(b);
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i: a)
            if(s2.contains(i) && check(i) == true)
            {
                if(mp.containsKey(i)) 
                    mp.put(i, mp.get(i) + 1);
                else mp.put(i, 1);
            }
        // Loi: thieu dieu kien dem tong so lan xuat hien
        for(int i: b)
            if(mp.containsKey(i))
                mp.put(i, mp.get(i) + 1);
        Collections.sort(a);
        int cnt = 0;
        for(int i = 0; i < a.size() && cnt < 10; i++)
            if(mp.containsKey(a.get(i)) && mp.get(a.get(i)) != 0)
            {
                System.out.println(a.get(i) + " " + mp.get(a.get(i)));
                mp.put(a.get(i), 0);
                cnt++;
            }
    }
}
