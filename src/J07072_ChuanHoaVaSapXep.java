
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Name implements Comparable<Name>{
    private String hoTen, ho, dem, ten;
    Name(String s){
        String[] a = s.trim().split("\\s+");
        this.hoTen = "";
        for(int i = 0; i < a.length; i++)
            a[i] = a[i].substring(0, 1).toUpperCase() + a[i].substring(1).toLowerCase();
        for(String i: a)
            this.hoTen += i + " ";
        this.hoTen.trim();
        this.ho = a[0];
        this.ten = a[a.length - 1];
        this.dem = "";
        for(int i = 0; i < a.length - 1; i++)
            this.dem += a[i] + " ";
        this.dem.trim();
    }

    @Override
    public int compareTo(Name t) {
        if(!this.ten.equals(t.ten))
            return this.ten.compareTo(t.ten);
        else if(!this.ho.equals(t.ho))
            return this.ho.compareTo(t.ho);
        return this.dem.compareTo(t.dem);
    }

    @Override
    public String toString() {
        return hoTen;
    }
    
}
public class J07072_ChuanHoaVaSapXep {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        //Scanner sc = new Scanner(System.in);
        ArrayList<Name> arr = new ArrayList<>();
        while(sc.hasNextLine()){
            Name x = new Name(sc.nextLine());
            arr.add(x);
        }
        Collections.sort(arr);
        for(Name i: arr)
            System.out.println(i);
    }
}
