package view;

import controller.ControllerUltility;
import controller.DataUlitility;
import model.BangDiem;
import model.MonHoc;
import model.SinhVien;

import java.util.Scanner;

public class View {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean isActivate = false;

    public static void main(String[] args) {
        int choice = 0;

        DataUlitility dataUlitility = new DataUlitility();
        ControllerUltility controllerUltility = new ControllerUltility();

        SinhVien[] sinhViens = null;
        MonHoc[] monHocs = null;
        BangDiem[] bangDiems = null;

        do {
            System.out.println("\n____________XIN MỜI Bạn CHỌN MỘT CHỨC NĂNG____________");
            System.out.println("1. Thêm 1 sinh vien vào file.");
            System.out.println("2. Hiển thị danh sách sinh vien.");
            System.out.println("3. Thêm 1 mon hoc vào file.");
            System.out.println("4. Hiển thị danh sách mon hoc.");
            System.out.println("5. Nhập thông tin bang diem.");
            System.out.println("6. Hien Thi thông tin bang diem.");
            System.out.println("7. Hien Thi thông tin bang diem sap xep theo ma sinh vien theo thu tu tang dan.");
            System.out.println("8. Hien Thi thông tin mon hoc sap xep theo ma mon hoc theo thu tu tang dan.");
            System.out.println("0. Thoát chương trình.");
            System.out.println("Bạn chọn ??? ");

            choice = scanner.nextInt();
            scanner.nextLine();// doc bo dong chua lua chon

            switch (choice) {
                case 0:
                    System.out.println("____________Thoát khỏi chương trình____________");
                    System.out.println("Cảm ơn bạn đã sử dụng dịch vụ của chúng tôi!");
                    break;
                case 1:
//                    if(!isActivate){
//                        updateId(dataUlitility);
//                    }
                    getSinhVienInfo(dataUlitility);
                    break;
                case 2:
                    sinhViens = readSinhVienInfo (dataUlitility, "SINHVIEN.DAT");
                    showSinhVienInfo (sinhViens);
                    break;
                case 3:
                    getMonHocInfo(dataUlitility);
                    break;
                case 4:
                    monHocs = readMonHocInfo(dataUlitility, "MONHOC.DAT");
                    showMonHocInfo(monHocs);
                    break;
                case 5:
                    getBangDiemInfo(dataUlitility);

                case 6:
                    bangDiems = readBangDiemInfo(dataUlitility, "BANGDIEM.DAT");
                    showBangDiemInfo(bangDiems);
                    break;
                case 7:
                    bangDiems = readBangDiemInfo(dataUlitility, "BANGDIEM.DAT");
                    showBangDiemInfoDaSapXep (bangDiems);
                    break;
                case 8:
                    bangDiems = readBangDiemInfo(dataUlitility, "BANGDIEM.DAT");
                    showBangDiemInfoDaSapXepTheoMonHoc (bangDiems);
                    break;

                default:
                    System.out.println("Vui long chon lai chuc nang!");
            }
        } while (choice != 0);
    }
    private static void updateId(DataUlitility dataUlitility) {
        SinhVien[] sinhViens = readSnhVienInfo (dataUlitility, "SINHVIEN.DAT");
        if(sinhViens.length > 0){
            SinhVien.id = sinhViens[sinhViens.length - 1].getMaSV ()+1;
        }

//        MonHoc[] monHocs = readSachInfo(dataUlitility, "SACH.DAT");
//        if(monHocs.length > 0){
//            monHocs.id = sachs[sachs.length-1].getSachID()+1;
//        }

        isActivate = true;
    }
    private static SinhVien[] readSnhVienInfo(DataUlitility dataUlitility, String s) {
        return dataUlitility.readAllSinhVienFromFile(s);
    }
    private static void getSinhVienInfo(DataUlitility dataUlitility) {
        System.out.println("____________Nhập thông tin SV____________");
        String hoTen, diaChi, sDT, lop;
        int maSV;
        System.out.println("Nhập ma sinh vien: ");
        maSV = Integer.parseInt(scanner.nextLine ());

        System.out.println("Nhập họ và tên: ");
        hoTen = scanner.nextLine();

        System.out.println("Nhập địa chỉ: ");
        diaChi = scanner.nextLine();

        System.out.println("Nhập số điện thoại: ");
        sDT = scanner.nextLine();

        System.out.println("Nhập số lop: ");
        lop = scanner.nextLine();;


        SinhVien sinhVien = new SinhVien(maSV,hoTen, diaChi, sDT, lop);
        dataUlitility.writeSinhVienToFile(sinhVien, "SINHVIEN.DAT");
    }
    private static SinhVien[] readSinhVienInfo(DataUlitility dataUlitility, String s) {
        return dataUlitility.readAllBanDocFromFile (s);
    }
    private static void showSinhVienInfo(SinhVien[] sinhViens) {
        System.out.println("____________Thông tin sinh vien trong file____________");
        if (sinhViens[0] == null) {
            System.out.println("Danh sách rỗng!");
        } else {
            for (int i = 0; i < sinhViens.length; i++) {
                if (sinhViens[i] != null) {
                    System.out.println(sinhViens[i].getMaSV ()  +  " | " + sinhViens[i].getHoTen () + " | "+ sinhViens[i].getDiaChi () + "|" + sinhViens[i].getsDT () + " | " + sinhViens[i].getLop ());
                }
            }
        }
    }
    private static void getMonHocInfo(DataUlitility dataUlitility) {
        System.out.println("____________Nhập thông tin Mon Hoc____________");
        String[] loaiMonHoc = {"Dai Cuong", "Co So Nghanh", " Chuyen Nghanh"};

        String tenMonHoc, soDonViHocTrinh, spec;
        int maMonHoc, intLoaiMonHoc;
        System.out.println("Nhập ma mon hoc: ");
        maMonHoc = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên Mon Hoc: ");
        tenMonHoc = scanner.nextLine();
        System.out.println("Nhập so don vi hoc trinh: ");
        soDonViHocTrinh = scanner.nextLine();
        do {
            System.out.println("Chọn loai mon hoc: ");
            System.out.println("1. Dai Cuong.\n2. Co So Nghanh.\n3. Chuyen Nghanh.");
            intLoaiMonHoc = scanner.nextInt ();
        } while (intLoaiMonHoc < 1 || intLoaiMonHoc > 4);

        MonHoc monHoc = new MonHoc (maMonHoc, tenMonHoc,soDonViHocTrinh,
                loaiMonHoc[intLoaiMonHoc - 1]);
        dataUlitility.writeMonHocToFile(monHoc, "MONHOC.DAT");
    }
    private static MonHoc[] readMonHocInfo(DataUlitility dataUlitility, String s) {
        return dataUlitility.readAllMonHocFromFile(s);
    }
    private static void showMonHocInfo(MonHoc[] monHocs) {
        System.out.println("____________Thông tin Mon Hoc trong file____________");
        if (monHocs[0] == null) {
            System.out.println("Danh sách rỗng!");
        } else {
            for (int i = 0; i < monHocs.length; i++) {
                if (monHocs[i] != null) {
                    System.out.println(monHocs[i].getMaMonHoc ()  +  " | " + monHocs[i].getTenMonHoc () + " | "+ monHocs[i].getSoDonViHocTrinh () + "|" + monHocs[i].getLoaiMonHoc ());
                }
            }
                }
            }

