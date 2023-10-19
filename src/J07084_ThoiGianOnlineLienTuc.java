
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

class SV{
    private String ten;
    private Date start, end;
    private long onl;
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public SV(String ten, String start, String end) throws ParseException {
        this.ten = ten;
        this.start = df.parse(start);
        this.end = df.parse(end);
        this.onl = (this.end.getTime() - this.start.getTime()) / (1000 * 60);
    }

    public long getOnl() {
        return onl;
    }
    
    public String toString(){
        return ten + " " + onl;
    }
    
}
public class J07084_ThoiGianOnlineLienTuc {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("ONLINE.in"));
        //Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<SV> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            SV x = new SV(sc.nextLine(), sc.nextLine(), sc.nextLine());
            arr.add(x);
        }
        arr.sort(Comparator.comparing(SV::getOnl).reversed());
        for(SV i: arr)
            System.out.println(i);
    }
}
