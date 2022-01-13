package model;

import java.io.Serializable;

public class BanDoc implements Serializable {
    public static int id = 10000000;
    private int maBanDoc;
    private String hoTen;
    private String diaChi;
    private String sDt;
    private String loaiBanDoc;

    public BanDoc(int maBanDoc) {
        this.maBanDoc = maBanDoc;
    }

    public BanDoc() {
        //setBanDocID();
    }

    public BanDoc(String hoTen, String diaChi, String sDt) {
        setBanDocID();
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sDt = sDt;
    }


    public BanDoc(String hoTen, String diaChi, String sDt, String loaiBanDoc) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sDt = sDt;
        this.loaiBanDoc = loaiBanDoc;
    }

    public int getBanDocID() {
        return maBanDoc;
    }

    public void setBanDocID() {
        this.maBanDoc = id++;
    }

    public void setBanDocID(int id){
        maBanDoc = id;
    }

    public String getFullName() {
        return hoTen;
    }

    public void setFullName(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSDt() {
        return sDt;
    }

    public void setSDt(String sDt) {
        this.sDt = sDt;
    }

    public String getLoaiBanDoc() {
        return loaiBanDoc;
    }

    public void setLoaiBanDoc(String loaiBanDoc) {
        this.loaiBanDoc = loaiBanDoc;
    }

    @Override
    public String toString() {
        return getClass().getName()+"[maBanDoc= " + maBanDoc + ", hoTen= "+ hoTen
                +", diaChi= " + diaChi + ", sDt= " + sDt + "]";
    }
}
