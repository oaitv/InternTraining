import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Nhập số phần tử của mảng: ");
            n = scanner.nextInt();
        } while (n <= 0);

        int A[] = new int[n];

        System.out.println("Nhập giá trị cho các phần tử của mảng: ");
        for (int i = 0; i < n; i++) {
            System.out.print("A[" + i + "] = ");
            A[i] = scanner.nextInt();
        }

        System.out.println("Nhập giá trị X: ");
        int X = scanner.nextInt();

        int temp = Math.abs(A[0] - X);
        int phanTuNN = A[0];
        for(int i = 1; i<A.length ; i++){
            int temp1 = Math.abs(A[i] - X);
            if(temp1 < temp){
                phanTuNN = A[i];
                temp = temp1;
            }

        }
        System.out.println("Phan tu gan X nhat trong mang la: " + phanTuNN);
    }
}
