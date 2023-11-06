/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author 84912
 */
public class DangKy implements Serializable{
    private SinhVien sinhVien;
    private Phong phong;
    private Date stDate;
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    public DangKy(SinhVien sinhVien, Phong phong, String stDate) throws ParseException {
        this.sinhVien = sinhVien;
        this.phong = phong;
        this.stDate = df.parse(stDate);
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public Phong getPhong() {
        return phong;
    }

    public Date getStDate() {
        return stDate;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    public void setStDate(Date stDate) {
        this.stDate = stDate;
    }
    
    public String vietTK(){
        return sinhVien.getMa() + ": " + sinhVien.getTen();
    }
    
    public int phi(){
        Date cur = new Date();
        LocalDate curDate = cur.toInstant().atZone(Calendar.getInstance().getTimeZone().toZoneId()).toLocalDate();
        LocalDate dki = stDate.toInstant().atZone(Calendar.getInstance().getTimeZone().toZoneId()).toLocalDate();
        Period thoiGianDangKy = Period.between(dki, curDate);
        int soThangDangKy = thoiGianDangKy.getYears() * 12 + thoiGianDangKy.getMonths();
        if(phong.getLoai().equals("Phòng VIP"))
            return soThangDangKy * 1000;
        else if(phong.getLoai().equals("Chất lượng cao"))
            return soThangDangKy * 500;
        return soThangDangKy * 300;
    }
    
    public Object[] toObject(){
        return new Object[]{
            sinhVien.getMa(), sinhVien.getTen(),
            phong.getMa(), phong.getTen(),
            df.format(stDate)
        };
    }
    
}
