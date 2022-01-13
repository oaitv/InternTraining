package controller;


import model.Sach;
import model.BanDoc;
import model.QuanLyMuonSach;

import java.io.*;
import java.util.Scanner;


public class DataUlitility {
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private PrintWriter printWriter;

    private Scanner scanner;

    public static int countLines(String filehoTen) {
        try {
            InputStream is = new BufferedInputStream(new FileInputStream(filehoTen));
            byte[] c = new byte[1024];
            int count = 0;
            int readChars = 0;
            boolean empty = true;
            while ((readChars = is.read(c)) != -1) {
                empty = false;
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }
            return (count == 0 && !empty) ? 1 : count;
        } catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public void openConnectionToRead(String fileName){
        try {
            File mFile = new File(fileName);
            if(!mFile.exists()){
                mFile.createNewFile();
            }
            scanner = new Scanner(mFile, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeConnectionToRead(){
        scanner.close();
    }

    public void closeConnectionToWrite() {
        printWriter.close();
        try {
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openConnectionToWrite(String fileName) {
        try {
            fileWriter = new FileWriter(fileName, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeSachToFile(Sach sach, String fileName) {
        openConnectionToWrite(fileName);
        printWriter.println(sach.getSachID() + "|" + sach.getTenSach() + "|"
                + sach.getChuyenNganh() + "|" + sach.getTacGia() + "|"
                + sach.getNamXuatBan() + "|" + sach.getSoLuong());
        closeConnectionToWrite();
    }

    public Sach[] readAllSachFromFile(String fileName) {
        openConnectionToRead(fileName);
        Sach[] sachs = new Sach[countLines(fileName)];
        int i = 0;
        while (scanner.hasNextLine()){
            String data = scanner.nextLine();
            sachs[i++] = creaSachFromData(data);
        }
        closeConnectionToRead();
        return sachs;
    }

    private Sach creaSachFromData(String data) {
        Sach sach = new Sach ();
        String[] fields = data.split("\\|");

        sach.setSachID(Integer.parseInt(fields[0]));
        sach.setTenSach(fields[1]);
        sach.setChuyenNganh(fields[2]);
        sach.setTacGia(fields[3]);
        sach.setNamXuatBan(Integer.parseInt(fields[4]));
        sach.setSoLuong(Integer.parseInt(fields[5]));

        return sach;
    }

    public void writeBanDocToFile(BanDoc banDoc, String fileName) {
        openConnectionToWrite(fileName);
        printWriter.println(banDoc.getBanDocID() + "|" + banDoc.getFullName() + "|"
                + banDoc.getDiaChi() + "|" + banDoc.getSDt() + "|" + banDoc.getLoaiBanDoc ());
        closeConnectionToWrite();
    }

    public BanDoc[] readAllBanDocFromFile(String fileName) {
        openConnectionToRead(fileName);
        BanDoc[] banDocs = new BanDoc[countLines(fileName)];
        int i = 0;
        while(scanner.hasNextLine()){
            String data = scanner.nextLine();
            BanDoc banDoc = createBanDocFromData(data);
            banDocs[i++] = banDoc;
        }
        closeConnectionToRead();
        return banDocs;
    }

    private BanDoc createBanDocFromData(String data) {
        String[] datas = data.split("\\|");

        BanDoc banDoc = new BanDoc();
        banDoc.setBanDocID(Integer.parseInt(datas[0]));
        banDoc.setFullName(datas[1]);
        banDoc.setDiaChi(datas[2]);
        banDoc.setSDt(datas[3]);
        banDoc.setLoaiBanDoc(datas[4]);
        return banDoc;
    }

    public void writeBRMToFile(QuanLyMuonSach brm, String fileName) {
        openConnectionToWrite(fileName);
        printWriter.println(brm.getBanDoc().getBanDocID() + "|" + brm.getSachs().getSachID()
                + "|" + brm.getSoLuongMuon() + "|" + brm.getTrangThai());
        closeConnectionToWrite();
    }

    public QuanLyMuonSach[] readBRMFromFile(String fileName) {
        openConnectionToRead(fileName);
        QuanLyMuonSach[] brms = new QuanLyMuonSach[countLines(fileName)];
        int i = 0;
        while (scanner.hasNextLine()){
            String data = scanner.nextLine();
            QuanLyMuonSach x = createBRMFromData(data);
            brms[i++] = x;
        }
        closeConnectionToRead();
        return brms;
    }

    private QuanLyMuonSach createBRMFromData(String data) {
        QuanLyMuonSach x = new QuanLyMuonSach();
        String[] fields = data.split("\\|");

        x.setBanDoc(new BanDoc(Integer.parseInt(fields[0])));
        x.setSachs(new Sach (Integer.parseInt(fields[1])));
        x.setSoLuongMuon(Integer.parseInt(fields[2]));
        x.setTrangThai(fields[3]);

        return x;
    }
}
