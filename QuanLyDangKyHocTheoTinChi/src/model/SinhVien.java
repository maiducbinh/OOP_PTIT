/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author 84912
 */
public class SinhVien implements Serializable{
    private int ma;
    private String ten, dchi, sdt;

    public SinhVien(int ma, String ten, String dchi, String sdt) {
        this.ma = ma;
        this.ten = ten;
        this.dchi = dchi;
        this.sdt = sdt;
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

    public String getSdt() {
        return sdt;
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

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
    public Object[] toObject(){
        return new Object[]{
            ma, ten, dchi, sdt
        };
    }
    
}
