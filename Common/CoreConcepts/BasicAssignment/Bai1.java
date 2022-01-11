public class Bai1 {
    //bai 1a

    public static int TongSoChan(float n) {
        int tongSoChan = 0;
        for (int i = 2; i <= n; i += 2) {
            tongSoChan += i;
        }

        return tongSoChan;
    }

    public static int TongSoLe(float n) {
        int tongSoLe = 0;
        for (int i = 1; i <= n; i += 2) {
            tongSoLe += i;
        }

        return tongSoLe;
    }
   //bai 1b

    public static double tongSoTuNhien(int n) {
        double tongSoTuNhien = 0;
        for (int i = 1; i <= n; i++) {
            tongSoTuNhien += 1.0 / i;
        }
        return tongSoTuNhien;
    }
}
