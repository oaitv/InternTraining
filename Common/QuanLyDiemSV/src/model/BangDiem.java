package model;

public class BangDiem {
    private int maBangDiem;
    private int maSV;
    private int maMonHoc;
    private double diem;

    public BangDiem(int maSV, int maMonHoc, double diem) {
        this.maSV = maSV;
        this.maMonHoc = maMonHoc;
        this.diem = diem;
    }

    public BangDiem() {

    }

    public int getMaBangDiem() {
        return maBangDiem;
    }

    public void setMaBangDiem(int maBangDiem) {
        this.maBangDiem = maBangDiem;
    }

    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    public int getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(int maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }
}
