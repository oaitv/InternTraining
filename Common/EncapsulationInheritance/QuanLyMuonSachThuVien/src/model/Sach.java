package model;

import java.io.Serializable;

public class Sach implements Serializable {
    public static int id = 100000;
    private int maBanDoc;
    private String tenSach;
    private String tacGia;
    private String chuyenNganh;
    private int namXuatBan;
    private int soLuong;

    public Sach(int maBanDoc) {
        this.maBanDoc = maBanDoc;
    }

    public Sach() {
       // setSachID();
    }

    public Sach(String tenSach, String tacGia,
                String chuyenNganh, int namXuatBan, int soLuong) {
        setSachID();// id tu tang
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.chuyenNganh = chuyenNganh;
        this.namXuatBan = namXuatBan;
        this.soLuong = soLuong;
    }

    public int getSachID() {
        return maBanDoc;
    }

    public void setSachID() {
        this.maBanDoc = id++;
    }

    public void setSachID(int id){
        maBanDoc = id;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[maBanDoc= " + maBanDoc + ", tenSach= " + tenSach
                + ", chuyenNganh= " + chuyenNganh + ", tacGia= " + tacGia
                + ", namXuatBan= " + namXuatBan + ", soLuong= " + soLuong + "]";
    }
}
