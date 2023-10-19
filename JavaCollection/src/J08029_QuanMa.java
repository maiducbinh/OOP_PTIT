import java.util.*;

class TPair{
    public int first, second, third;

    public TPair(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
    
}

public class J08029_QuanMa {
    static int a, b, c, d;
    static int dx[] = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int dy[] = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static boolean isOK(int x){
        return (x >= 1 && x <= 8);
    }
    public static int BFS(){
        Queue<TPair> q = new LinkedList<>();
        int check[][] = new int[20][20];
        q.add(new TPair(a, b, 0));
        check[a][b] = 1;
        while(!q.isEmpty()){
            TPair u = q.poll();
            if(u.first == c && u.second == d) return u.third;
            for(int i = 0; i < 8; i++){
                int x = u.first + dx[i];
                int y = u.second + dy[i];
                if(isOK(x) && isOK(y) && check[x][y] == 0){
                    q.add(new TPair(x, y, u.third + 1));
                    check[x][y] = 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0)
        {
            String x = sc.nextLine();
            a = x.charAt(0) - 'a' + 1; b = x.charAt(1) - '0';
            c = x.charAt(3) - 'a' + 1; d = x.charAt(4) - '0';
            System.out.println(BFS());
        }
    }
}
