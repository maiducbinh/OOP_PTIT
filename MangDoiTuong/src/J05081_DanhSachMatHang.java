/*
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class MatHang{
    private String ma, ten, donVi;
    private long mua, ban, lai;
    static int cnt = 1;

    MatHang(String ten, String donVi, long mua, long ban) {
        this.ma = "MH" + String.format("%03d", cnt);
        cnt++;
        this.ten = ten;
        this.donVi = donVi;
        this.mua = mua;
        this.ban = ban;
        this.lai = ban - mua;
    }
    public String getMa() {
        return ma;
    }

    public long getLai() {
        return lai;
    }
    @Override
    public String toString() {
        return ma + " " + ten + " " + donVi + " " + mua + " " + ban + " " + lai;
    }
    
}
public class J05081_DanhSachMatHang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<MatHang> a = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            // Loi: xung dot khi nhap xuat
            MatHang x = new MatHang(sc.nextLine(), sc.nextLine(), sc.nextLong(), sc.nextLong());
            sc.nextLine();
            a.add(x);
        }
        Collections.sort(a, new Comparator<MatHang>(){
            @Override
            public int compare(MatHang x, MatHang y) {
                if(x.getLai() != y.getLai())
                {
                    if(x.getLai() < y.getLai()) return 1;
                    else return -1;
                }
                else return (x.getMa()).compareTo(y.getMa());
            }
        });
        for(MatHang i: a)
            System.out.println(i);
    }
}
