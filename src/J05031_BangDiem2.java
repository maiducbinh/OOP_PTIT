/*
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Student implements Comparable<Student>{
    private String ma, ten, lop;
    private double d1, d2, d3;

    public Student(String ma, String ten, String lop, double d1, double d2, double d3) {
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
    }
    
    @Override
    public int compareTo(Student t) {
        return this.ten.compareTo(t.ten);
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + lop + " " + String.format("%.1f", d1) + " " + String.format("%.1f", d2) + " " + String.format("%.1f",d3);
    }
    
}
public class J05031_BangDiem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Student> arr = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            Student x = new Student(sc.nextLine(), sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()));
            arr.add(x);
        }
        Collections.sort(arr);
        for(int i = 0; i < n; i++)
        {
            System.out.println((i + 1) + " " + arr.get(i));
        }
    }
}
