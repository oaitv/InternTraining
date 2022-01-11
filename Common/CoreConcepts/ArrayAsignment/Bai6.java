
import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {

        int n, kt = 1;
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
        sortASC(A);
        show(A);

        System.out.println("Nhập giá trị X: ");
        int X = scanner.nextInt();

        int temp = Math.abs(A[0] - X);
        int phanTuNN = A[0];
        int vitriPhanTuNN = 0;
        for(int i = 1; i<A.length ; i++){
            int temp1 = Math.abs(A[i] - X);
            if(temp1 < temp){
                phanTuNN = A[i];
                temp = temp1;
                vitriPhanTuNN = i;
            }

        }
        System.out.println("Phan tu gan X nhat trong mang la: " + phanTuNN);

        int B[] = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            if(i<vitriPhanTuNN){
                B[i] = A[i];
            }
            else if( i == vitriPhanTuNN){
                B[i] = X;
            }
            else{
                B[i] = A[i-1];
            }
        }

        show(B);

    }
    public static void show(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void sortASC(int [] arr) {
        int temp = arr[0];
        for (int i = 0 ; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}
