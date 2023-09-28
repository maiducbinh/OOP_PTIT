/*
import java.util.ArrayList;
import java.util.Scanner;

class Teacher{
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
    public String getMon(){
        return this.mon;
    }
    @Override
    public String toString() {
        return ma + " " + hoTen + " " + mon;
    }
    
}
public class J05026_DanhSachGiangVienBoMon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Teacher> arr = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            Teacher x = new Teacher(sc.nextLine(), sc.nextLine());
            arr.add(x);
        }
        int q = Integer.parseInt(sc.nextLine());
        while(q-->0){
            String mon = sc.nextLine();
            String[] a = mon.toUpperCase().split("\\s+");
            String boMon = "";
            for(String i: a) boMon += i.substring(0, 1);
            System.out.println("DANH SACH GIANG VIEN BO MON " + boMon + ":");
            for(Teacher i: arr)
                if(i.getMon().equals(boMon))
                    System.out.println(i);
        }
    }
}
