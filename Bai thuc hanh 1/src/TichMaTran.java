
import java.util.Scanner;

class Matran{
    private int n;
    private int[][] a;
    Matran(int n){
        this.n = n;
        this.a = new int[n][n];
    }
    public void input(Scanner sc){
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                this.a[i][j] = sc.nextInt();
    }
    public int getKT(){
        return n;
    }
    public Matran tich(Matran x){
        Matran res = new Matran(n);
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++){
                res.a[i][j] = 0;
                for(int k = 0; k < n; k++){
                    res.a[i][j] += this.a[i][k] * x.a[k][j];
                }
            }
        }
        return res;
    }
    public Matran getMatran(){
        return this;
    }
    public void out(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
    }
}

public class TichMaTran {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //nhap kich thuoc
        int n=sc.nextInt();
        Matran m=new Matran(n);
        //nhap ma tran a
        m.input(sc);
        Matran b=new Matran(m.getKT());
        //nhap ma tran b
        b.input(sc);
        Matran t=m.tich(b.getMatran());
        //viet ra ma tran tich
        t.out();
    }
}
