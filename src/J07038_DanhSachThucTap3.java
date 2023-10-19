
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
// Loi: ko xac dinh, phai lap quan he rieng
class DN{
    private String ma, ten;
    private int num;

    public DN(String ma, String ten, int num) {
        this.ma = ma;
        this.ten = ten;
        this.num = num;
    }
    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public int getNum() {
        return num;
    }
    
}

class SV{
    private String ma, ten, lop, email, company, companyID;
    private int num;

    public int getNum() {
        return num;
    }
    
    public void setCompany(String company) {
        this.company = company;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getCompanyID() {
        return companyID;
    }

    public String getCompany() {
        return company;
    }

    public SV(String ma, String ten, String lop, String email) {
        this.ma = ma;
        this.ten = chuanHoa(ten);
        this.lop = lop;
        this.email = email;
    }
    public String chuanHoa(String s){
        String[] x = s.trim().toLowerCase().split("\\s+");
        String ans = "";
        for(String i: x)
            ans += i.substring(0, 1).toUpperCase() + i.substring(1) + " ";
        return ans.trim();
    }
    public String getMa() {
        return ma;
    }
    
    public String toString(){
        return ma + " " + ten + " " + lop;
    }
}

class ThucTap{
    private SV sv;
    private DN dn;

    public ThucTap(SV sv, DN dn) {
        this.sv = sv;
        this.dn = dn;
    }

    public void setSv(SV sv) {
        this.sv = sv;
    }

    public void setDn(DN dn) {
        this.dn = dn;
    }

    public SV getSv() {
        return sv;
    }

    public DN getDn() {
        return dn;
    }
}
public class J07038_DanhSachThucTap3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File("SINHVIEN.in"));
        int n = Integer.parseInt(sc1.nextLine());
        ArrayList<SV> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            SV x = new SV(sc1.nextLine(), sc1.nextLine(), sc1.nextLine(), sc1.nextLine());
            arr.add(x);
        }
        Scanner sc2 = new Scanner(new File("DN.in"));
        ArrayList<DN> b = new ArrayList<>();
        int m = Integer.parseInt(sc2.nextLine());
        for(int i = 0; i < m; i++){
            DN x = new DN(sc2.nextLine(), sc2.nextLine(), Integer.parseInt(sc2.nextLine()));
            b.add(x);
        }
        Scanner sc3 = new Scanner(new File("THUCTAP.in"));
        int k = Integer.parseInt(sc3.nextLine());
        ArrayList<ThucTap> c = new ArrayList<>();
        while(k-->0){
            String[] x = sc3.nextLine().split(" ");
            String ma = x[0];
            String dn = x[1];
            for(SV i: arr)
                if(i.getMa().equals(ma))
                    for(DN j: b)
                        if(j.getMa().equals(dn)){
                            c.add(new ThucTap(i, j));
                        }
        }
        Collections.sort(c, new Comparator<ThucTap>(){
            @Override
            public int compare(ThucTap x, ThucTap y) {
                return x.getSv().getMa().compareTo(y.getSv().getMa());
            }
            
        });
        int q = Integer.parseInt(sc3.nextLine());
        while(q-->0){
            String ma = sc3.nextLine();
            int cnt = 0, num = 0;
            for(DN i: b)
                if(i.getMa().equals(ma))
                {
                    System.out.println("DANH SACH THUC TAP TAI " + i.getTen() + ":");
                    num = i.getNum();
                    break;
                }
            for(ThucTap i: c)
                if(i.getDn().getMa().equals(ma) && cnt < num)
                {
                    System.out.println(i.getSv());
                    cnt++;
                }
        }
    }
}
