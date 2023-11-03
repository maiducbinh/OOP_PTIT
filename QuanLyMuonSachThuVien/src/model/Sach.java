
package model;

import java.io.Serializable;

public class Sach implements Serializable{
    private int ma;
    private String ten, tacGia, chuyenNganh;
    private int num;

    public Sach(int ma, String ten, String tacGia, String chuyenNganh, int num) {
        this.ma = ma;
        this.ten = ten;
        this.tacGia = tacGia;
        this.chuyenNganh = chuyenNganh;
        this.num = num;
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

    public String getChuyenNganhString() {
        return chuyenNganh;
    }

    public int getNum() {
        return num;
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

    public void setChuyenNganhString(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public void setNum(int num) {
        this.num = num;
    }
    
    public Object[] toObject(){
        return new Object[]{ma, ten, tacGia, chuyenNganh, num};
    }
    
}
