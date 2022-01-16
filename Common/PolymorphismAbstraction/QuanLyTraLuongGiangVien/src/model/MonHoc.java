package model;

import java.io.Serializable;

    public class MonHoc implements Serializable {
        public static int id = 100;
        private int maMonHoc;
        private String tenMonHoc;
        private int tongSoTiet;
        private int soTietlyThuyet;
        private double mucKinhPhi;

        public MonHoc(int maMonHoc) {
            this.maMonHoc = maMonHoc;
        }

        public MonHoc() {
            // setMonHoc();
        }


        public MonHoc(String tenMonHoc, int maMonHoc,
                    int tongSoTiet, int soTietlyThuyet, int mucKinhPhi) {
            int setId = (id ++);
            this.maMonHoc = maMonHoc;
            this.tenMonHoc = tenMonHoc;
            this.tenMonHoc = tenMonHoc;
            this.soTietlyThuyet = soTietlyThuyet;
            this.mucKinhPhi = mucKinhPhi;
        }

        public MonHoc(int maMonHoc, String tenMonHoc, int tongSoTiet, int soTietlyThuyet, double mucKinhPhi) {
            this.maMonHoc = maMonHoc;
            this.tenMonHoc = tenMonHoc;
            this.tongSoTiet = tongSoTiet;
            this.soTietlyThuyet = soTietlyThuyet;
            this.mucKinhPhi = mucKinhPhi;

        }

        public int getMonHocID() {
            return maMonHoc;
        }

        public void setSachID() {
            this.maMonHoc = id++;
        }

        public static int getId() {
            return id;
        }

        public static void setId(int id) {
            MonHoc.id = id;
        }

        public int getMamonhoc() {
            return maMonHoc;
        }

        public void setMamonhoc(int maMonHoc) {
            this.maMonHoc = maMonHoc;
        }

        public String getTenmonhoc() {
            return tenMonHoc;
        }

        public void setTenmonhoc(String tenMonHoc) {
            this.tenMonHoc = tenMonHoc;
        }

        public int getTongsotiet() {
            return tongSoTiet;
        }

        public void setTongsotiet(int tongSoTiet) {
            this.tongSoTiet = tongSoTiet;
        }

        public int getSotietlythuyet() {
            return soTietlyThuyet;
        }

        public void setSotietlythuyet(int soTietlyThuyet) {
            this.soTietlyThuyet = soTietlyThuyet;
        }


        public double getMucKinhPhi() {
            return mucKinhPhi;
        }

        @Override
        public String toString() {
            return "MonHoc{" +
                    "maMonHoc=" + maMonHoc +
                    ", tenMonHoc='" + tenMonHoc + '\'' +
                    ", tongSoTiet=" + tongSoTiet +
                    ", soTietlyThuyet=" + soTietlyThuyet +
                    ", mucKinhPhi=" + mucKinhPhi +
                    '}';
        }

        public void setMucKinhPhi(double mucKinhPhi) {
            this.mucKinhPhi = mucKinhPhi;
        }

        public int getMaMonHoc() {
            return 0;
        }
    }