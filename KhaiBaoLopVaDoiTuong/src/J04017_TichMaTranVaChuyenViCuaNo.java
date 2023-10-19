
import java.util.Scanner;

class Matrix{
    private int n, m;
    private int[][] a;
    Matrix(int n, int m){
        this.n = n;
        this.m = m;
        a = new int[n][m];
    }
    public void nextMatrix(Scanner sc){
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();
    }
    public Matrix trans(){
        Matrix ans = new Matrix(m, n);
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                ans.a[j][i] = a[i][j];
        return ans;
    }
    public Matrix mul(Matrix x){
        Matrix ans = new Matrix(n, x.m);
        for(int i = 0; i < n; i++)
            for(int j = 0; j < x.m; j++){
                ans.a[i][j] = 0;
                for(int k = 0; k < m; k++)
                    ans.a[i][j] += this.a[i][k] * x.a[k][j];
            }
        return ans;
    }
    public String toString(){
        String ans = "";
        for(int i = 0; i < n; i++){
            String tmp = "";
            for(int j = 0; j < m; j++)
                tmp += a[i][j] + " ";
            tmp += "\n";
            ans += tmp;
        }
        return ans;
    }
}
public class J04017_TichMaTranVaChuyenViCuaNo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
             int n = sc.nextInt(), m = sc.nextInt();
             Matrix a = new Matrix(n,m);
             a.nextMatrix(sc);
             Matrix b = a.trans();
             System.out.println(a.mul(b));
        }
    }
}
