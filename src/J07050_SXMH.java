
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class MH implements Comparable<MH>{
    private String ma, ten, nhom;
    private double mua, ban, lai;
    static int stt = 1;
    public MH(String ten, String nhom, double mua, double ban) {
        this.ma = String.format("MH%02d", stt++);
        this.ten = ten;
        this.nhom = nhom;
        this.mua = mua;
        this.ban = ban;
        this.lai = ban - mua;
    }
    public String toString(){
        return ma + " " + ten + " " + nhom + " " + String.format("%.2f", lai);
    }
    @Override
    public int compareTo(MH o) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if(this.lai > o.lai) return -1;
        return 1;
    }
    
}
public class J07050_SXMH {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MATHANG.in"));
        ArrayList<MH> arr = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            MH x = new MH(sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()));
            arr.add(x);
        }
        Collections.sort(arr);
        for(MH i: arr)
            System.out.println(i);
    }
}
