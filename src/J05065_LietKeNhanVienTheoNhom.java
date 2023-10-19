
import java.util.*;
import java.util.Comparator;

class NV5{
    private String ma, ten, so, bac, chucVu;
    NV5(Scanner sc){
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

    public String getBac() {
        return bac;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
}
public class J05065_LietKeNhanVienTheoNhom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<NV5> a = new ArrayList<>();
        int cntGD = 0, cntTP = 0, cntPP = 0;
        for(int i = 0; i < n; i++){
            NV5 x = new NV5(sc);
            if(x.getChucVu().equals("GD")){
                if(cntGD < 1) {
                    cntGD++;
                }
                else x.setChucVu("NV");
            }
            else if(x.getChucVu().equals("TP")){
                if(cntTP < 3) {
                    cntTP++;
                }
                else x.setChucVu("NV");
            }
            else if(x.getChucVu().equals("PP")){
                if(cntPP < 3) {
                    cntPP++;
                }
                else x.setChucVu("NV");
            }
            a.add(x);
        }
        a.sort(Comparator.comparing(NV5::getBac).reversed().thenComparing(NV5::getSo));
        int m = Integer.parseInt(sc.nextLine());
        while(m-->0){
            String ma = sc.nextLine();
            for(NV5 i: a)
                if(i.getChucVu().equals(ma)){
                    System.out.println(i);
                }
            System.out.println("");
        }
    }
}
