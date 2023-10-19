
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class MonHoc implements Comparable<MonHoc>{
    private String ma, ten, lyThuyet, thucHanh;
    private int soTin;
    
    public String getThucHanh() {
        return thucHanh;
    }

    public MonHoc(String ma, String ten, int soTin, String lyThuyet, String thucHanh) {
        this.ma = ma;
        this.ten = ten;
        this.lyThuyet = lyThuyet;
        this.thucHanh = thucHanh;
        this.soTin = soTin;
    }
    public String toString(){
        return ma + " " + ten + " " + soTin + " " + lyThuyet + " " + thucHanh;
    }
    @Override
    public int compareTo(MonHoc o) {
        return this.ma.compareTo(o.ma);
    }
    
}
public class J07073_DangKyHinhThucGiangDay {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner sc = new Scanner(new File("MONHOC.in"));
        Scanner sc = new Scanner(System.in);
        ArrayList<MonHoc> arr = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++)
        {
            MonHoc x = new MonHoc(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()), sc.nextLine(), sc.nextLine());
            arr.add(x);
        }
        Collections.sort(arr);
        for(MonHoc i: arr)
            if(!i.getThucHanh().equals("Truc tiep"))
                System.out.println(i);
    }
}
