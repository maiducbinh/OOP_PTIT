
package model;

import java.io.Serializable;

public class BangChamCong implements Serializable{
    private CongNhan congNhan;
    private Xuong xuong;
    private int soNgay;

    public BangChamCong() {
    }

    public BangChamCong(CongNhan congNhan, Xuong xuong, int soNgay) {
        this.congNhan = congNhan;
        this.xuong = xuong;
        this.soNgay = soNgay;
    }

    public CongNhan getCongNhan() {
        return congNhan;
    }

    public Xuong getXuong() {
        return xuong;
    }

    public int getSoNgay() {
        return soNgay;
    }

    public void setCongNhan(CongNhan congNhan) {
        this.congNhan = congNhan;
    }

    public void setXuong(Xuong xuong) {
        this.xuong = xuong;
    }

    public void setSoNgay(int soNgay) {
        this.soNgay = soNgay;
    }
    
    public Object[] toObject(){
        return new Object[]{congNhan.getMa(), congNhan.getTen(), xuong.getMa(), soNgay};
    }
    
    public int thuNhap(){
        return soNgay * xuong.getHeSo() * 140000;
    }
    
    public String vietTK(){
        return congNhan.getMa() + ": " + congNhan.getTen();
    }
}
