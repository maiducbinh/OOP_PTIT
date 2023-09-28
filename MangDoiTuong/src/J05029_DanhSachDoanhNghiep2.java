import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Company implements Comparable<Company>{
    private String ma, ten;
    private int num;

    public Company(String ma, String ten, int num) {
        this.ma = ma;
        this.ten = ten;
        this.num = num;
    }

    @Override
    public int compareTo(Company t) {
        if(this.num != t.num)
            return -(this.num - t.num);
        return this.ma.compareTo(t.ma);
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + num;
    }
    
}
public class J05029_DanhSachDoanhNghiep2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Company> arr = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            Company x = new Company(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()));
            arr.add(x);
        }
        Collections.sort(arr);
        int q = Integer.parseInt(sc.nextLine());
        while(q-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println("DANH SACH DOANH NGHIEP NHAN TU " + a + " DEN " + b + " SINH VIEN:");
            for(Company i: arr)
                if(i.getNum() >= a && i.getNum() <= b)
                    System.out.println(i);
        }
    }
}
