
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class GV{
    private String ma, ten, nhom, gv;

    public GV(String ma, String ten, String nhom, String gv) {
        this.ma = ma;
        this.ten = ten;
        this.nhom = nhom;
        this.gv = gv;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getNhom() {
        return nhom;
    }
    public String toString(){
        return nhom + " " + gv;
    }
}

class Mon{
    
}
public class J05079_LopHocPhan1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<GV> arr = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            GV x = new GV(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            arr.add(x);
        }
        arr.sort(Comparator.comparing(GV::getNhom));
        int m = Integer.parseInt(sc.nextLine());
        while(m-->0){
            String ma = sc.nextLine();
            for(GV i: arr){
                if(i.getMa().equals(ma)){
                    System.out.println("Danh sach nhom lop mon " + i.getTen() + ":");
                    break;
                }
            }
            for(GV i: arr)
                if(i.getMa().equals(ma))
                    System.out.println(i);
        }
    }
}
