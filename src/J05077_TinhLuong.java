
import java.util.ArrayList;
import java.util.Scanner;

class NV{
    private String ma, ten, maPhong, phong;
    private long luong, day;

    public NV(String ma, String ten, long luong, long day) {
        this.ma = ma;
        this.ten = ten;
        this.luong = luong;
        this.day = day;
        this.maPhong = ma.substring(3, 5);
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }
    public long heSo(){
        char nhom = ma.charAt(0);
        int nam = Integer.parseInt(ma.substring(1, 3));
        if(nhom == 'A'){
            if(nam <= 3) return 10;
            else if(nam <= 8) return 12;
            else if(nam <= 15) return 14;
            else return 20;
        }
        else if(nhom == 'B'){
            if(nam <= 3) return 10;
            else if(nam <= 8) return 11;
            else if(nam <= 15) return 13;
            else return 16;
        }
        else if(nhom == 'C'){
            if(nam <= 3) return 9;
            else if(nam <= 8) return 10;
            else if(nam <= 15) return 12;
            else return 14;
        }
        else{
            if(nam <= 3) return 8;
            else if(nam <= 8) return 9;
            else if(nam <= 15) return 11;
            else return 13;
        }
    }
    public String toString(){
        return ma + " " + ten + " " + phong + " " + luong * day * heSo() + "000";
    }
}

class Phong{
    private String ma, ten;

    public Phong(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }
    
}
public class J05077_TinhLuong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Phong> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String[] x = sc.nextLine().split(" ");
            String t = "";
            for(int j = 1; j < x.length; j++)
                t += x[j] + " ";
            t = t.trim();
            Phong a = new Phong(x[0], t);
            arr.add(a);
        }
        int m = Integer.parseInt(sc.nextLine());
        while(m-->0){
            NV x = new NV(sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine()), Long.parseLong(sc.nextLine()));
            for(Phong i: arr)
                if(i.getMa().equals(x.getMaPhong()))
                {
                    x.setPhong(i.getTen());
                    System.out.println(x);
                }
        }
    }
}
