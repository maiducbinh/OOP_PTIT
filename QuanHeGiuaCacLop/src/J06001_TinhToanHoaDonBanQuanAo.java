
import java.util.ArrayList;
import java.util.Scanner;

class SP{
    private String ma, ten;
    private Long gia1, gia2;

    public SP(String ma, String ten, Long gia1, Long gia2) {
        this.ma = ma;
        this.ten = ten;
        this.gia1 = gia1;
        this.gia2 = gia2;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public Long getGia1() {
        return gia1;
    }

    public Long getGia2() {
        return gia2;
    }
    
}

class HoaDon{
    private String ma;
    private long num;
    private SP sp;
    static int stt = 1;

    public HoaDon(String ma, long num) {
        this.ma = ma + String.format("-%03d", stt++);
        this.num = num;
    }

    public void setSp(SP sp) {
        this.sp = sp;
    }

    public String getMa() {
        return ma.substring(0, 2);
    }
    public long thanhTien(){
        if(ma.charAt(2) == '1')
            return num * sp.getGia1();
        return num * sp.getGia2();
    }
    public long giamGia(){
        if(num >= 150) return thanhTien() * 1 / 2;
        else if(num >= 100) return thanhTien() * 30 / 100;
        else if(num >= 50) return thanhTien() * 15 / 100;
        return 0;
    }
    public long tra(){
        return thanhTien() - giamGia();
    }
    public String toString(){
        return ma + " " + sp.getTen() + " " + giamGia() + " " + tra();
    }
    
}
public class J06001_TinhToanHoaDonBanQuanAo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SP> a = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            SP x = new SP(sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine()), Long.parseLong(sc.nextLine()));
            a.add(x);
        }
        ArrayList<HoaDon> b = new ArrayList<>();
        int m = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < m; i++){
            String[] s = sc.nextLine().split(" ");
            HoaDon x = new HoaDon(s[0], Long.parseLong(s[1]));
            for(SP j: a)
                if(x.getMa().equals(j.getMa())){
                    x.setSp(j);
                    break;
                }
            System.out.println(x);
            
        }
    }
}
