
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Student implements Comparable<Student>{
    private String ma, ten, lop, mail, company;
    private int stt;
    static int cnt = 1;
    public Student(String ma, String ten, String lop, String mail, String company) {
        this.stt = cnt++;
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
        this.mail = mail;
        this.company = company;
    }
    
    @Override
    public int compareTo(Student t) {
        return this.ten.compareTo(t.ten);
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return stt + " " + ma + " " + ten + " " + lop + " " + mail + " " + company;
    }
    
}
public class J05034_DanhSachThucTap1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Student> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            Student x = new Student(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            arr.add(x);
        }
        Collections.sort(arr);
        int q = Integer.parseInt(sc.nextLine());
        while(q-->0){
            String company = sc.nextLine().trim();
            for(Student i: arr)
                if(i.getCompany().equals(company)){
                    System.out.println(i);
                }
        }
    }
}
