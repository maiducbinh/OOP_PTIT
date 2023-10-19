/*
import java.util.ArrayList;
import java.util.Scanner;

class SinhVien{
    private String ma, ten, lop, mail;
    SinhVien(String ma, String ten, String lop, String mail){
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
        this.mail = mail;
    }
    public String getLop(){
        return this.lop;
    }
    public String toString(){
        return ma + " " + ten + " " + lop + " " + mail;
    }
}
public class J05022_LietKeSinhVienTheoLop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<SinhVien> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            SinhVien x = new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            arr.add(x);
        }
        int q = Integer.parseInt(sc.nextLine());
        while(q-->0){
            String lop = sc.nextLine();
            System.out.println("DANH SACH SINH VIEN LOP " + lop + ":");
            for(SinhVien i: arr)
                if(i.getLop().equals(lop))
                    System.out.println(i);
        }
    }
}
