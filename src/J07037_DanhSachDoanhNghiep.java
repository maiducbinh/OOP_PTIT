
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Company{
    private String ma, ten;
    private int num;

    Company(String ma, String ten, int num) {
        this.ma = ma;
        this.ten = ten;
        this.num = num;
    }

    public String getMa() {
        return ma;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + num;
    }
    
}
public class J07037_DanhSachDoanhNghiep {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DN.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Company> a = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            Company x = new Company(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()));
            a.add(x);
        }
        Collections.sort(a, new Comparator<Company>(){
            @Override
            public int compare(Company t, Company t1) {
                return t.getMa().compareTo(t1.getMa());
            }
            
        });
        for(Company i: a)
            System.out.println(i);
    }
}
