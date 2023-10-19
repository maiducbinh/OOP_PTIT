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
import java.util.logging.Level;
import java.util.logging.Logger;

public class SinhVien implements Serializable{
    private String ma, ten, lop;
    private Date dob;
    private float gpa;
    
    public SinhVien(int id, String ten, String lop, String dob, float gpa){
        this.ma = String.format("B20DCCN%03d", id + 1);
        this.ten = ten;
        this.lop = lop;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.dob = df.parse(dob);
        } catch (ParseException ex) {
            Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.gpa = gpa;
        
    }
    
    @Override
    public String toString(){
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return ma + " " + ten + " " + lop + " " + df.format(dob) + " " + String.format("%.2f", gpa);
    }
}