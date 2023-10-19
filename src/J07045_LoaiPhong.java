
import java.io.File;
import java.io.IOException;
import java.util.*;

class LoaiPhong implements Comparable<LoaiPhong>{
    private String ma, ten;
    private int gia;
    private double phi;

    LoaiPhong(String s) {
        String[] a = s.trim().split("\\s+");
        this.ma = a[0];
        this.ten = a[1];
        this.gia = Integer.parseInt(a[2]);
        this.phi = Double.parseDouble(a[3]);
    }
    public int compareTo(LoaiPhong b){
        return this.ten.compareTo(b.ten);
    }
    @Override
    public String toString() {
        return ma + " " + ten + " " + gia + " " + phi;
    }
}
public class J07045_LoaiPhong {
    public static void main(String[] args) throws IOException {
        ArrayList<LoaiPhong> ds = new ArrayList<>();
        Scanner in = new Scanner(new File("PHONG.in"));
        int n = Integer.parseInt(in.nextLine());
        while(n-->0){
            ds.add(new LoaiPhong(in.nextLine()));
        }
        Collections.sort(ds);
        for(LoaiPhong tmp : ds){
            System.out.println(tmp);
        }
    }
}
