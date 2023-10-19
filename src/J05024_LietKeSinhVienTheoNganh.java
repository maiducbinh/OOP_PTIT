
import java.util.ArrayList;
import java.util.Scanner;

class SinhVien{
    private String ma, ten, lop, mail;
    SinhVien(String ma, String ten, String lop, String mail){
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
        this.mail = mail;
    }
    public String getLop(){
        return this.lop;
    }
    public String getNganh(){
        return this.ma.substring(5, 7);
    }
    public String toString(){
        return ma + " " + ten + " " + lop + " " + mail;
    }
}
public class J05024_LietKeSinhVienTheoNganh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<SinhVien> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            SinhVien x = new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            arr.add(x);
        }
        int q = Integer.parseInt(sc.nextLine());
        while(q-->0){
            String nganh = sc.nextLine();
            nganh = nganh.toUpperCase();
            String[] a = nganh.split("\\s+");
            String maNganh = a[0].substring(0, 1) + a[1].substring(0, 1);
            System.out.println("DANH SACH SINH VIEN NGANH " + nganh + ":");
            for(SinhVien i: arr)
                if(i.getNganh().equals(maNganh))
                {
                    // Loi: sai dieu kien
                    if((maNganh.equals("CN") || maNganh.equals("AT")) && i.getLop().charAt(0) != 'E')
                        System.out.println(i);
                    else if(!maNganh.equals("CN") && !maNganh.equals("AT")) System.out.println(i);
                }
        }
    }
}
