
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class KhachHang implements Comparable<KhachHang>{
    private String ma, loai;
    private int cu, moi;
    static int stt = 1;
    public KhachHang(String loai, int cu, int moi) {
        this.loai = loai;
        this.ma = String.format("KH%02d", stt++);
        this.cu = cu;
        this.moi = moi;
    }
    /*
     - Nếu Loại SD là "KD" thì Hệ số = 3                                                       

            - Nếu Loại SD là "NN" thì Hệ số = 5                                                       

            - Nếu Loại SD là "TT" thì Hệ số = 4                                                        

            - Nếu Loại SD là "CN" thì Hệ số = 2   
    */
    public int heSo(){
        if(loai.charAt(0) == 'K') return 3;
        else if(loai.charAt(0) == 'N') return 5;
        else if(loai.charAt(0) == 'T') return 4;
        return 2;
    }
    public long thanhTien(){
        return (long)(moi - cu) * heSo() * 550;
    }
    public long phuTroi(){
        if(moi - cu < 50) return 0;
        else if(moi - cu <= 100) return (long)Math.ceil((double)thanhTien() * 0.35);
        return thanhTien();
    }
    public long tong(){
        return phuTroi() + thanhTien();
    }
    public String toString(){
        return ma + " " + heSo() + " " + thanhTien() + " " + phuTroi() + " " + (phuTroi() + thanhTien());
    }

    @Override
    public int compareTo(KhachHang t) {
        return -(int)(this.tong() - t.tong());
    }
}
public class J05051_SXTienDien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<KhachHang> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            KhachHang x = new KhachHang(sc.nextLine(), Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()));
            arr.add(x);
        }
        //Collections.sort(arr);
        for(KhachHang i: arr)
            System.out.println(i);
    }
}
