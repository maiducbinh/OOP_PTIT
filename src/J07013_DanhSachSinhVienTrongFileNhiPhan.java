package danhsachsinhvien1;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class SinhVien implements Serializable{
    private String ma, ten, lop;
    private Date dob;
    private float gpa;
    
    public SinhVien(int id, String ten, String lop, String dob, float gpa) throws ParseException {
        this.ten = ten;
        this.lop = lop;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        this.dob = df.parse(dob);
        this.gpa = gpa;
        this.ma = String.format("B20DCCN%03d", id);
    }
    public String toString(){
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return ma + " " + ten + " " + lop + " " + df.format(dob) + " " + String.format("%.2f", gpa);
    }
}
public class J07013_DanhSachSinhVienTrongFileNhiPhan {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream sc = new ObjectInputStream(new FileInputStream("SV.in"));
        ArrayList<SinhVien> a = (ArrayList<SinhVien>) sc.readObject();
        for(SinhVien i: a){
            System.out.println(i);
        }
    }
}
