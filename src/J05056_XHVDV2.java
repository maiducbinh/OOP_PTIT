
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class VDV2{
    private String name, dob, ma;
    private Date start, end, thuc, ttxh;
    private int rank, age;
    static int stt = 1;
    SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
    
    public VDV2(String name, String dob, String start, String end) throws ParseException {
        this.name = name;
        this.dob = dob;
        this.start = df.parse(start);
        this.end = df.parse(end);
        this.ma = String.format("VDV%02d", stt++);
        this.age = 2021 - Integer.parseInt(dob.substring(dob.length() - 4));
        this.thuc = msToTime(this.end.getTime() - this.start.getTime());
        this.ttxh = msToTime(this.thuc.getTime() - uuTien().getTime());
        
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

    public Date getTtxh() {
        return ttxh;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
    public String toString(){
        try {
            return ma + " " + name + " " + df.format(thuc) + " " + df.format(uuTien()) + " " + df.format(ttxh) + " " + rank;
        } catch (ParseException ex) {
            Logger.getLogger(VDV2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
public class J05056_XHVDV2 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<VDV2> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            VDV2 x = new VDV2(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            arr.add(x);
        }
        arr.sort(Comparator.comparing(VDV2::getTtxh));
        int cnt = 1;
        // Loi: ko the dung dau = de so sanh Date
        arr.get(0).setRank(cnt);
        for(int i = 1; i < n; i++){
            if(!arr.get(i).getTtxh().equals(arr.get(i - 1).getTtxh()))
                cnt = i + 1;
            arr.get(i).setRank(cnt);
        }
        for(VDV2 i: arr)
            System.out.println(i);
    }
}
