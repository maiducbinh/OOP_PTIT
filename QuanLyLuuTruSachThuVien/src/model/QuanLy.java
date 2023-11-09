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
public class QuanLy implements Serializable{
    private Sach sach;
    private Ke ke;
    private int soLuong;

    public QuanLy(Sach sach, Ke ke, int soLuong) {
        this.sach = sach;
        this.ke = ke;
        this.soLuong = soLuong;
    }

    public Sach getSach() {
        return sach;
    }

    public Ke getKe() {
        return ke;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public void setKe(Ke ke) {
        this.ke = ke;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    public Object[] toObject(){
        return new Object[]{
            sach.getMa(), sach.getTen(), ke.getMa(), soLuong
        };
    }
}
