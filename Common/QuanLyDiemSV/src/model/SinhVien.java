package model;

import java.io.Serializable;

    public class SinhVien implements Serializable {
        public static int id = 10000;
        private int maSV;
        private String hoTen;
        private String diaChi;
        private String sDT;
        private String lop;

        public SinhVien(int maSV, String hoTen, String diaChi, String sDT, String lop) {
            this.maSV = maSV;
            this.hoTen = hoTen;
            this.diaChi = diaChi;
            this.sDT = sDT;
            this.lop = lop;
        }

        public SinhVien() {
            this.hoTen = hoTen;
            this.diaChi = diaChi;
            this.sDT = sDT;
            this.lop = lop;
        }

        public static int getId() {
            return id;
        }

        public static void setId(int id) {
            SinhVien.id = id;
        }

        public int getMaSV() {
            return maSV;
        }

        public void setMaSV(int maSV) {
            this.maSV = maSV;
        }

        public String getHoTen() {
            return hoTen;
        }

        public void setHoTen(String hoTen) {
            this.hoTen = hoTen;
        }

        public String getDiaChi() {
            return diaChi;
        }

        public void setDiaChi(String diaChi) {
            this.diaChi = diaChi;
        }

        public String getsDT() {
            return sDT;
        }

        public void setsDT(String sDT) {
            this.sDT = sDT;
        }

        public String getLop() {
            return lop;
        }

        public void setLop(String lop) {
            this.lop = lop;
        }
    }
