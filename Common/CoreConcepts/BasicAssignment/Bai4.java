public class Bai4 {

    public static int tinhTong(int so){
        int soTemp;
        int sum = 0;
        soTemp = so;
        while (soTemp != 0) {
            sum += soTemp % 10;
            soTemp /= 10;
        }
        return sum;
    }
}
