
import java.util.ArrayList;
import java.util.Comparator;
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
public class J08015_CapSoCoTongBangK {
    public static int n;
    public static long k;
    public static ArrayList<Long> arr = new ArrayList<>();
    public static int lowerBound(int l, int r, long x)
    {
        int ans = -1;
        while(l <= r)
        {
            int mid = (l + r) / 2;
            if(arr.get(mid) == x)
            {
                ans = mid;
                r = mid - 1;
            }
            else if(arr.get(mid) > x) r = mid - 1;
            else l = mid + 1;
        }
        return ans;
    }
    public static int upperBound(int l, int r, long x)
    {
        int ans = -1;
        while(l <= r)
        {
            int mid = (l + r) / 2;
            if(arr.get(mid) == x)
            {
                ans = mid;
                l = mid + 1;
            }
            else if(arr.get(mid) > x) r = mid - 1;
            else l = mid + 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            n = sc.nextInt();
            k = sc.nextLong();
            arr.clear();
            for(int i = 0; i < n; i++)
            {
                long x = sc.nextLong();
                arr.add(x);
            }
            arr.sort(new Comparator<Long>(){
                @Override
                public int compare(Long t, Long t1) {
                    if(t < t1) return -1;
                    else return 1;
                }
            });
            long cnt = 0;
            //for(long i: arr) System.out.print(i + " ");
            for(int i = 0; i < n - 1; i++)
            {
                int l = lowerBound(i + 1, n - 1, k - arr.get(i));
                int r = upperBound(i + 1, n - 1, k - arr.get(i));
                if(l != -1)
                    cnt += r - l + 1;
            }
            System.out.println(cnt);
        }
    }
}
