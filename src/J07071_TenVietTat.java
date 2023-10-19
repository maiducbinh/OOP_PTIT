
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Ten implements Comparable<Ten>{
    private String hoTen, ten, ho;
    private String vietTat;
    Ten(String s){
        this.hoTen = s;
        String[] a = s.split(" ");
        ho = a[0];
        ten = a[a.length - 1];
        this.vietTat = "";
        for(int i = 0; i < a.length; i++)
            if(i!= a.length - 1) this.vietTat += a[i].substring(0, 1) + ".";
            else this.vietTat += a[i].substring(0, 1);
    }

    @Override
    public int compareTo(Ten t) {
        if(!this.ten.equals(t.ten))
            return this.ten.compareTo(t.ten);
        return this.ho.compareTo(t.ho);
    }

    @Override
    public String toString() {
        return hoTen;
    }

    public String getVietTat() {
        return vietTat;
    }
    
}
public class J07071_TenVietTat {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        //Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Ten> a = new ArrayList<>();
        for(int i = 0; i < n; i++){
            Ten x = new Ten(sc.nextLine());
            a.add(x);
        }
        Collections.sort(a);
        int m = Integer.parseInt(sc.nextLine());
        while(m-->0){
            String tat = sc.nextLine().trim();
            int idx = -1;
            for(int i = 0; i < tat.length(); i++)
                if(tat.charAt(i) == '*') {
                    idx = i;
                    break;
                }
            if(idx == -1)
                for(Ten i: a)
                    if(i.getVietTat().equals(tat))
                    {
                        System.out.println(i);
                        continue;
                    }
            for(Ten i: a)
                if(i.getVietTat().substring(0, idx).equals(tat.substring(0, idx)) && i.getVietTat().substring(idx + 1).equals(tat.substring(idx + 1)))
                    System.out.println(i);
        }
    }
}
