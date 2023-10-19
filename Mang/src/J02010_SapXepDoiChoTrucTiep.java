
import java.util.Scanner;


public class J02010_SapXepDoiChoTrucTiep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        for(int i = 0; i < n - 1; i++){
            boolean ok = true;
            for(int j = i + 1; j < n; j++)
                if(a[i] > a[j]) {
                    ok = false;
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }  
            if(ok) break;
            System.out.print("Buoc " + (i + 1) + ": ");
            for(int j: a){
                System.out.print(j + " ");
            }
            System.out.println("");
            
        }
    }
}
