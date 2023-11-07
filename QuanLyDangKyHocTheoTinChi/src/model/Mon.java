/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.*;

/**
 *
 * @author 84912
 */
public class Mon implements Serializable{
    private int ma;
    private String ten;
    private int soTiet;
    private String loai;

    public Mon() {
    }

    public Mon(int ma, String ten, int soTiet, String loai) {
        this.ma = ma;
        this.ten = ten;
        this.soTiet = soTiet;
        this.loai = loai;
    }

    

    public int getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public int getSoTiet() {
        return soTiet;
    }

    public String getLoai() {
        return loai;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setSoTiet(int soTiet) {
        this.soTiet = soTiet;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
    
    public Object[] toObject(){
        return new Object[]{
            ma, ten, soTiet, loai
        };
    }
    
}
