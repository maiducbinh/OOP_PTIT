
import java.util.*;
import java.util.Comparator;
// Loi: neu GD > 001 thi set NV. Tuong tu voi TP, PP
class NV6{
    private String ma, ten, so, bac, chucVu;
    NV6(Scanner sc){
        String s[] = sc.nextLine().split(" ");
        ma = s[0];
        ten = "";
        for(int i = 1; i < s.length; i++) ten += s[i] + " ";
        ten = ten.trim();
        bac = s[0].substring(2, 4);
        so = s[0].substring(4);
        chucVu = s[0].substring(0, 2);
    }
    public String toString(){
        return ten + " " + chucVu + " " + so + " " + bac;
    }

    public String getSo() {
        return so;
    }

    public String getChucVu() {
        return chucVu;
    }
    public String getTen(){
        return ten;
    }
    public String getBac() {
        return bac;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
}
public class J05066_TimKiemNhanVienTheoTen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<NV6> a = new ArrayList<>();
        int cntGD = 0, cntTP = 0, cntPP = 0;
        for(int i = 0; i < n; i++){
            NV6 x = new NV6(sc);
            if(x.getChucVu().equals("GD") && x.getSo().compareTo("001") > 0){
                x.setChucVu("NV");
            }
            else if(x.getChucVu().equals("TP") && x.getSo().compareTo("003") > 0){
                x.setChucVu("NV");
            }
            else if(x.getChucVu().equals("PP") && x.getSo().compareTo("003") > 0){
                x.setChucVu("NV");
            }
            a.add(x);
        }
        a.sort(Comparator.comparing(NV6::getBac).reversed().thenComparing(NV6::getSo));
        int m = Integer.parseInt(sc.nextLine());
        while(m-->0){
            String ten = sc.nextLine().toLowerCase();
            for(NV6 i: a)
            {
                String t = i.getTen().toLowerCase();
                if(t.contains(ten)){
                    System.out.println(i);
                }
            }
            System.out.println("");
        }
    }
}
