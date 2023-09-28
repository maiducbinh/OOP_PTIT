
import java.util.ArrayList;
import java.util.Arrays;
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
public class J02027_KhoangCachNhoHonK {
    static int n, k;
    static Integer[] a = new Integer[100005];
    public static int binarySearch(int l, int r, int x)
    {
        int ans = -1;
        while(l <= r)
        {
            int mid = (l + r) / 2;
            if(a[mid] < x)
            {
                ans = mid;
                l = mid + 1;
            }
            else r = mid - 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            n = sc.nextInt();
            k = sc.nextInt();
            // Integer[] a = new Integer[n + 1]; 
            for(int i = 1; i <= n; i++)
                a[i] = sc.nextInt();
            Arrays.sort(a, 1, n + 1);
            long cnt = 0;
            for(int i = 1; i < n; i++)
            {
                int r = binarySearch(i + 1, n, a[i] + k);
                if(r != -1) cnt += r - i;
            }
            System.out.println(cnt);
        }
    }
}
