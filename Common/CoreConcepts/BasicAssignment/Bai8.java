import java.util.ArrayList;
import java.util.List;
public class Bai8 {
    public static int DEC = 10;


    public static void main(String[] args) {
        int count = 0;
        for (int i = 100000; i < 1000000; i++) {
            if (checkThuanNghich(i)) {
                System.out.println(i);

            }
        }

    }



    public static boolean checkThuanNghich(int n) {
        List<Integer> listNumbers = new ArrayList<>();
        do {
            listNumbers.add(n % DEC);
            n = n / DEC;
        } while (n > 0);
        // kiểm tra tính thuận nghịch
        int size = listNumbers.size();
        for (int i = 0; i < (size/2); i++) {
            if (listNumbers.get(i) != listNumbers.get(size - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
