
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Pair<F, S>{
    private F f;
    private S s;

    Pair(F f, S s) {
        this.f = f;
        this.s = s;
    }
    public boolean prime(int x)
    {
        if(x < 2) return false;
        for(int i = 2; i <= Math.sqrt(x); i++)
            if(x % i == 0) return false;
        return true;
    }
    public boolean isPrime(){
        if(prime((Integer)this.f) == true && prime((Integer)this.s) == true)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return f + " " + s;
    }
    
    
}
public class J07017_LopPair {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            boolean check = false;
            for(int i = 2; i <= 2*Math.sqrt(n); i++){
                Pair<Integer, Integer> p = new Pair<>(i, n-i);
                if(p.isPrime()){
                    System.out.println(p);
                    check = true;
                    break; 
                }
            }
            if(!check) System.out.println(-1);
        }
    }
}
