import java.util.Scanner;
// Loi: phai dung replaceAll de thay the regex

public class J03029_ChuanHoaCau {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine().toLowerCase().trim();
            s = s.replaceAll("\\s+", " ");
            s = s.replaceAll("\\s+([.!?])", "$1");
            // Truong hop giua cac dau cau co space, () giup khoanh vung nhom (luc nay se la nhom so 1 $1)
            s = s.substring(0, 1).toUpperCase() + s.substring(1);
            if(Character.isAlphabetic(s.charAt(s.length() - 1)))
                s += '.';
            System.out.println(s);
        }
    }
}