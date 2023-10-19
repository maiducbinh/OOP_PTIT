
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class KH{
    private String ma, ten, gt, dob, add;
    static int stt = 1;
    public KH(String ten, String gt, String dob, String add) {
        this.ten = ten;
        this.gt = gt;
        this.dob = dob;
        this.add = add;
        this.ma = String.format("KH%03d", stt++);
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getGt() {
        return gt;
    }

    public String getDob() {
        return dob;
    }

    public String getAdd() {
        return add;
    }

    public static int getStt() {
        return stt;
    }
    
    
}

class Hang{
    private String ma, ten, donVi;
    private long mua, ban;
    static int stt = 1;

    public Hang(String ten, String donVi, long mua, long ban) {
        this.ten = ten;
        this.donVi = donVi;
        this.mua = mua;
        this.ban = ban;
        this.ma = String.format("MH%03d", stt++);
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getDonVi() {
        return donVi;
    }

    public long getMua() {
        return mua;
    }

    public long getBan() {
        return ban;
    }

    public static int getStt() {
        return stt;
    }
    
    
}

class HoaDon{
    private String ma;
    private KH kh;
    private Hang hang;
    private long num;
    static int stt = 1;

    public HoaDon(KH kh, Hang hang, long num) {
        this.kh = kh;
        this.hang = hang;
        this.num = num;
        this.ma = String.format("HD%03d", stt++);
    }
    public String toString(){
        return ma + " " + kh.getTen() + " " + kh.getAdd() + " " + hang.getTen() + " " + hang.getDonVi() + " " + hang.getMua() + " " + hang.getBan() + " " + num + " " + (num * hang.getBan());
    }
}
public class J07020_HoaDon2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File("KH.in"));
        ArrayList<KH> a = new ArrayList<>();
        int n = Integer.parseInt(sc1.nextLine());
        for(int i = 0; i < n; i++){
            KH x = new KH(sc1.nextLine(), sc1.nextLine(), sc1.nextLine(), sc1.nextLine());
            a.add(x);
        }
        Scanner sc2 = new Scanner(new File("MH.in"));
        int m = Integer.parseInt(sc2.nextLine());
        ArrayList<Hang> b = new ArrayList<>();
        for(int i = 0; i < m; i++){
            Hang x = new Hang(sc2.nextLine(), sc2.nextLine(), Long.parseLong(sc2.nextLine()), Long.parseLong(sc2.nextLine()));
            b.add(x);
        }
        Scanner sc3 = new Scanner(new File("HD.in"));
        ArrayList<HoaDon> c = new ArrayList<>();
        int k = Integer.parseInt(sc3.nextLine());
        for(int i = 0; i < k; i++){
            String[] s = sc3.nextLine().split(" ");
            String maKH = s[0];
            String maMH = s[1];
            long num = Long.parseLong(s[2]);
            for(KH x: a)
                for(Hang y: b){
                    if(x.getMa().equals(maKH) && y.getMa().equals(maMH)){
                        HoaDon z = new HoaDon(x, y, num);
                        System.out.println(z);
                    }
                }
        }
    }
}
