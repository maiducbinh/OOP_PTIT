
import java.util.*;

class MatHang implements Comparable<MatHang>{
    private String ten, nhom;
    private int ma;
    private double mua, ban, lai;
    static int cnt = 1;

    MatHang(String ten, String nhom, double mua, double ban) {
        this.ma = cnt++;
        this.ten = ten;
        this.nhom = nhom;
        this.mua = mua;
        this.ban = ban;
        this.lai = ban - mua;
    }
    @Override
    public String toString() {
        return ma + " " + ten + " " + nhom + " " + String.format("%.2f", lai);
    }

    @Override
    public int compareTo(MatHang t) {
        if(this.lai > t.lai)
            return -1;
        return 1;
    }
    
}
public class J05010_SXMH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<MatHang> arr = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++)
        {
            MatHang x = new MatHang(sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()));
            arr.add(x);
        }
        Collections.sort(arr);
        for(MatHang i: arr)
            System.out.println(i);
    }
}
