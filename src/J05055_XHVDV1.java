
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class VDV{
    private String ten, dob, ma;
    private Date start, end, thuc, xh;
    private int age, rank;
    static int stt = 1;
    SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
    public VDV(String ten, String dob, String start, String end) throws ParseException {
        this.ten = ten;
        this.dob = dob;
        this.start = df.parse(start);
        this.end = df.parse(end);
        this.age = 2021 - Integer.parseInt(dob.substring(dob.length() - 4));
        this.ma = String.format("VDV%02d", stt++);
        this.thuc = msToTime(this.end.getTime() - this.start.getTime());
        this.xh = msToTime(this.thuc.getTime() - uuTien().getTime());
    }
    public Date uuTien() throws ParseException{
        if(age < 18) return df.parse("00:00:00");
        else if(age < 25) return df.parse("00:00:01");
        else if(age < 32) return df.parse("00:00:02");
        return df.parse("00:00:03");
    }
    public Date msToTime(long ms) throws ParseException{
        long h = ms / (1000 * 60 * 60);
        long m = (ms - h * 1000 * 60 * 60) / (1000 * 60);
        long s = (ms - h * 1000 * 60 * 60 - m * 1000 * 60) / 1000;
        return df.parse(String.format("%02d:%02d:%02d", h, m, s));
    
    }

    public Date getThuc() {
        return thuc;
    }

    public Date getXh() {
        return xh;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getMa() {
        return ma;
    }
    public String toString(){
        try {
            return ma + " " + ten + " " + df.format(thuc) + " " + df.format(uuTien()) + " " + df.format(xh) + " " + rank;
        } catch (ParseException ex) {
            Logger.getLogger(VDV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
public class J05055_XHVDV1 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<VDV> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            VDV x = new VDV(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            arr.add(x);
        }
        arr.sort(Comparator.comparing(VDV::getXh));
        int cnt = 1;
        arr.get(0).setRank(cnt);
        // Loi: phai so sanh thoi gian xep hang
        for(int i = 1; i < n; i++){
            if(!arr.get(i).getXh().equals(arr.get(i - 1).getXh()))
                cnt = i + 1;
            arr.get(i).setRank(cnt);
        }
        arr.sort(Comparator.comparing(VDV::getMa));
        for(VDV i: arr)
            System.out.println(i);
    }
}
