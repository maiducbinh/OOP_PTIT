
import java.util.Scanner;

class GV{
    private String ma, ten;
    private long luong, thuNhap;

    public GV(String ma, String ten, long luong) {
        this.ma = ma;
        this.ten = ten;
        this.luong = luong;
        this.thuNhap = luong * bacLuong() + phuCap();
    }
    public String getChucVu(){
        return ma.substring(0, 2);
    }
    public long phuCap(){
        if(ma.charAt(1) == 'T') return (long)2e6;
        else if(ma.charAt(1) == 'P') return (long)9e5;
        return (long)5e5;
    } 
    public long bacLuong(){
        return Long.parseLong(ma.substring(2));
    }
    public String toString(){
        return ma + " " + ten + " " + bacLuong() + " " + phuCap() + " " + thuNhap;
    }
}
public class J05064_BangThuNhapGiaoVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cntT = 0, cntP = 0;
        int n = Integer.parseInt(sc.nextLine());
        while(n-->0){
            // Loi: sai logic
            GV x = new GV(sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine()));
            if(x.getChucVu().equals("HT")){
                cntT++;
                if(cntT > 1) continue;
            }
            else if(x.getChucVu().equals("HP")){
                cntP++;
                if(cntP > 2) continue;
            }
            System.out.println(x);
        }
    }
}
