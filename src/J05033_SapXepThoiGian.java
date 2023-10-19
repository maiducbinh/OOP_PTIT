
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Time{
    public int h, m, s;

    Time(int h, int m, int s) {
        this.h = h;
        this.m = m;
        this.s = s;
    }

    @Override
    public String toString() {
        return h + " " + m + " " + s;
    }
    
}
public class J05033_SapXepThoiGian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Time> a = new ArrayList<>();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++)
        {
            Time x = new Time(sc.nextInt(), sc.nextInt(), sc.nextInt());
            a.add(x);
        }
        Collections.sort(a, new Comparator<Time>(){
            @Override
            public int compare(Time x, Time y) {
                if(x.h != y.h)
                    return x.h - y.h;
                else if(x.m != y.m)
                    return x.m - y.m;
                else return x.s - y.s;
            }
        });
        for(Time i: a)
            System.out.println(i);
    }
}
