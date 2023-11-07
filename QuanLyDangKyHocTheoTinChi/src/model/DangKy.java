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
public class DangKy implements Serializable{
    private Mon mon;
    private SinhVien sinhVien;
    private Date date;
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    public DangKy(Mon mon, SinhVien sinhVien, String date) throws ParseException {
        this.mon = mon;
        this.sinhVien = sinhVien;
        this.date = df.parse(date);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    

    public Mon getMon() {
        return mon;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setMon(Mon mon) {
        this.mon = mon;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }
    
    public Object[] toObject(){
        return new Object[]{
            sinhVien.getMa(), sinhVien.getTen(),
            mon.getMa(), df.format(date)
        };
    }
    
    public String vietTK(){
        return mon.getMa() + ": " + mon.getTen();
    }
    
    public int getSV(){
        return 1;
    }
}
