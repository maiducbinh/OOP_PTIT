
import java.util.Scanner;
import java.util.Stack;

public class J08021_DayNgoacDungDaiNhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0)
        {
            String s = sc.next();
            Stack<Integer> st = new Stack<>();
            st.add(-1);
            int mx = 0;
            for(int i = 0; i < s.length(); i++)
                if(s.charAt(i) == '(') st.add(i);
                else{
                    st.pop();
                    if(!st.isEmpty())
                        mx = Math.max(mx, i - st.peek());
                    else st.add(i);
                }
            System.out.println(mx);
        }
    }
}
