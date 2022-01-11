public class Bai7 {
    public static void main(String[] args) {

        System.out.println("Liệt  số nguyên tố có 6 chữ số:");
        for (int i = 100001; i < 999999; i+=2) {
            if (isPrimeNumber(i)) {
                System.out.println(i);
            }
        }

    }


    public static boolean isPrimeNumber(int n) {
        //  n < 2
        if (n < 2) {
            return false;
        }
        // check n >= 2
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    }

