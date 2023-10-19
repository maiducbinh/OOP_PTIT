
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

class Item implements Comparable<Item>{
    private String ten, ma;

    public void setMa(int stt) {
        String[] a = ten.toUpperCase().split(" ");
        this.ma = a[0].substring(0, 1) + a[1].substring(0, 1) + String.format("%02d", stt);
    }
    private long luong, gia;
    static int stt = 1;
    Item(String ten, long luong, long gia) {
        this.ten = ten;
        this.luong = luong;
        this.gia = gia;
    }
    /*
     Tiền chiết khấu = Đơn giá * Số lượng * Phần trăm chiết khấu.

Với:

 Phần trăm chiết khấu là 5% nếu số lượng > 10,

 Phần trăm chiết khấu là 2% nếu 8 <= số lượng <= 10,

 Phần trăm chiết khấu là 1% nếu 5 <= số lượng <8,

 Phần trăm chiết khấu là 0 nếu số lượng < 5.
    */
    public long chietKhau(){
        if(luong > 10) return (long)Math.round((double) gia * luong * 0.05);
        else if(luong >= 8) return (long)Math.round((double)gia * luong * 0.02);
        else if(luong >= 5) return (long)Math.round((double)gia * luong * 0.01);
        return 0;
    }
    public long thanhTien(){
        return gia * luong - chietKhau();
    }

    @Override
    public int compareTo(Item t) {
        if(this.chietKhau() > t.chietKhau())
            return -1;
        return 1;
    }
    public String toString(){
        return ma + " " + ten + " " + chietKhau() + " " + thanhTien();
    }
}
public class J05047_SapXepTheoChietKhau {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, Integer> mp = new HashMap<>(); 
        ArrayList<Item> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String ten = sc.nextLine();
            Item x = new Item(ten, Long.parseLong(sc.nextLine()), Long.parseLong(sc.nextLine()));
            String[] a = ten.toUpperCase().split(" ");
            String ma = a[0].substring(0, 1) + a[1].substring(0, 1);
            if(mp.containsKey(ma)) 
                mp.put(ma, mp.get(ma) + 1);
            else mp.put(ma, 1);
            x.setMa(mp.get(ma));
            arr.add(x);
        }
        //Collections.sort(arr);
        for(Item i: arr)
            System.out.println(i);
    }
}
