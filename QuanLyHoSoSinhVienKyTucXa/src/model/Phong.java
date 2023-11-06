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
public class Phong implements Serializable{
    private int ma;
    private String ten, loai;
    private int num;

    public Phong(int ma, String ten, String loai) {
        this.ma = ma;
        this.ten = ten;
        this.loai = loai;
        this.num = 8;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
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

    public void setMa(int ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
    
    public Object[] toObject(){
        return new Object[]{
            ma, ten, loai
        };
    }
}
