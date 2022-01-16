package view;

import controller.ControllerUlitility;
import controller.DataUlitility;
import model.GiangVien;
import model.MonHoc;
import model.QuanLyKeKhaiGiangDay;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class View<choice> {
    public static MonHoc[] monhocStorage=new MonHoc[1000];
    public static int lenSubjectStorage=0;

    private static QuanLyKeKhaiGiangDay[] quanLyKeKhaiGiangDaysStorage=new QuanLyKeKhaiGiangDay[10];
    public static int lenTeachingDeclarationStogare=0;

    public static int lenTeacherStorage=0;

    public static GiangVien[] giangVienStorage=new GiangVien[1000];

    private static Scanner scanner = new Scanner (System.in);
    private static boolean isActivate = false;

    public static void main(String[] args) {



        int choice = 0;

        DataUlitility dataUlitility = new DataUlitility ();
        ControllerUlitility controllerUltility = new ControllerUlitility ();

        GiangVien[] giangViens = null;
        MonHoc[] monHocs = new MonHoc[1000];
        QuanLyKeKhaiGiangDay[] quanLyKeKhaiGiangDays = null;

        do {
            System.out.println ("\n____________XIN MỜI Bạn CHỌN MỘT CHỨC NĂNG____________");
            System.out.println ("1. Thêm Mon hoc moi vào file.");
            System.out.println ("2. Hiển thị danh sách Mon hoc.");
            System.out.println ("3. Thêm 1 Giang vien vào file.");
            System.out.println ("4. Hiển thị danh sách giang vien.");
            System.out.println ("5. Nhập thông tin Quan Ly Ke Khai Giang Day.");
            System.out.println("6.Sắp xếp danh sách kê khai giảng dạy theo họ tên giảng viên     ");
            System.out.println("7.Sắp xếp danh sách kê khai giảng dạy theo số tiết giảng dạy mỗi môn (giảm dần)");
            System.out.println ("0. Thoát chương trình.");
            System.out.println ("Bạn chọn ??? ");

            choice = scanner.nextInt ();
            scanner.nextLine ();// doc bo dong chua lua chon

            switch (choice) {
                case 0:
                    System.out.println ("\n___________Thoát chương trình_____________");
                    System.out.println ("\n___________Cảm Ơn Bạn Đã Sử Dụng Dịch Vụ_____________");
                    break;

                case 1:
                    getMonHocInfo (dataUlitility);
                    break;
                case 2:
                    monHocs = readMonHocInfo (dataUlitility, "MONHOC.DAT");
                    showMonHocInfo (monHocs);
                    break;

                case 3:

                    if (!isActivate) {
                    }
                    getGiangVienInfo (dataUlitility);
                    break;
                case 4:
                    giangViens = readGiangVienInfo (dataUlitility, "GIANGVIEN.DAT");
                    showGiangVienInfo (giangViens);
                    break;

                case 5:
                    QuanLyKeKhaiGiangDay keKhai = new QuanLyKeKhaiGiangDay ();

                    if (!isActivate) {
                    }
                    getQuanLyKeKhaiGiangDayInfo(dataUlitility);
                    break;

                case 6:

                    quanLyKeKhaiGiangDays = readQuanLyKeKhaiGiangDayInfo (dataUlitility, "QLKHGG.DAT");
                    int a = 6;
                    dataUlitility.sortByMaGV (quanLyKeKhaiGiangDays,quanLyKeKhaiGiangDays.length);
                    //showDeclaration();
                case 7:
                    quanLyKeKhaiGiangDays = readQuanLyKeKhaiGiangDayInfo (dataUlitility, "QLKHGG.DAT");
                    int b = 6;
                    dataUlitility.sortByTietGiangDay (quanLyKeKhaiGiangDays,quanLyKeKhaiGiangDays.length);
                    //showDeclaration();

                    break;
                default:
                    System.out.println ("Vui long chon lai chuc nang!");
            }

        }
        while (choice != 0);
    }

    private static void getGiangVienInfo(DataUlitility dataUlitility) {
        System.out.println ("____________Nhập thông tin Giang Vien____________");
        String[] loaiTrinhDo = {"GS-TS", "PGS-TS", "Giang Vien Chinh", "Thac Si"};
        String hoTen, diaChi, sDT, trinhDo;
        int intLoaiTrinhDo, maGV;

        System.out.println ("Nhập ma GV: ");
        maGV = Integer.parseInt (scanner.nextLine ());
        System.out.println ("Nhập ho ten GV: ");
        hoTen = scanner.nextLine ();
        System.out.println ("Nhập địa chỉ: ");
        diaChi = scanner.nextLine ();
        System.out.println ("Nhập số điện thoại: ");
        sDT = scanner.nextLine ();

        do {
            System.out.println ("Chọn trinh do: ");
            System.out.println ("1. GS-TS.\n2. PGS-TS.\n3. Giang Vien Chinh. \n4. Thac Si.");
            intLoaiTrinhDo = scanner.nextInt ();
        } while (intLoaiTrinhDo < 1 || intLoaiTrinhDo > 4);


        GiangVien giangVien = new GiangVien (maGV, hoTen, diaChi, sDT, loaiTrinhDo[intLoaiTrinhDo - 1]);
        dataUlitility.writeBanDocToFile (giangVien, "GIANGVIEN.DAT");
    }

    private static void getQuanLyKeKhaiGiangDayInfo(DataUlitility dataUlitility) {
        System.out.println ("____________Nhập thông tin Quan Ly Ke Khai giang day____________");
        String tenMonHoc;
        int  maGV, soLuongTiet;
        double tongTienLuong;

        System.out.println ("Nhập ma GV: ");
        maGV = Integer.parseInt (scanner.nextLine ());
        System.out.println ("Nhập ten mon hoc: ");
        tenMonHoc = scanner.nextLine ();
        System.out.println ("Nhập so luong tiet: ");
        soLuongTiet = Integer.parseInt (scanner.nextLine ());
        System.out.println ("Nhập tong tien luong: ");
        tongTienLuong = Double.parseDouble (scanner.nextLine ());

        QuanLyKeKhaiGiangDay quanLyKeKhaiGiangDay = new QuanLyKeKhaiGiangDay(maGV, tenMonHoc, soLuongTiet, tongTienLuong);
        dataUlitility.writeQuanLyKeKhaiGiangDayToFile (quanLyKeKhaiGiangDay, "QLKHGG.DAT");
    }


    public void openConnectionToRead(String fileName) {
        try {
            File mFile = new File (fileName);
            if (!mFile.exists ()) {
                mFile.createNewFile ();
            }
            scanner = new Scanner (mFile, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    private static GiangVien[] readGiangVienInfo(DataUlitility dataUlitility, String s) {
        return dataUlitility.readAllGiangVienFromFile(s);
    }

    private static QuanLyKeKhaiGiangDay[] readQuanLyKeKhaiGiangDayInfo(DataUlitility dataUlitility, String s) {
        return dataUlitility.readAllQuanLyKeKhaiGiangDayFromFile(s);
    }




    private static void showGiangVienInfo(GiangVien[] giangViens) {
        System.out.println ("____________Thông tin Giang Vien trong file____________");
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

    private static void getMonHocInfo(DataUlitility dataUlitility) {
        System.out.println ("____________Nhập thông tin Môn Học____________");
        String tenMonHoc, spec;
        int maMonHoc, tongSoTiet, soTietLyThuyet;
        double mucKinhPhi;
        System.out.println ("Nhập Mã Môn Học");
        maMonHoc = Integer.parseInt (scanner.nextLine());

        System.out.println ("Nhập tên Môn Học: ");
        tenMonHoc = scanner.nextLine ();

        System.out.println ("Nhập Số Tiết : ");
        tongSoTiet = Integer.parseInt (scanner.nextLine());
        System.out.println ("Chọn Tiết Lý Thuyết: ");
        soTietLyThuyet = Integer.parseInt(scanner.nextLine ());
        System.out.println ();
        System.out.println ("Nhập Mức Kinh Phí: ");
        mucKinhPhi = Double.parseDouble(scanner.nextLine ());

        MonHoc monHoc = new MonHoc (maMonHoc, tenMonHoc,
                tongSoTiet, soTietLyThuyet, mucKinhPhi);
        dataUlitility.writeMonHocToFile(monHoc, "MONHOC.DAT");
        //int age = Integer.parseInt(scanner.nextLine());
        // tranh troi lenh nhu khi dung age = scan.nextInt()
    }


    private static MonHoc[] readMonHocInfo(DataUlitility dataUlitility, String s) {
        return dataUlitility.readAllMonHocFromFile (s);
    }

    private static void showMonHocInfo(MonHoc[] monHocs) {
        System.out.println ("____________Thông tin Môn Học trong file____________");
        if (monHocs[0] == null) {
            System.out.println ("Danh sách rỗng!");
        } else {
            for (int i = 0; i < monHocs.length; i++) {
                if (monHocs[i] != null) {
                    System.out.println (monHocs[i]);
                }
            }
        }
    }

    private static QuanLyKeKhaiGiangDay[] update(ControllerUlitility controllerUltility,
                                                 QuanLyKeKhaiGiangDay[] quanLyMuonSachs,
                                                 DataUlitility dataUlitility) {
        GiangVien[] giangViens = readGiangVienInfo (dataUlitility, "GIANGVIEN.DAT");
        MonHoc[] monHocs = readMonHocInfo (dataUlitility, "MONHOC.DAT");
        return controllerUltility.updateBRMInfo (quanLyMuonSachs, giangViens, monHocs);
    }

    private static GiangVien findGiangVienByID(GiangVien[] giangViens, int maGV) {
        for (int i = 0; i < giangViens.length; i++)
            if (giangViens[i].getMaGV () == maGV) {
                return giangViens[i];
            }
        return null;
    }


    private static boolean isBorrowable(QuanLyKeKhaiGiangDay[] quanLyKeKhaiGiangDays, int maGV) {
        int count = 0;
        int tongSoTiet = 0;
        for (int i = 0; i < quanLyKeKhaiGiangDays.length; i++) {
            if (quanLyKeKhaiGiangDays[i].getGiangVien ().getMaGV () ==
                    maGV) {
                count++;
                tongSoTiet = quanLyKeKhaiGiangDays[i].getSoLuongTiet ();
            }
        }
        if (count <= 1 && tongSoTiet <= 200)
            return true;
        else
            return false;
    }
    private static void showBorrowedInfo(QuanLyKeKhaiGiangDay[] b, int maGV) {
        System.out.println("Mã GV\tSố lượng Tiết Dạy Trong 1 lỚP");
        for (int i = 0; i < b.length; ) {
        }
        System.out.println("\n Có thể dạy nhiều môn nhưng mỗi lớp chỉ được dạy không quas 3 môn!");
    }


    private static MonHoc findMonHocById(MonHoc[] monHocs, int id) {
        for (int i = 0; monHocs != null && i <  monHocs.length && monHocs[i] != null; i++) {
            if (monHocs[i].getMaMonHoc() == id) {
                return monHocs[i];
            }
        }
        return null;
    }


}












