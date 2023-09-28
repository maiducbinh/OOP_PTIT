
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 84912
 */
public class J08012_HinhSao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Long> mp = new HashMap<>();
        for(int i = 1; i < n; i++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(!mp.containsKey(x)) mp.put(x, (long)1);
            else mp.put(x, mp.get(x) + 1);
            if(!mp.containsKey(y)) mp.put(y, (long)1);
            else mp.put(y, mp.get(y) + 1);
        }
        boolean ok = true;
        for(int i = 1; i <= n; i++)
        {
            //System.out.println(mp.get(i));
            if(!mp.containsKey(i))
            {
                ok = false;
                break;
            }
            // Loi: ko kiem tra co i cho truoc hay chua
            
            else if(mp.get(i) != 1 && mp.get(i) != (n - 1))
            {
                ok = false;
                break;
            }
        }
        System.out.println(ok == true? "Yes": "No");
    }
}
