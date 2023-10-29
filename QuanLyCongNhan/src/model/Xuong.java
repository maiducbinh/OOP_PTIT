package model;

import java.io.Serializable;

public class Xuong implements Serializable {

    private int ma;
    private String ten;
    private int heSo;

    public Xuong(int ma, String ten, int heSo) {
        this.ma = ma;
        this.ten = ten;
        this.heSo = heSo;
    }

    public Xuong() {
    }

    public int getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public int getHeSo() {
        return heSo;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setHeSo(int heSo) {
        this.heSo = heSo;
    }
    
    public Object[] toObject(){
        return new Object[]{ma, ten, heSo};
    }
}
