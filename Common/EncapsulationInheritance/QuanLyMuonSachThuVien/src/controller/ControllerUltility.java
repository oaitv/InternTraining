package controller;


import model.Sach;
import model.QuanLyMuonSach;
import model.BanDoc;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ControllerUltility {
    private DataUlitility ulitility;

    public ControllerUltility() {
        this.ulitility = new DataUlitility();
    }

    public void sortByName(QuanLyMuonSach[] args) {
        Arrays.sort(args);
    }

    public void sortByNumofBorrow(QuanLyMuonSach[] args) {
        Arrays.sort(args);
    }


    public QuanLyMuonSach[] updateBRMInfo(QuanLyMuonSach[] brm,
                                                 BanDoc[] banDocs, Sach[] sachs) {
        for (int i = 0; i < brm.length; i++) {
            int maBanDoc = brm[i].getSachs().getSachID();
            int banDocId = brm[i].getBanDoc().getBanDocID();
            int tongSo = countSachBorrowedByBanDoc(brm, banDocId);
            brm[i].setBanDoc(findBanDocByID(banDocs, banDocId));
            brm[i].setSachs(findSachById(sachs, maBanDoc));
            brm = setTotalSachBorrowed(brm, banDocId, tongSo);
        }
        return brm;
    }

    public int countSachBorrowedByBanDoc(QuanLyMuonSach[] brm, int maBanDoc) {
        int count = 0;
        for (int i = 0; i < brm.length; i++) {
            if (brm[i].getBanDoc().getBanDocID() == maBanDoc) {
                count += brm[i].getSoLuongMuon();
            }
        }
        return count;
    }

    public QuanLyMuonSach[] setTotalSachBorrowed(QuanLyMuonSach[] brm, int maBanDoc, int tongSo) {

        for (int i = 0; i < brm.length; i++) {
            if (maBanDoc == brm[i].getBanDoc().getBanDocID()) {
                brm[i].setTotal(tongSo);
            }
        }
        return brm;
    }

    private static Sach findSachById(Sach[] sachs, int id) {
        for (int i = 0; sachs != null && i < sachs.length && sachs[i] != null; i++) {
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
}
