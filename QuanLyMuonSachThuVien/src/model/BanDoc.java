
package model;

import java.io.Serializable;

public class BanDoc implements Serializable{
    private int ma;
    private String ten, diaChi, sdt;

    public BanDoc(int ma, String ten, String diaChi, String sdt) {
        this.ma = ma;
        this.ten = ten;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    public int getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getDiaChi() {
        return diaChi;
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

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
    public Object[] toObject(){
        return new Object[]{ ma, ten, diaChi, sdt};
    }
}
