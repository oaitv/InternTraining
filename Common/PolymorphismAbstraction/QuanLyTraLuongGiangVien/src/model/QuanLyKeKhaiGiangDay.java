package model;

public class QuanLyKeKhaiGiangDay {

        private GiangVien giangVien;
        private MonHoc monHoc;

        private int maGV;
        private String tenMonHoc;

        private int soLuongTiet;
        private double tongTienLuong;

    public QuanLyKeKhaiGiangDay() {

    }

    public QuanLyKeKhaiGiangDay(int maGV, String tenMonHoc, int soLuongTiet, double tongTienLuong) {
        this.maGV = maGV;
        this.tenMonHoc = tenMonHoc;
        this.soLuongTiet = soLuongTiet;
        this.tongTienLuong = tongTienLuong;
    }


    public GiangVien getGiangVien() {
            return giangVien;
        }

        public void setGiangVien(GiangVien giangVien) {
            this.giangVien = giangVien;
        }

        public MonHoc getMonHoc() {
            return monHoc;
        }

        public void setMonHoc(MonHoc monHoc) {
            this.monHoc = monHoc;
        }


    public int getSoLuongTiet() {
        return soLuongTiet;
    }

    public void setSoLuongTiet(int soLuongTiet) {
        this.soLuongTiet = soLuongTiet;
    }

    public double getTongTienLuong() {
        return tongTienLuong;
    }

    public void setTongTienLuong(double tongTienLuong) {
        this.tongTienLuong = tongTienLuong;
    }

    public int getMaGV() {
        return maGV;
    }

    public void setMaGV(int maGV) {
        this.maGV = maGV;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

}


