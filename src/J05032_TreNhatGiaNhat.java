
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Person implements Comparable<Person>{
    private String ten;
    private int ngay, thang, nam;
    Person(String x){
        String[] t = x.split(" ");
        this.ten = t[0];
        String[] a = t[1].split("/");
        this.ngay = Integer.parseInt(a[0]);
        this.thang = Integer.parseInt(a[1]);
        this.nam = Integer.parseInt(a[2]);
    }

    public String getTen() {
        return ten;
    }

    @Override
    public int compareTo(Person t) {
        if(this.nam != t.nam)
            return -(this.nam - t.nam);
        else if(t.thang != this.thang)
            return -(this.thang - t.thang);
        return -(this.ngay - t.ngay);
    }
    
}
public class J05032_TreNhatGiaNhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Person> arr = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            Person x = new Person(sc.nextLine());
            arr.add(x);
        }
        Collections.sort(arr);
        System.out.println(arr.get(0).getTen());
        System.out.println(arr.get(n - 1).getTen());
    }
}
