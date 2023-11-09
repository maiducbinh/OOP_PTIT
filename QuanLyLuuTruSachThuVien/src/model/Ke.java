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
public class Ke implements Serializable{
    private int ma;
    private String ten, loai;
    private int soLuong;

    public Ke(int ma, String ten, String loai, int soLuong) {
        this.ma = ma;
        this.ten = ten;
        this.loai = loai;
        this.soLuong = soLuong;
    }

    public int getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getLoai() {
        return loai;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    public Object[] toObject(){
        return new Object[]{
            ma, ten, loai, soLuong
        };
    }
}
