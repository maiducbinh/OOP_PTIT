
import java.util.Scanner;
import java.util.Stack;


public class JKT015_GoBanPhim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> l = new Stack<>(), r = new Stack<>();
        for(int i = 0; i < s.length(); i++)
            if(s.charAt(i) == '-')
            {
                if(!l.isEmpty()) l.pop();
            }
            else if(s.charAt(i) == '<'){
                if(!l.isEmpty()){
                    r.push(l.peek());
                    l.pop();
                }
            }
            else if(s.charAt(i) == '>'){
                if(!r.isEmpty()){
                    l.push(r.peek());
                    r.pop();
                }
            }
            else l.push(s.charAt(i));
        while(!l.isEmpty()){
            r.push(l.peek());
            l.pop();
        }
        while(!r.isEmpty()){
            System.out.print(r.peek());
            r.pop();
        }
    }
}
