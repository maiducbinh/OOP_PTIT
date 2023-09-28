
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

class WordSet{
    private TreeSet<String> ts = new TreeSet<>();
    WordSet(String fileName) throws IOException{
        Scanner sc = new Scanner(new File(fileName));
        while(sc.hasNext())
        {
            String s = sc.next();
            s = s.toLowerCase();
            ts.add(s);
        }
    }

    @Override
    public String toString() {
        String ans = "";
        for(String i: ts)
            ans += i + "\n";
        return ans;
    }
    
}
public class J07007_LietKeTuKhacNhau {
    public static void main(String[] args) throws IOException {
        WordSet ws = new WordSet("VANBAN.in");
        System.out.println(ws);
    }
}
