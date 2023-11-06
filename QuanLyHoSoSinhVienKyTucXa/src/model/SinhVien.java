/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 84912
 */
public class SinhVien implements Serializable{
    private int ma;
    private String ten, dchi;
    private Date dob;
    private String lop;
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    public SinhVien(int ma, String ten, String dchi, String dob, String lop) throws ParseException {
        this.ma = ma;
        this.ten = ten;
        this.dchi = dchi;
        this.dob = df.parse(dob);
        this.lop = lop;
    }

    public int getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getDchi() {
        return dchi;
    }

    public Date getDob() {
        return dob;
    }

    public String getLop() {
        return lop;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setDchi(String dchi) {
        this.dchi = dchi;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
    
    public Object[] toObject(){
        return new Object[]{
            ma, ten, dchi, df.format(dob), lop
        };
    }
    
}
