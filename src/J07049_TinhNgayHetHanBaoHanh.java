
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

class SP{
    private String ma, ten;
    private int gia, bh;

    public SP(String ma, String ten, int gia, int bh) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.bh = bh;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public int getGia() {
        return gia;
    }

    public int getBh() {
        return bh;
    }
    
}

class KH{
    private String ten, add, maSP, maKH;
    private long num;
    private Date mua, han;
    private Calendar calendar;
    private SP sp;
    static int stt = 1;
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    public KH(String ten, String add, String ma, long num, String mua) throws ParseException {
        this.ten = ten;
        this.add = add;
        this.maSP = ma;
        this.num = num;
        this.mua = df.parse(mua);
        this.maKH = String.format("KH%02d", stt++);
    }

    public String getMaKH() {
        return maKH;
    }
    private Date calculateHan() {
        calendar = Calendar.getInstance();//init
        calendar.setTime(this.mua);
        calendar.add(Calendar.MONTH, sp.getBh());
        return calendar.getTime();
    }

    public Date getHan() {
        return han;
    }
    
    public void setSP(SP x){
        this.sp = x;
        han = calculateHan();
    }

    public String getMaSP() {
        return maSP;
    }
    // Loi: tinh han
    public String toString(){
        return maKH + " " + ten + " " + add + " " + maSP + " " + num * sp.getGia() + " " + df.format(han);
    }
    
}
public class J07049_TinhNgayHetHanBaoHanh {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("MUAHANG.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<SP> a = new ArrayList<>();
        for(int i = 0; i < n; i++){
            SP x = new SP(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()));
            a.add(x);
        }
        int m = Integer.parseInt(sc.nextLine());
        ArrayList<KH> b = new ArrayList<>();
        for(int i = 0; i < m; i++){
            KH x = new KH(sc.nextLine(), sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine()), sc.nextLine());
            for(SP j: a){
                if(x.getMaSP().equals(j.getMa()))
                    x.setSP(j);
            }
            b.add(x);
        }
        b.sort((x, y) -> (x.getHan().equals(y.getHan()))? x.getMaKH().compareTo(y.getMaKH()): x.getHan().compareTo(y.getHan()));
        for(KH i: b)
        {
            System.out.println(i);
        }
    }
}
