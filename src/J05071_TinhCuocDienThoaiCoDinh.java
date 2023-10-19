
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
// Loi: truy cap sai vi tri torng mang + set lai thoi gian noi mang
class Tinh{
    private String ma, ten;
    private long gia;

    public Tinh(String ma, String ten, long gia) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public long getGia() {
        return gia;
    }
    
}

class Goi{
    private String thueBao, tinh;
    private Date st, end;
    private long time, gia;
    SimpleDateFormat df = new SimpleDateFormat("HH:mm");

    public Goi(Scanner sc) throws ParseException {
        String s[] = sc.nextLine().split(" ");
        this.thueBao = s[0];
        this.st = df.parse(s[1]);
        this.end = df.parse(s[2]);
        time = (this.end.getTime() - this.st.getTime()) / (1000 * 60);
    }

    public void setGia(long gia) {
        this.gia = gia;
    }

    public void setTinh(String tinh) {
        this.tinh = tinh;
    }
    public long Cuoc(){
        return time * gia;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getThueBao() {
        return thueBao;
    }
    
    public String toString(){
        return thueBao + " " + tinh + " " + time + " " + Cuoc();
    }
}
public class J05071_TinhCuocDienThoaiCoDinh {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Tinh> a = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            Tinh x = new Tinh(sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine()));
            a.add(x);
        }
        int m = Integer.parseInt(sc.nextLine());
        ArrayList<Goi> b = new ArrayList<>();
        for(int i = 0; i < m; i++){
            Goi x = new Goi(sc);
            if(x.getThueBao().charAt(0) != '0'){
                x.setTinh("Noi mang");
                x.setTime((x.getTime() + 2) / 3);
                x.setGia(800);
            }
            else{
                for(Tinh y: a)
                    if(y.getMa().equals(x.getThueBao().substring(1, 3))){
                        x.setTinh(y.getTen());
                        x.setGia(y.getGia());
                        break;
                    }
            }
            System.out.println(x);
        }
    }
}
