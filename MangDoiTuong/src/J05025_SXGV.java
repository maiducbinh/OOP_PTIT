/*
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Teacher implements Comparable<Teacher>{
    private String ma, hoTen, ten, mon;
    static int stt = 1;

    public Teacher(String hoTen, String mon) {
        this.ma = String.format("GV%02d", stt++);
        this.hoTen = hoTen;
        String[] t = hoTen.split("\\s+");
        this.ten = t[t.length - 1];
        String[] a = mon.toUpperCase().split("\\s+");
        this.mon = "";
        for(String i: a)
            this.mon += i.substring(0, 1);
    }

    @Override
    public int compareTo(Teacher t) {
        return this.ten.compareTo(t.ten);
    }

    @Override
    public String toString() {
        return ma + " " + hoTen + " " + mon;
    }
    
}
public class J05025_SXGV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Teacher> arr = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            Teacher x = new Teacher(sc.nextLine(), sc.nextLine());
            arr.add(x);
        }
        Collections.sort(arr);
        for(Teacher i: arr)
            System.out.println(i);
    }
}
