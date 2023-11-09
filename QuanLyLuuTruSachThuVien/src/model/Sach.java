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
public class Sach implements Serializable{
    private int ma;
    private String ten, tacGia, chuyenNganh;
    private int nam;

    public Sach(int ma, String ten, String tacGia, String chuyenNganh, int nam) {
        this.ma = ma;
        this.ten = ten;
        this.tacGia = tacGia;
        this.chuyenNganh = chuyenNganh;
        this.nam = nam;
    }

    public int getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getTacGia() {
        return tacGia;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public int getNam() {
        return nam;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }
    
    public Object[] toObject(){
        return new Object[]{
            ma, ten, tacGia, chuyenNganh, nam
        };
    }
}
