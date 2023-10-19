
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

class KH{
    private String ten, gt, add, ma;
    private Date dob;
    static int stt = 1;
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    public KH(String ten, String gt, String dob, String add) throws ParseException {
        this.ten = chuanHoa(ten);
        this.gt = gt;
        this.add = add;
        this.dob = df.parse(dob);
        this.ma = String.format("KH%03d", stt++);
    }

    public Date getDob() {
        return dob;
    }
    public String chuanHoa(String s){
        String[] x = s.toLowerCase().trim().split("\\s+");
        String ans = "";
        for(String i: x)
            ans += i.substring(0, 1).toUpperCase() + i.substring(1) + " ";
        return ans.trim();
    }
    public String toString(){
        return ma + " " + ten + " " + gt +  " " + add + " " + df.format(dob);
    }
}
public class J05082_DanhSachKhanhHang {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        ArrayList<KH> arr = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            KH x = new KH(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            arr.add(x);
        }
        arr.sort(Comparator.comparing(KH::getDob));
        for(KH i: arr)
            System.out.println(i);
    }
}
