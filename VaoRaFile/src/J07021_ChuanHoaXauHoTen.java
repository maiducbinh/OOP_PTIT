
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class J07021_ChuanHoaXauHoTen {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        //Scanner sc = new Scanner(System.in);
        while(true)
        {
            // Ko trim
            String x = sc.nextLine().trim();
            String[] s = x.split("\\s+");
            if(s[0].equals("END") == true) break;
            for(String i: s)
                System.out.print(i.substring(0, 1).toUpperCase() + i.substring(1).toLowerCase() + " ");
            System.out.println("");
        }
    }
}
