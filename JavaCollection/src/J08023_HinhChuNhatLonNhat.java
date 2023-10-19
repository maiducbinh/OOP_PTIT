
import java.util.Scanner;
import java.util.Stack;

public class J08023_HinhChuNhatLonNhat {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] h = new long[n + 1];
            for (int i = 0; i < n; i++) {
                h[i] = sc.nextLong();
            }
            Stack<Integer> st = new Stack<>();
            int i = 0;
            long mx = 0;
            while (i < n) {
                if (st.empty() || (!st.empty() && h[st.peek()] < h[i])) {
                    st.push(i++);
                } else {
                    int top = st.peek();
                    st.pop();
                    if (st.isEmpty()) {
                        mx = Math.max(mx, h[top] * i);
                    } else {
                        mx = Math.max(mx, h[top] * (i - st.peek() - 1));
                    }
                }
            }
            while (!st.isEmpty()) {
                int top = st.peek();
                st.pop();
                if (st.isEmpty()) {
                    mx = Math.max(mx, h[top] * i);
                } else {
                    mx = Math.max(mx, h[top] * (i - st.peek() - 1));
                }
            }
            System.out.println(mx);
        }
    }
}
