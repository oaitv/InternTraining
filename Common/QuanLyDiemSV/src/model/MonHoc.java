package model;

public class MonHoc {
    public static int id = 100;
    private int maMonHoc;
    private String tenMonHoc;
    private String soDonViHocTrinh;
    private String loaiMonHoc;

    public MonHoc(int maMonHoc, String tenMonHoc, String soDonViHocTrinh, String loaiMonHoc) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.soDonViHocTrinh = soDonViHocTrinh;
        this.loaiMonHoc = loaiMonHoc;
    }

    public MonHoc() {

    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        MonHoc.id = id;
    }

    public int getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(int maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public String getSoDonViHocTrinh() {
        return soDonViHocTrinh;
    }

    public void setSoDonViHocTrinh(String soDonViHocTrinh) {
        this.soDonViHocTrinh = soDonViHocTrinh;
    }

    public String getLoaiMonHoc() {
        return loaiMonHoc;
    }

    public void setLoaiMonHoc(String loaiMonHoc) {
        this.loaiMonHoc = loaiMonHoc;
    }
}
