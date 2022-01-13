package model;

import java.io.Serializable;

public class QuanLyMuonSach implements Serializable {
    private BanDoc banDoc;
    private Sach sachs;
    private int soLuongMuon;
    private String trangThai;
    private int tongSo;

    public int getTotal() {
        return tongSo;
    }

    public void setTotal(int tongSo) {
        this.tongSo = tongSo;
    }

    public BanDoc getBanDoc() {
        return banDoc;
    }

    public void setBanDoc(BanDoc banDoc) {
        this.banDoc = banDoc;
    }

    public Sach getSachs() {
        return sachs;
    }

    public void setSachs(Sach sachs) {
        this.sachs = sachs;
    }

    public int getSoLuongMuon() {
        return soLuongMuon;
    }

    public void setSoLuongMuon(int soLuongMuon) {
        this.soLuongMuon = soLuongMuon;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public QuanLyMuonSach() {
    }

    public QuanLyMuonSach(BanDoc banDoc, Sach sachs, int soLuongMuon, String trangThai) {
        this.banDoc = banDoc;
        this.sachs = sachs;
        this.soLuongMuon = soLuongMuon;
        this.trangThai = trangThai;
    }
}
