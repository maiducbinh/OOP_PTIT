
import java.util.*;

class Pair<F, S>{
    private F f;
    private S s;
    Pair(F f, S s){
        this.f = f;
        this.s = s;
    }
    public boolean checkPrime(int x){
        if(x < 2) return false;
        for(int i = 2; i <= Math.sqrt(x); i++)
            if(x % i == 0) return false;
        return true;
    }
    public boolean isPrime(){
        if(checkPrime((Integer)this.f) && checkPrime((Integer)this.s))
            return true;
        return false;
    }
    public String toString(){
        return this.f + " " + this.s;
    }
}
public class J04020_LopPair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
