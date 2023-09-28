
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 84912
 */
public class JKT013_SoLocPhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            Queue<String> q = new LinkedList<>();
            ArrayList<String> arr = new ArrayList<>();
            q.add("6");
            q.add("8");
            while(true)
            {
                String tmp = q.poll();
                if(tmp.length() > n)
                    break;
                arr.add(tmp);
                q.add(tmp + "6");
                q.add(tmp + "8");
            }
            arr.sort(new Comparator<String>(){
                @Override
                public int compare(String t, String t1) {
                    if(t.length() > t1.length())
                        return -1;
                    else if(t.length() < t1.length())
                        return 1;
                    else return -t.compareTo(t1);
                }
            });
            System.out.println(arr.size());
            for(String i: arr) System.out.print(i + " ");
            System.out.println("");
        }
    }
}
