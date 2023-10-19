
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class HocSinh {

    private String ten, ma;
    private int xepHang;
    private double diem;
    static int stt = 1;

    public String getMa() {
        return ma;
    }

    public double getDiem() {
        return diem;
    }

    public HocSinh(String ten, double diem) {
        this.ten = ten;
        this.diem = diem;
        this.ma = String.format("HS%02d", stt++);
    }

    private String xepLoai() {
        if (diem < 5) {
            return "Yeu";
        } else if (diem < 7) {
            return "Trung Binh";
        } else if (diem < 9) {
            return "Kha";
        }
        return "Gioi";
    }

    public String toString() {
        return ma + " " + ten + " " + String.format("%.1f", diem) + " " + xepLoai() + " " + xepHang;
    }

    public void setXepHang(int xepHang) {
        this.xepHang = xepHang;
    }
}

public class J05054_XHHS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<HocSinh> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            HocSinh x = new HocSinh(sc.nextLine(), Double.parseDouble(sc.nextLine()));
            arr.add(x);
        }
        arr.sort(Comparator.comparing(HocSinh::getDiem).reversed());
        int cnt = 1;
        arr.get(0).setXepHang(cnt);
        for (int i = 1; i < n; i++) {
            {
                if (arr.get(i).getDiem() != arr.get(i - 1).getDiem()) {
                    cnt = i + 1;
                }
                arr.get(i).setXepHang(cnt);
            }
        }
        arr.sort(Comparator.comparing(HocSinh::getMa));
        for (HocSinh i : arr) {
            System.out.println(i);
        }

    }
}
