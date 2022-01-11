import java.util.ArrayList;
import java.util.List;

public class bai8b {
    public static int DEC = 10;


    public static void main(String[] args) {


        for (int i = 100000; i < 1000000; i++) {
            int tong = 0;
            if (isThuanNghich(i)) {

                System.out.println(i);
            }



                while (i != 0) {
                    tong += i % 10;
                    i /= 10;
                }
                if(tong % 10==0){
                    System.out.println(i);
                }

            }


        }
    public static boolean isThuanNghich(int n) {
        List<Integer> listNumbers = new ArrayList<>();

        do {
            listNumbers.add(n % DEC);
            n = n / DEC;
        } while (n > 0);

        int size = listNumbers.size();
        for (int i = 0; i < (size/2); i++) {
            if (listNumbers.get(i) != listNumbers.get(size - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
