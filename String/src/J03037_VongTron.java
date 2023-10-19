
import java.util.Scanner;


public class J03037_VongTron {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int cnt = 0;
        int pre[] = new int[260], suf[] = new int[260];
        int check[] = new int[260];
        for(int i = 0; i < s.length(); i++)
            if(check[s.charAt(i)] == 0){
                check[s.charAt(i)] = 1;
                pre[s.charAt(i)] = i; 
            }
            else suf[s.charAt(i)] = i;
        for(char i = 'A'; i <= 'Z'; i++)
            for(char j = 'A'; j <= 'Z'; j++)
                if(pre[i] < pre[j] && suf[i] < suf[j] && pre[j] < suf[i]) cnt++;
        System.out.println(cnt);
    }
}
