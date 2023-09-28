
import java.util.*;

class IntSet{
    private TreeSet<Integer> ts;
    IntSet(){
    }
    IntSet(int[] x){
        ts = new TreeSet<>();
        for(int i: x)
            ts.add(i);
    }
    public IntSet union(IntSet a){
        TreeSet<Integer> se = new TreeSet<>();
        for(int i: a.ts)
            se.add(i);
        for(int i: this.ts)
            se.add(i);
        int n = se.size();
        int[] arr = new int[n];
        int cnt = 0;
        for(int i: se)
            arr[cnt++] = i;
        return new IntSet(arr);
    }
    public String toString(){
        String ans = "";
        for(int i: this.ts)
            ans += i + " ";
        return ans;
    }
}
public class J04021_LopIntSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.union(s2);
        System.out.println(s3);
    }
}
