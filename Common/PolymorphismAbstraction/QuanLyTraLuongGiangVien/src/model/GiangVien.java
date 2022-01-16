package model;

public class GiangVien {
    private int maGV;
    private String hoTen;
    private String diaChi;
    private String sDT;
    private String trinhDo;

    public GiangVien(int maGV, String hoTen, String diaChi, String sDT, String trinhDo) {
        this.maGV = maGV;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sDT = sDT;
        this.trinhDo = trinhDo;
    }

    public GiangVien() {
    }

    public GiangVien(String field) {
    }

    public int getMaGV() {
        return maGV;
    }

    public void setMaGV(int maGV) {
        this.maGV = maGV;
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

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    private static void showGiangVienInfo(GiangVien[] giangViens) {
        System.out.println ("____________Thông tin Ban Doc trong file____________");
        if (giangViens[0] == null) {
            System.out.println ("Danh sách rỗng!");
        } else {
            for (int i = 0; i < giangViens.length; i++) {
                if (giangViens[i] != null) {
                    System.out.println (giangViens[i].getMaGV () + " | " + giangViens[i].getHoTen () + " | " + giangViens[i].getDiaChi () + "|" + giangViens[i].getsDT () + " | " + giangViens[i].getTrinhDo ());
                }
            }
        }
    }
}

