import java.util.Scanner;
public class Bai1 {
    public static void main(String[] args) {
        int n;
        boolean check =  true;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Nhập số phần tử của mảng: ");
            n = scanner.nextInt();
        } while (n <= 0);

        int A[] = new int[n];

        System.out.println("Nhập giá trị các phần tử của mảng: ");
        for (int i = 0; i < n; i++) {
            System.out.print("A[" + i + "] = ");
            A[i] = scanner.nextInt();
        }

        // kiểm tra mảng đảo ngược hay khong
        for (int i = 0; i < n / 2; i++) {
            if (A[i] != A[n - i - 1]) {
                check = false;
                break;
            }
        }

        if (check) {
            System.out.println("Mảng một chiều vừa nhập không đối xứng");
        } else {
            System.out.println("Mảng một chiều vừa nhập đối xứng");
        }
    }
}
