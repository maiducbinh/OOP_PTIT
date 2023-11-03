
package model;

import java.io.Serializable;

public class MuonSach implements Serializable{
    private BanDoc bandoc;
    private Sach sach;
    private int soLuong;
    private String ttrang;

    public MuonSach(BanDoc bandoc, Sach sach, int soLuong, String ttrang) {
        this.bandoc = bandoc;
        this.sach = sach;
        this.soLuong = soLuong;
        this.ttrang = ttrang;
    }

    public BanDoc getBandoc() {
        return bandoc;
    }

    public Sach getSach() {
        return sach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public String getTtrang() {
        return ttrang;
    }

    public void setBandoc(BanDoc bandoc) {
        this.bandoc = bandoc;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setTtrang(String ttrang) {
        this.ttrang = ttrang;
    }
    
    public String vietTK(){
        return bandoc.getMa() + ": " + bandoc.getTen();
    }
    
    public Object[] toObject(){
        return new Object[] {bandoc.getMa(), bandoc.getTen(), sach.getMa(), sach.getTen(), soLuong, ttrang};
    }
}
