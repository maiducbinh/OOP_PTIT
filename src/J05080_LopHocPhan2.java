
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

    public String getGv() {
        return gv;
    }

    public String getNhom() {
        return nhom;
    }
    public String toString(){
        return ma + " " + ten + " " + nhom;
    }
}

public class J05080_LopHocPhan2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<GV> arr = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            GV x = new GV(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            arr.add(x);
        }
        arr.sort(Comparator.comparing(GV::getMa).thenComparing(GV::getNhom));
        int m = Integer.parseInt(sc.nextLine());
        while(m-->0){
            String gv = sc.nextLine();
            for(GV i: arr){
                if(i.getGv().equals(gv)){
                    System.out.println("Danh sach cho giang vien " + i.getGv() + ":");
                    break;
                }
            }
            for(GV i: arr)
                if(i.getGv().equals(gv))
                    System.out.println(i);
        }
    }
}
