
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class J07022_LoaiBoSoNguyen {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        ArrayList<String> a = new ArrayList<>();
        while(sc.hasNext())
        {
            String s = sc.next();
            try {
                int x = Integer.parseInt(s);
            }
            catch(Exception e){
                a.add(s);
            }
        }
        Collections.sort(a);
        for(String i: a)
            System.out.print(i + " ");
    }
}
