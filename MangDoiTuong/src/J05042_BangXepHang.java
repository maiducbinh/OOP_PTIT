
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Student implements Comparable<Student>{
    private String ten;
    private int ac, sub;
    Student(String ten, int ac, int sub){
        this.ten = ten;
        this.ac = ac;
        this.sub = sub;
    }
    public int compareTo(Student t){
        if(this.ac != t.ac) {
            if(this.ac > t.ac) return -1;
            else return 1;
        }
        else if(this.sub != t.sub){
            if(this.sub < t.sub) return -1;
            else return 1;
        }
        return this.ten.compareTo(t.ten);
    }
    public String toString(){
        return ten + " " + ac + " " + sub;
    }
}
public class J05042_BangXepHang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Student> arr = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            Student x = new Student(sc.nextLine(), sc.nextInt(), sc.nextInt());
            sc.nextLine();
            arr.add(x);
        }
        Collections.sort(arr);
        for(Student i: arr)
            System.out.println(i);
    }
}
