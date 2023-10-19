
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class J07008_DayConTangDan {
    public static int n;
    public static int[] a = new int[25], x = new int[25];
    public static ArrayList<String> arr = new ArrayList<>();
    public static void Out()
    {
        String s = "";
        int sum = 0;
        ArrayList<Integer> b = new ArrayList<>();
        for(int i = 1; i <= n; i++)
            if(x[i] == 1)
            {
                s += a[i] + " ";
                sum += 1;
                b.add(a[i]);
            }
        for(int i = 0; i < b.size() - 1; i++)
            if(b.get(i) > b.get(i + 1)) return;
        if(sum > 1) arr.add(s);
    }
    public static void Try(int i)
    {
        for(int j = 0; j <= 1; j++)
        {
            x[i] = j;
            if(i == n) Out();
            else Try(i + 1);
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DAYSO.in"));
        //Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 1; i <= n; i++)
            a[i] = sc.nextInt();
        
        Try(1);
        arr.sort(new Comparator<String>(){
            @Override
            public int compare(String t, String t1) {
                return t.compareTo(t1);
            }
        });
        for(String i: arr)
            System.out.println(i);
    }
}
