
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class J02012_SapXepChen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        ArrayList<Integer> b = new ArrayList<>();
        for(int i = 0; i < n; i++){
            System.out.print("Buoc " + i + ": ");
            b.add(sc.nextInt());
            Collections.sort(b);
            for(int j: b)
            {
                System.out.print(j + " ");
            }
            System.out.println("");
        }
    }
}
