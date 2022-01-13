package view;


import controller.ControllerUltility;
import controller.DataUlitility;
import model.Sach;
import model.QuanLyMuonSach;
import model.BanDoc;

import java.util.Scanner;



public class View {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean isActivate = false;

    public static void main(String[] args) {
        int choice = 0;

        DataUlitility dataUlitility = new DataUlitility();
        ControllerUltility controllerUltility = new ControllerUltility();

        BanDoc[] banDocs = null;
        Sach[] sachs = null;
        QuanLyMuonSach[] quanLyMuonSachs = null;

        do {
            System.out.println("\n____________XIN MỜI Bạn CHỌN MỘT CHỨC NĂNG____________");
            System.out.println("1. Thêm 1 Ban Doc vào file.");
            System.out.println("2. Hiển thị danh sách Ban Doc.");
            System.out.println("3. Thêm 1 Sach vào file.");
            System.out.println("4. Hiển thị danh sách các Sach.");
            System.out.println("5. Nhập thông tin Quản lý mượn sách.");
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
                    if(!isActivate){
                        updateId(dataUlitility);
                    }
                    getBanDocInfo(dataUlitility);
                    break;

                case 2:
                    banDocs = readBanDocInfo(dataUlitility, "BANDOC.DAT");
                    showBanDocInfo(banDocs);
                    break;

                case 3:
                    getSachInfo(dataUlitility);
                    break;

                case 4:
                    sachs = readSachInfo(dataUlitility, "SACH.DAT");
                    showSachInfo(sachs);
                    break;

                case 5:
                    int banDocId;
                    int sachId;
                    BanDoc banDoc = null;
                    Sach sach = null;
                    if (sachs == null) {
                        sachs = readSachInfo(dataUlitility, "SACH.DAT");
                    }
                    if (banDocs == null) {
                        banDocs = readBanDocInfo(dataUlitility, "BANDOC.DAT");
                    }
                    quanLyMuonSachs = dataUlitility.readBRMFromFile("BRM.DAT");
                    quanLyMuonSachs = update(controllerUltility, quanLyMuonSachs, dataUlitility);
                    boolean done = false;
                    do {
                        showBanDocInfo(banDocs);
                        System.out.println("Nhập mã bạn đọc cần lập thông tin mượn sách: ");
                        banDocId = scanner.nextInt();
                        banDoc = findBanDocByID(banDocs, banDocId);
                        if (banDoc != null) {
                            done = true;
                        }

                        if (done) {
                            break;
                        }
                    } while (true);

                    done = isBorrowable(quanLyMuonSachs, banDocId);// neu ko the muon them thi thong bao, end
                    if (done) {
                        System.out.println("Danh sách đầu sách đã mượn: ");
                        showBorrowedInfo(quanLyMuonSachs, banDocId);
                        // nhập đầu sách:
                        showSachInfo(sachs);
                        do {
                            System.out.println("Nhập mã đầu sách: ");
                            sachId = scanner.nextInt();
                            sach = findSachById(sachs, sachId);
                            if (sach != null) {
                                done = true;
                            }
                            if (done) {
                                done = isNotFull(sachId, banDocId, quanLyMuonSachs);
                            }
                        } while (!done);
                        // nhap so luong va tinh trang:
                        int soLuongMuonedSach = 0;
                        int borrowed = countBorrowed(sachId, banDocId, quanLyMuonSachs);
                        do {
                            System.out.println("Bạn đã mượn " + borrowed + " cuốn.");
                            System.out.println("Nhập số lượng sách cần mượn, tối đa " + (3 - borrowed) + " cuốn: ");
                            soLuongMuonedSach = scanner.nextInt();
                            soLuongMuonedSach += borrowed;
                            if (soLuongMuonedSach > 0 && soLuongMuonedSach <= 3) {
                                break;
                            }
                        } while (true);
                        scanner.nextLine(); // đọc bỏ dòng hiện thời đi

                        System.out.println("Nhập tình trạng sách");
                        String trangThai = scanner.nextLine();
                        QuanLyMuonSach b = new QuanLyMuonSach(banDoc, sach,
                                soLuongMuonedSach, trangThai);
                        dataUlitility.writeBRMToFile(b, "BRM.DAT");
                    } else {
                        System.out.println("Bạn đã mượn đủ tối đa số lượng cho phép!");
                    }
                    quanLyMuonSachs = readBRMInfo(dataUlitility);
                    quanLyMuonSachs = update(controllerUltility, quanLyMuonSachs, dataUlitility);
                    showBRMInfo(quanLyMuonSachs);

                    break;

                default:
                    System.out.println("Vui long chon lai chuc nang!");
            }
        } while (choice != 0);
    }

    private static void updateId(DataUlitility dataUlitility) {
        BanDoc[] banDocs = readBanDocInfo(dataUlitility, "BANDOC.DAT");
        if(banDocs.length > 0){
            BanDoc.id = banDocs[banDocs.length - 1].getBanDocID()+1;
        }

        Sach[] sachs = readSachInfo(dataUlitility, "SACH.DAT");
        if(sachs.length > 0){
            Sach.id = sachs[sachs.length-1].getSachID()+1;
        }

        isActivate = true;
    }

    private static QuanLyMuonSach[] update(ControllerUltility controllerUltility,
                                                  QuanLyMuonSach[] quanLyMuonSachs,
                                                  DataUlitility dataUlitility) {
        BanDoc[] banDocs = readBanDocInfo(dataUlitility, "BANDOC.DAT");
        Sach[] sachs = readSachInfo(dataUlitility, "SACH.DAT");
        return controllerUltility.updateBRMInfo(quanLyMuonSachs, banDocs, sachs);
    }

    private static QuanLyMuonSach[] readBRMInfo(DataUlitility dataUlitility) {
        return dataUlitility.readBRMFromFile("BRM.DAT");
    }

    private static QuanLyMuonSach[] sortBySoLuongMuoned(QuanLyMuonSach[] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (m[i].getTotal() > m[j].getTotal()) {
                    QuanLyMuonSach x = m[i];
                    m[i] = m[j];
                    m[j] = x;
                }
            }
        }
        return m;
    }

    private static void showBRMInfo(QuanLyMuonSach[] m) {
        System.out.println("____________Thông tin quản lý mượn sách____________");
        System.out.printf("%-10s%-20s%-15s%-20s%-15s%-10s%-15s\n", "BanDocID",
                "BanDoc Name", "SachID", "Sach Name", "SoLuong", "TrangThai", "Total");
        for (int i = 0; i < m.length; i++) {
            if (m[i] != null) {
                System.out.printf("%-10d%-20s%-15d%-20s%-15d%-10s%-15d\n", m[i].getBanDoc().getBanDocID(),
                        m[i].getBanDoc().getFullName(),
                        m[i].getSachs().getSachID(), m[i].getSachs().getTenSach(),
                        m[i].getSoLuongMuon(), m[i].getTrangThai(), m[i].getTotal());
            }
        }

    }

    private static void showBRMPersonalInfo(QuanLyMuonSach[] m, int persionId) {
        System.out.println("____________Thông tin mượn sách của bạn đọc mã " + persionId + "____________");
        System.out.printf("%10s%10s%10s%-10s\n", "BanDocID", "SachID", "SoLuong", "TrangThai");
        for (int i = 0; i < m.length; i++) {
            if (m[i].getBanDoc().getBanDocID() == persionId) {
                System.out.printf("%10d%10d%10d%-10s\n", m[i].getBanDoc().getBanDocID(),
                        m[i].getSachs().getSachID(), m[i].getSoLuongMuon(), m[i].getTrangThai());
            }
        }

    }



    private static boolean check(String hoTen1, String hoTen2) {
        String[] items1 = hoTen1.split(" ");
        String[] items2 = hoTen2.split(" ");
        if (items1[items1.length - 1].compareTo(items2[items2.length - 1]) < 0) {
            return true;
        }
        return false;
    }

    private static int countBorrowed(int sachId, int banDocId, QuanLyMuonSach[] m) {
        for (int i = 0; m != null && i < m.length && m[i] != null; i++) {
            if (m[i].getBanDoc().getBanDocID() == banDocId &&
                    m[i].getSachs().getSachID() == sachId) {
                return m[i].getSoLuongMuon();
            }
        }
        return 0;
    }

    private static boolean isNotFull(int sachId, int banDocId, QuanLyMuonSach[] m) {
        for (int i = 0; i < m.length; i++) {
            if (m[i].getBanDoc().getBanDocID() == banDocId &&
                    m[i].getSachs().getSachID() == sachId
                    && m[i].getSoLuongMuon() == 3) {
                return false;
            }
        }
        return true;
    }

    private static void showBorrowedInfo(QuanLyMuonSach[] b, int banDocId) {
        System.out.println("Mã sách\tSố lượng đã mượn");
        for (int i = 0; i < b.length; i++) {
            if (b[i].getBanDoc().getBanDocID() == banDocId) {
                System.out.println(b[i].getSachs().getSachID() + "\t" + b[i].getSoLuongMuon());
            }
        }
        System.out.println("\nMỗi bạn đọc chỉ được mượn tối đa 5 loại sách với mỗi loại tối đa 3 cuốn!");
    }

    private static boolean isBorrowable(QuanLyMuonSach[] quanLyMuonSachs, int banDocId) {
        int count = 0;
        int tongSo = 0;
        for (int i = 0; i < quanLyMuonSachs.length; i++) {
            if (quanLyMuonSachs[i].getBanDoc().getBanDocID() ==
                    banDocId) {
                count++;
                tongSo += quanLyMuonSachs[i].getSoLuongMuon();
            }
        }
        if (count <= 5 && tongSo < 15)
            return true;
        else
            return false;
    }

    private static Sach findSachById(Sach[] sachs, int id) {
        for (int i = 0; i < sachs.length; i++) {
            if (sachs[i].getSachID() == id) {
                return sachs[i];
            }
        }
        return null;
    }

    private static BanDoc findBanDocByID(BanDoc[] banDocs, int banDocId) {
        for (int i = 0; i < banDocs.length; i++) {
            if (banDocs[i].getBanDocID() == banDocId) {
                return banDocs[i];
            }
        }
        return null;
    }

    private static void showSachInfo(Sach[] sachs) {
        System.out.println("____________Thông tin Sach trong file____________");
        if (sachs[0] == null) {
            System.out.println("Danh sách rỗng!");
        } else {
            for (int i = 0; i < sachs.length; i++) {
                if (sachs[i] != null) {
                    System.out.println(sachs[i]);
                }
            }
        }

    }

    private static void getSachInfo(DataUlitility dataUlitility) {
        System.out.println("____________Nhập thông tin Sach____________");
        String[] chuyenNganhs = {"KHTN", "Van Hoc-Nghe Thuat", "Dien Tu Vien Thong", "IT"};

        String tenSach, tacGia, spec;
        int soLuong, year, chuyenNganh;

        System.out.println("Nhập tên sách: ");
        tenSach = scanner.nextLine();
        System.out.println("Nhập tác giả: ");
        tacGia = scanner.nextLine();
        do {
            System.out.println("Chọn chuyên ngành: ");
            System.out.println("1. KHTN.\n2. Van Hoc-Nghe Thuat.\n3. Dien Tu Vien Thong.\n4. IT.");
            chuyenNganh = scanner.nextInt();
        } while (chuyenNganh < 1 || chuyenNganh > 4);

        System.out.println("Nhập số lượng: ");
        soLuong = scanner.nextInt();
        System.out.println("Nhập năm xuất bản: ");
        year = scanner.nextInt();

        Sach sach = new Sach (tenSach, tacGia,
                chuyenNganhs[chuyenNganh - 1], year, soLuong);
        dataUlitility.writeSachToFile(sach, "SACH.DAT");
    }

    private static void showBanDocInfo(BanDoc[] banDocs) {
        System.out.println("____________Thông tin Ban Doc trong file____________");
        if (banDocs[0] == null) {
            System.out.println("Danh sách rỗng!");
        } else {
            for (int i = 0; i < banDocs.length; i++) {
                if (banDocs[i] != null) {
                    System.out.println(banDocs[i].getBanDocID ()  +  " | " + banDocs[i].getFullName () + " | "+ banDocs[i].getDiaChi () + "|" + banDocs[i].getSDt () + " | " + banDocs[i].getLoaiBanDoc ());
                }
            }
        }
    }

    private static void getBanDocInfo(DataUlitility dataUlitility) {
        System.out.println("____________Nhập thông tin BanDoc____________");
        String[] loaiBanDocs = {"Sinh Vien", "Hoc Vien - Cao Hoc", "Giao Vien"};
        String hoTen, diaChi, sDt;
        int loaiBanDoc;

        System.out.println("Nhập họ và tên: ");
        hoTen = scanner.nextLine();

        System.out.println("Nhập địa chỉ: ");
        diaChi = scanner.nextLine();

        System.out.println("Nhập số điện thoại: ");
        sDt = scanner.nextLine();

        do {
            System.out.println("Chọn loai ban doc: ");
            System.out.println("1. Sinh Vien.\n2. Hoc Vien - Cao Hoc.\n3. Giao Vien.");
            loaiBanDoc = scanner.nextInt();
        } while (loaiBanDoc < 1 || loaiBanDoc > 3);
        

        BanDoc banDoc = new BanDoc(hoTen, diaChi, sDt, loaiBanDocs[loaiBanDoc - 1]);
        dataUlitility.writeBanDocToFile(banDoc, "BANDOC.DAT");
    }

    private static BanDoc[] readBanDocInfo(DataUlitility dataUlitility, String s) {
        return dataUlitility.readAllBanDocFromFile(s);
    }

    private static Sach[] readSachInfo(DataUlitility dataUlitility, String s) {
        return dataUlitility.readAllSachFromFile(s);
    }
}
