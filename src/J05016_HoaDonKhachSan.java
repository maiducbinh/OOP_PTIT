
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

// Loi: tinh ngay bang kieu int se ko dung
class KH{
    private String ten, phong, ma;
    private Date nhan, tra;
    private long dvu, ngay;
    static int stt = 1;
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    
    public KH(String ten, String phong, String nhan, String tra, long dvu) throws ParseException {
        this.ten = ten.trim();
        this.phong = phong.trim();
        this.nhan = df.parse(nhan);
        this.tra = df.parse(tra);
        this.dvu = dvu;
        this.ma = String.format("KH%02d", stt++);
        this.ngay = (this.tra.getTime() - this.nhan.getTime()) / (1000 * 60 * 60 * 24) + 1;
    }
    public long gia(){
        if(phong.charAt(0) == '1') return 25;
        else if(phong.charAt(0) == '2') return 34;
        else if(phong.charAt(0) == '3') return 50;
        return 80;
    }
    public long thanhTien(){
        return gia() * ngay + dvu;
    }
    public String toString(){
        return ma + " " + ten.trim() + " " + phong + " " + ngay + " " + (gia() * ngay + dvu);
    }
    
}
public class J05016_HoaDonKhachSan {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        ArrayList<KH> a = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            KH x = new KH(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine()));
            a.add(x);
        }
        a.sort(Comparator.comparing(KH::thanhTien).reversed());
        for(KH i: a)
        {
            System.out.println(i);
        }
    }
}
