/*
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class SinhVien implements Comparable<SinhVien>{
    private String ma, ten, lop, mail;
    SinhVien(String ma, String ten, String lop, String mail){
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
        this.mail = mail;
    }
    // Loi: so sanh 2 String bang dau =
    public int compareTo(SinhVien t){
        return this.ma.compareTo(t.ma);
    }
    public String toString(){
        return ma + " " + ten + " " + lop + " " + mail;
    }
}
public class J05021_SXMSV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SinhVien> arr = new ArrayList<>();
        while(sc.hasNextLine())
        {
            SinhVien x = new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            arr.add(x);
        }
        Collections.sort(arr);
        for(SinhVien i: arr)
            System.out.println(i);
    }
}
