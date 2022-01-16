package controller;

import model.GiangVien;
import model.MonHoc;
import model.QuanLyKeKhaiGiangDay;

import java.io.*;
import java.util.Scanner;

public class ControllerUlitility {

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


    private GiangVien createGiangVienFromData(String data) {
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

    {
    }

    public QuanLyKeKhaiGiangDay[] updateBRMInfo(QuanLyKeKhaiGiangDay[] brm,
                                                GiangVien[] giangViens, MonHoc[] monHocs) {
        for (int i = 0; i < brm.length; i++) {
            int maBanDoc = brm[i].getMonHoc ().getMonHocID ();
            String giangVienId = brm[i].getGiangVien ().getHoTen ();
            int tongSo = countMonHocBorrowedByBanDoc (brm, getmaGiangVien ());
            brm[i].setGiangVien (findGiangVienByID (giangViens, getmaGiangVien ()));
            //brm[i].setMonHoc  (monHocs, maBanDoc));
            //brm = setTotalMBorrowed(brm, giangVienId, tongSo);
        }
        return null;


    }
    public int countMonHocBorrowedByBanDoc(QuanLyKeKhaiGiangDay[] brm, int maGiangVien) {
        int count = 0;
        for (int i = 0; i < brm.length; i++) {
            if (brm[i].getGiangVien ().getMaGV () == maGiangVien) {
                count += brm[i].getSoLuongTiet ();
            }
        }
        return count;
    }
    public int getmaGiangVien() {
        return getmaGiangVien ();
    }
    private static GiangVien findGiangVienByID(GiangVien[] giangViens, int maGiangVien) {
        for (int i = 0; i < giangViens.length; i++) {
            if (giangViens[i].getMaGV () == maGiangVien) {
                return giangViens[i];
            }
        }
        return null;
    }
    public static void sortByName(QuanLyKeKhaiGiangDay[] list , int leng)
    {

        if (list == null || list.length == 0)
        {
            System.out.println("Bạn cần nhập danh sách giảng viên kê khai trước khi sắp xếp!");
            return;
        }

        for(int i=0 ; i<leng;i++)
        {
            for (int j=i+1 ; j<leng;j++)
            {
                int maGV = list[i].getMaGV ();
                
//                int compareName=list[i].getSubjects().getSubjectName().compareTo(list[j].getSubjects().getSubjectName());
//
//                if(compareName < 0 )
//                {
//                    TeachingDeclaration temp=list[i];
//                    list[i]=list[j];
//                    list[j]=temp;
                }
            }
        }
    }