    private static void getBangDiemInfo(DataUlitility dataUlitility) {
        System.out.println("____________Nhập thông tin Bang Diem____________");
        String[] loaiMonHoc = {"Dai Cuong", "Co So Nghanh", " Chuyen Nghanh"};

        String tenMonHoc, soDonViHocTrinh, spec;
        int maSV, intLoaiMonHoc, maMonHoc;
        SinhVien[] sinhViens = null;
        MonHoc[] monHocs = null;
        boolean checkMaSV = false;
        boolean checkMaMonHoc = false;
        double diem;

        do{
            System.out.println("Nhập ma sinh vien: ");
            maSV = Integer.parseInt(scanner.nextLine());
            sinhViens = readSinhVienInfo (dataUlitility, "SINHVIEN.DAT");

            for(int i = 0;i<sinhViens.length; i++){
                if(sinhViens[i].getMaSV () == maSV){
                    checkMaSV = true;
                }
            }
        }while (!checkMaSV);
        do{
            System.out.println("Nhập ma mon hoc: ");
            maMonHoc = Integer.parseInt(scanner.nextLine());
            monHocs = readMonHocInfo(dataUlitility, "MONHOC.DAT");

            for(int i = 0;i<monHocs.length; i++){
                if(monHocs[i].getMaMonHoc () == maMonHoc){
                    checkMaMonHoc = true;
                }
            }
        }while (!checkMaMonHoc);


        System.out.println("Nhập diem mon hoc cua ma vua nhap: ");
        diem = Double.parseDouble (scanner.nextLine());

        BangDiem bangDiem = new BangDiem (maSV, maMonHoc,diem);
        dataUlitility.writeBangDiemToFile(bangDiem, "BANGDIEM.DAT");
    }
    private static BangDiem[] readBangDiemInfo(DataUlitility dataUlitility, String s) {
        return dataUlitility.readAllBangDiemFromFile(s);

    }
    private static void showBangDiemInfo(BangDiem[] bangDiems) {
        System.out.println("____________Thông tin Mon Hoc trong file____________");
        if (bangDiems[0] == null) {
            System.out.println("Danh sách rỗng!");
        } else {
            for (int i = 0; i < bangDiems.length; i++) {
                if (bangDiems[i] != null) {
                    System.out.println(bangDiems[i].getMaMonHoc ()  +  " | " + bangDiems[i].getMaSV () + " | "+ bangDiems[i].getDiem ());
                }
            }
        }
    }

    private static void showBangDiemInfoDaSapXep(BangDiem[] bangDiems) {
        System.out.println("____________Thông tin bang diem trong file____________");
        int[] arrMaSV = new int[bangDiems.length];
        if (bangDiems[0] == null) {
            System.out.println("Danh sách rỗng!");
        } else {
            for (int i = 0; i < bangDiems.length; i++) {
                if (bangDiems[i] != null) {
                    arrMaSV[i] = bangDiems[i].getMaSV ();
                }
            }
        }
        sortASC (arrMaSV);
        for (int i = 0; i < arrMaSV.length; i++) {
            System.out.println (arrMaSV[i]);
        }
    }

    public static void sortASC(int [] arr) {
        int temp = arr[0];
        for (int i = 0 ; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    private static void showBangDiemInfoDaSapXepTheoMonHoc(BangDiem[] bangDiems) {
        System.out.println("____________Thông tin mon hoc trong file____________");
        int[] arrMaMonHoc = new int[bangDiems.length];
        if (bangDiems[0] == null) {
            System.out.println("Danh sách rỗng!");
        } else {
            for (int i = 0; i < bangDiems.length; i++) {
                if (bangDiems[i] != null) {
                    arrMaMonHoc[i] = bangDiems[i].getMaMonHoc ();
                }
            }
        }
        sortASC (arrMaMonHoc);
        for (int i = 0; i < arrMaMonHoc.length; i++) {
            System.out.println (arrMaMonHoc[i]);
        }
    }


}



