
import java.io.*;

public class Bai3 {
    private String st;

    public void ChuanHoaXau(String s) {
        st = s;
    }

    public void ChuanHoaXau() {
    }


    String nhapString() {
        String x;
        DataInputStream ip = new DataInputStream (System.in);
        try {
            x = ip.readLine ();
        } catch (Exception e) {
            System.out.println ("Nhap lai!");
            x = nhapString ();
        }
        return x;
    }

    public void nhapXau() {
        System.out.println ("Nhap xau: ");
        st = nhapString ();
    }

    public void hienThi() {
        System.out.println (st);
    }


    public void chuannHoa() {
        st = st.trim ().toLowerCase ();
        st = st.replaceAll ("\\s+", " ");
        String[] temp = st.split (" ");
        st = "";
        for (int i = 0; i < temp.length; i++) {
            st += String.valueOf (temp[i].charAt (0)).toUpperCase () + temp[i].substring (1);
            if (i < temp.length - 1)
                st += " ";
        }
    }


    public static void main(String[] args) {
        Bai3 a = new Bai3 ();
        a.nhapXau ();
        a.chuannHoa ();
        System.out.println ("Xau sau khi chuan hoa: ");
        a.hienThi ();


    }
}
