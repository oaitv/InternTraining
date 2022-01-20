package controller;

import model.BangDiem;
import model.MonHoc;
import model.SinhVien;

import java.io.*;
import java.util.Scanner;

public class DataUlitility {
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private PrintWriter printWriter;

    private Scanner scanner;
    private MonHoc monhoc;

    public SinhVien[] readAllSinhVienFromFile(String fileName) {
        openConnectionToRead (fileName);
        SinhVien[] sinhViens = new SinhVien[countLines (fileName)];
        int i = 0;
        while (scanner.hasNextLine ()) {
            String data = scanner.nextLine ();
            SinhVien sinhVien = createBanDocFromData (data);
            sinhViens[i++] = sinhVien;
        }
        closeConnectionToRead ();
        return sinhViens;
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

    private SinhVien createBanDocFromData(String data) {
        String[] datas = data.split ("\\|");

        SinhVien sinhVien = new SinhVien ();
        sinhVien.setMaSV (Integer.parseInt (datas[0]));
        sinhVien.setHoTen (datas[1]);
        sinhVien.setDiaChi (datas[2]);
        sinhVien.setsDT (datas[3]);
        sinhVien.setLop (datas[4]);
        return sinhVien;
    }

    public void closeConnectionToRead() {
        scanner.close ();
    }

    public void writeSinhVienToFile(SinhVien sinhVien, String fileName) {
        openConnectionToWrite (fileName);
        printWriter.println (sinhVien.getMaSV () + "|" + sinhVien.getHoTen () + "|"
                + sinhVien.getDiaChi () + "|" + sinhVien.getsDT () + "|" + sinhVien.getLop ());
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

    public SinhVien[] readAllBanDocFromFile(String fileName) {
        openConnectionToRead (fileName);
        SinhVien[] sinhViens = new SinhVien[countLines (fileName)];
        int i = 0;
        while (scanner.hasNextLine ()) {
            String data = scanner.nextLine ();
            SinhVien sinhVien = createSinhVienFromData (data);
            sinhViens[i++] = sinhVien;
        }
        closeConnectionToRead ();
        return sinhViens;
    }

    private SinhVien createSinhVienFromData(String data) {
        String[] datas = data.split ("\\|");

        SinhVien sinhVien = new SinhVien ();
        sinhVien.setMaSV (Integer.parseInt (datas[0]));
        sinhVien.setHoTen (datas[1]);
        sinhVien.setDiaChi (datas[2]);
        sinhVien.setsDT (datas[3]);
        sinhVien.setLop (datas[4]);
        return sinhVien;
    }

    public void writeMonHocToFile(MonHoc monHoc, String fileName) {
        openConnectionToWrite (fileName);
        printWriter.println (monHoc.getMaMonHoc () + "|" + monHoc.getTenMonHoc () + "|"
                + monHoc.getSoDonViHocTrinh () + "|" + monHoc.getLoaiMonHoc () + "|");
        closeConnectionToWrite ();
    }

    public MonHoc[] readAllMonHocFromFile(String fileName) {
        openConnectionToRead (fileName);
        MonHoc[] monHocs = new MonHoc[countLines (fileName)];
        int i = 0;
        while (scanner.hasNextLine ()) {
            String data = scanner.nextLine();
            MonHoc monHoc = createMonHocFromData(data);
            monHocs[i++] = monHoc;
        }
        closeConnectionToRead ();
        return monHocs;
    }
    private MonHoc createMonHocFromData(String data) {
        MonHoc monHoc = new MonHoc ();
        String[] fields = data.split ("\\|");

        monHoc.setMaMonHoc (Integer.parseInt (fields[0]));
        monHoc.setTenMonHoc (fields[1]);
        monHoc.setSoDonViHocTrinh (fields[2]);
        monHoc.setLoaiMonHoc (fields[3]);

        return monHoc;
    }

    public void writeBangDiemToFile(BangDiem bangDiem, String fileName) {
        openConnectionToWrite (fileName);
        printWriter.println (bangDiem.getMaSV () + "|" + bangDiem.getMaMonHoc () + "|"
                + bangDiem.getMaBangDiem ());
        closeConnectionToWrite ();
    }
    public BangDiem[] readAllBangDiemFromFile(String fileName) {
        openConnectionToRead (fileName);
        BangDiem[] bangDiems = new BangDiem[countLines (fileName)];
        int i = 0;
        while (scanner.hasNextLine ()) {
            String data = scanner.nextLine();
            BangDiem bangDiem = createBangDiemFromData(data);
            bangDiems[i++] = bangDiem;
        }
        closeConnectionToRead ();
        return bangDiems;
    }
    private BangDiem createBangDiemFromData(String data) {
        String[] datas = data.split ("\\|");

        BangDiem bangDiem = new BangDiem ();
        bangDiem.setMaSV (Integer.parseInt (datas[0]));
        bangDiem.setMaMonHoc (Integer.parseInt (datas[1]));
        bangDiem.setDiem (Double.parseDouble (datas[2]));
        return bangDiem;
    }

}

