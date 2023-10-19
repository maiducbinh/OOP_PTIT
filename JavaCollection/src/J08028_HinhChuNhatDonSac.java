
import java.util.Scanner;
import java.util.Stack;
// Loi: dien tich co the toi long

public class J08028_HinhChuNhatDonSac {
    public static long maxRectangle(int a[], int n){
        Stack<Integer> st = new Stack<>();
        long ans = 0;
        int i = 0;
        for(; i < n;){
            if(st.isEmpty() || a[st.peek()] < a[i]) st.push(i++);
            else{
                int top = st.peek(); st.pop();
                if(st.isEmpty()) ans = Math.max(ans, (long)a[top] * i);
                else ans = Math.max(ans, (long)a[top] * (i - st.peek() - 1));
            }
        }
        while(!st.isEmpty()){
            int top = st.peek(); st.pop();
            if(st.isEmpty()) ans = Math.max(ans, (long)a[top] * i);
            else ans = Math.max(ans, (long)a[top] * (i - st.peek() - 1));
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int a[] = new int[n + 5], b[] = new int[n + 5];
        for(int i = 0; i < n; i++)
        {
            a[i] = sc.nextInt();
            b[i] = m - a[i];
        }
        System.out.println(Math.max(maxRectangle(a, n), maxRectangle(b, n)));
    }
}
