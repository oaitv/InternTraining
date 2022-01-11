public class Bai2 {

    public static int UocSoNV(int n) {
        int bienDem = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                bienDem++;
                System.out.println(" ước số của " + n + "là" + i);
            }
        }
        return bienDem;
    }

}
