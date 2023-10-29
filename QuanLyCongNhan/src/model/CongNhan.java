package model;

import java.io.Serializable;


public class CongNhan implements Serializable{
    private int ma;
    private String ten, dchi, dthoai;
    private int bac;

    public CongNhan(int ma, String ten, String dchi, String dthoai, int bac) {
        this.ma = ma;
        this.ten = ten;
        this.dchi = dchi;
        this.dthoai = dthoai;
        this.bac = bac;
    }

    public CongNhan() {
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

    public String getDthoai() {
        return dthoai;
    }

    public int getBac() {
        return bac;
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

    public void setDthoai(String dthoai) {
        this.dthoai = dthoai;
    }

    public void setBac(int bac) {
        this.bac = bac;
    }
    
    public Object[] toObject(){
        return new Object[]{ma, ten, dchi, dthoai, bac};
    }
}
