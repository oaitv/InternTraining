import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        int n,m;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Nhập số phần tử của mảng A: ");
            n = scanner.nextInt();
        } while (n <= 0);

        int A[] = new int[n];

        System.out.println("Nhập giá trị cho các phần tử của mảng A: ");
        for (int i = 0; i < n; i++) {
            System.out.print("A[" + i + "] = ");
            A[i] = scanner.nextInt();

        }
        do {
            System.out.println("Nhập số phần tử của mảng B: ");
            m = scanner.nextInt();
        } while (m <= 0);

        int B[] = new int[m];

        System.out.println("Nhập giá trị cho các phần tử của mảng B: ");
        for (int i = 0; i < m; i++) {
            System.out.print("B[" + i + "] = ");
            A[i] = scanner.nextInt();
        }

        System.out.println("Nhập giá trị p vao mang a : ");
        int p  = scanner.nextInt();

        int C[] = new int[n + m];
        for(int i = 0; i < n + m; i++){
            if(i<p){
                C[i] = A[i];
            }
            else C[i] = B[i - p];
        }



    }



}
