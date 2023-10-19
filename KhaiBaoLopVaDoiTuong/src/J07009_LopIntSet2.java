
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

class IntSet{
    private TreeSet<Integer> ts = new TreeSet<>();
    IntSet(int a[]){
        for(int i: a)
            ts.add(i);
    }
    IntSet(){
        
    }
    public IntSet intersection(IntSet x){
        IntSet ans = new IntSet();
        for(int i: this.ts)
            if(x.ts.contains(i))
                ans.ts.add(i);
        return ans;
    }
    public String toString(){
        String ans = "";
        for(int i: ts)
            ans += i + " ";
        return ans;
    }
}
public class J07009_LopIntSet2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        //Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.intersection(s2);
        System.out.println(s3);
    }
}
