package controller;

import model.GiangVien;
import model.MonHoc;
import model.QuanLyKeKhaiGiangDay;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DataUlitility {
    private GiangVien teacher;
    private MonHoc subjects;
    int numberClass;

    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private PrintWriter printWriter;

    private Scanner scanner;


    public void writeBanDocToFile(GiangVien giangVien, String fileName) {
        openConnectionToWrite (fileName);
        printWriter.println (giangVien.getMaGV () + "|" + giangVien.getHoTen () + "|"
                + giangVien.getDiaChi () + "|" + giangVien.getsDT () + "|" + giangVien.getTrinhDo ());
        closeConnectionToWrite ();
    }

    public void writeQuanLyKeKhaiGiangDayToFile(QuanLyKeKhaiGiangDay quanLyKeKhaiGiangDay, String fileName) {
        openConnectionToWrite (fileName);
        printWriter.println (quanLyKeKhaiGiangDay.getMaGV () + "|" + quanLyKeKhaiGiangDay.getTenMonHoc () + "|"
                + quanLyKeKhaiGiangDay.getSoLuongTiet () + "|" + quanLyKeKhaiGiangDay.getTongTienLuong ());
        closeConnectionToWrite ();
    }

    public void openConnectionToWrite(String fileName) {
        try {
            fileWriter = new FileWriter (fileName, true);
            bufferedWriter = new BufferedWriter (fileWriter);
            printWriter = new PrintWriter (bufferedWriter);
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    public void closeConnectionToWrite() {
        printWriter.close ();
        try {
            bufferedWriter.close ();
            fileWriter.close ();
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }

    public GiangVien[] readAllGiangVienFromFile(String fileName) {
        openConnectionToRead (fileName);
        GiangVien[] giangViens = new GiangVien[countLines (fileName)];
        int i = 0;
        while (scanner.hasNextLine ()) {
            String data = scanner.nextLine ();
            GiangVien giangVien = createGiangVienFromData (data);
            giangViens[i++] = giangVien;
        }
        closeConnectionToRead ();
        return giangViens;
    }

    public QuanLyKeKhaiGiangDay[] readAllQuanLyKeKhaiGiangDayFromFile(String fileName) {
        openConnectionToRead (fileName);
        QuanLyKeKhaiGiangDay[] quanLyKeKhaiGiangDays = new QuanLyKeKhaiGiangDay[countLines (fileName)];
        int i = 0;
        while (scanner.hasNextLine ()) {
            String data = scanner.nextLine ();
            QuanLyKeKhaiGiangDay quanLyKeKhaiGiangDay = createQuanLyKeKhaiGiangDayFromData (data);
            quanLyKeKhaiGiangDays[i++] = quanLyKeKhaiGiangDay;
        }
        closeConnectionToRead ();
        return quanLyKeKhaiGiangDays;
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

    public static int countLines(String filehoTen) {
        try {
            InputStream is = new BufferedInputStream (new FileInputStream (filehoTen));
            byte[] c = new byte[1024];
            int count = 0;
            int readChars = 0;
            boolean empty = true;
            while ((readChars = is.read (c)) != -1) {
                empty = false;
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }
            return (count == 0 && !empty) ? 1 : count;
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return 0;
    }


    private GiangVien createBanDocFromData(String data) {
        String[] datas = data.split ("\\|");

        GiangVien giangVien = new GiangVien ();
        giangVien.setMaGV (Integer.parseInt (datas[0]));
        giangVien.setHoTen (datas[1]);
        giangVien.setDiaChi (datas[2]);
        giangVien.setsDT (datas[3]);
        giangVien.setTrinhDo (datas[4]);
        return giangVien;
    }

    public void closeConnectionToRead() {
        scanner.close ();
    }


    private GiangVien createGiangVienFromData(String data) {
        String[] datas = data.split ("\\|");

        GiangVien giangVien = new GiangVien ();
        giangVien.setMaGV (Integer.parseInt (datas[0]));
        giangVien.setHoTen (datas[1]);
        giangVien.setDiaChi (datas[2]);
        giangVien.setTrinhDo (datas[4]);
        return giangVien;
    }


    private QuanLyKeKhaiGiangDay createQuanLyKeKhaiGiangDayFromData(String data) {
        String[] datas = data.split ("\\|");

        QuanLyKeKhaiGiangDay quanLyKeKhaiGiangDay = new QuanLyKeKhaiGiangDay ();
        quanLyKeKhaiGiangDay.setMaGV (Integer.parseInt (datas[0]));
        quanLyKeKhaiGiangDay.setTenMonHoc (datas[1]);
        quanLyKeKhaiGiangDay.setSoLuongTiet (Integer.parseInt (datas[2]));
        quanLyKeKhaiGiangDay.setTongTienLuong (Double.parseDouble (datas[3]));
        return quanLyKeKhaiGiangDay;
    }

    public MonHoc[] readAllMonHocFromFile(String fileName) {
        openConnectionToRead (fileName);
        MonHoc[] monHocs = new MonHoc[countLines (fileName)];
        int i = 0;
        while (scanner.hasNextLine ()) {
            String data = scanner.nextLine ();
            monHocs[i++] = creaMonHocFromData (data);
        }
        closeConnectionToRead ();
        return monHocs;
    }

    private MonHoc creaMonHocFromData(String data) {
        MonHoc monHoc = new MonHoc ();
        String[] fields = data.split ("\\|");

        monHoc.setMamonhoc (Integer.parseInt (fields[0]));
        monHoc.setTenmonhoc (fields[1]);
        monHoc.setTongsotiet (Integer.parseInt (fields[2]));
        monHoc.setSotietlythuyet (Integer.parseInt (fields[3]));
        monHoc.setMucKinhPhi (Double.parseDouble (fields[4]));

        return monHoc;
    }

    public QuanLyKeKhaiGiangDay[] readBRMFromFile(String fileName) {
        openConnectionToRead (fileName);
        QuanLyKeKhaiGiangDay[] brms = new QuanLyKeKhaiGiangDay[countLines (fileName)];
        int i = 0;
        while (scanner.hasNextLine ()) {
            String data = scanner.nextLine ();
            QuanLyKeKhaiGiangDay x = createBRMFromData (data);
            brms[i++] = x;
        }
        closeConnectionToRead ();
        return brms;
    }

    private QuanLyKeKhaiGiangDay createBRMFromData(String data) {
        QuanLyKeKhaiGiangDay x = new QuanLyKeKhaiGiangDay ();
        String[] fields = data.split ("\\|");

        x.setGiangVien (new GiangVien (fields[0]));
        x.setMonHoc (new MonHoc (Integer.parseInt (fields[1])));
        x.setSoLuongTiet (Integer.parseInt (fields[2]));
        x.setTongTienLuong (Integer.parseInt (fields[3]));

        return x;
    }

    public void enterStatistics(GiangVien[] listGiangVien, MonHoc[] listMonhoc, QuanLyKeKhaiGiangDay[] quanLyKeKhaiGiangDays) {

        int maGV;
        MonHoc[] listMonHocThemVao = new MonHoc[100];
        int lenMonHocThemVao = 0;
        int soTietDaCo = 0;
        int maMonHoc;
        int lopHocToiDa;
        boolean exist = false;

        //=true khi môn học tồn tại và chưa được nhập cho giảng viên trc đó
        boolean themMonHocThanhCong = false;

        Scanner sc = new Scanner (System.in);

        while (!exist) {
            System.out.println ("Nhap ma Giang vien(100-999) :");
            maGV = sc.nextInt ();

            for (int i = 0; i < 1000; i++) {
                if (listGiangVien[i] != null && listGiangVien[i].getMaGV () == maGV) {
                    exist = true;
                    this.teacher = listGiangVien[i];
                    break;
                }

            }
        }

        //Lấy số tiết đã có của giảng viên đó
        for (int i = 0; i < 1000; i++) {
            if (quanLyKeKhaiGiangDays[i] == null) {
                break;
            } else {

                if (quanLyKeKhaiGiangDays[i].getGiangVien ().getMaGV () == this.teacher.getMaGV ()) {
                    soTietDaCo += quanLyKeKhaiGiangDays[i].getSoLuongTiet () * quanLyKeKhaiGiangDays[i].getMonHoc ().getTongsotiet ();
                }
            }
        }

        System.out.println ("Số tiết giảng viên đó đã dạy là:" + soTietDaCo);


        //Lấy những môn mà giảng viên đó có thể dạy tiếp:
        //Nếu không có môn nào thì thoát

        for (int i = 0; i < 200; i++) {
            if (listMonhoc[i] == null) {
                break;
            } else {
                if ((200 - soTietDaCo) > listMonhoc[i].getTongsotiet ()) {
                    listMonHocThemVao[lenMonHocThemVao++] = listMonhoc[i];
                }
            }
        }
        System.out.println ("Những môn học mà giảng viên đó có thể dạy tiếp:");

        for (int i = 0; i < lenMonHocThemVao; i++) {
            System.out.println ("" + i + "." + listMonHocThemVao[i].getMamonhoc ());
        }

        if (lenMonHocThemVao == 0) {
            System.out.println ("Không còn môn học nào thỏa mãn!");
            return;
        }

        exist = false;
        while (!exist) {

            System.out.println ("Nhập mã môn học :");
            maMonHoc = sc.nextInt ();
            for (int i = 0; i < 1000; i++) {
                if (listMonHocThemVao[i] == null) {

                    break;
                } else {
                    if (listMonHocThemVao[i].getMamonhoc () == maMonHoc) {
                        exist = true;
                        boolean sucexit = false;//để check tên sách đã đc nhập trc đó,ko cho trùng tên sách
                        for (int k = 0; k < listMonHocThemVao.length; k++) {
                            if (listMonHocThemVao[i] == null) {
                                break;
                            }
                            if (listMonHocThemVao[k].getMamonhoc () == maMonHoc) {
                                sucexit = false;
                                System.out.println ("Môn học đã được mượn trước đó!");
                                break;
                            }
                        }
                        this.subjects = listMonHocThemVao[i];
                        break;
                    }
                }
            }
        }

        lopHocToiDa = (200 - soTietDaCo) / this.subjects.getTongsotiet ();
        lopHocToiDa = lopHocToiDa < 3 ? lopHocToiDa : 3;

        do {
            System.out.println ("Nhập số lớp:(<=" + lopHocToiDa + ")");
            numberClass = sc.nextInt ();
        }
        while (numberClass > lopHocToiDa);

    }


    public void writeMonHocToFile(MonHoc monHoc, String fileName) {
        openConnectionToWrite (fileName);
        printWriter.println (monHoc.getMaMonHoc () + "|" + monHoc.getTenmonhoc () + "|"
                + monHoc.getTongsotiet () + "|" + monHoc.getSotietlythuyet () + "|"
                + monHoc.getMucKinhPhi ());
        closeConnectionToWrite ();
    }


    public static void sortByMaGV(QuanLyKeKhaiGiangDay[] list, int leng) {

        int[] listMaGV = new int[leng];
        if (list == null || list.length == 0) {
            System.out.println ("Bạn cần nhập danh sách giảng viên kê khai trước khi sắp xếp!");
            return;
        }

        for (int i = 0; i < leng; i++) {
            listMaGV[i] = list[i].getMaGV();
        }
        sortASC(listMaGV);
    }

    public static void sortASC(int [] arr) {
        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        System.out.println (Arrays.toString(arr));
    }
    public static void sortByTietGiangDay(QuanLyKeKhaiGiangDay[] list, int leng) {

        if (list == null || list.length == 0) {
            System.out.println ("Bạn cần nhập danh sách giảng viên kê khai trước khi sắp xếp!");
            return;
        }
        int[] listTietGiangDay = new int[leng];

        for (int i = 0; i < leng; i++) {
            listTietGiangDay[i] = list[i].getSoLuongTiet ();
        }
        sortDESC(listTietGiangDay);
    }
    public static void sortDESC(int [] arr) {
        int temp = arr[0];
        for (int i = 0 ; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        System.out.println (Arrays.toString(arr));
    }
}




