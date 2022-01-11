import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num, count;
        int[] arr, res;
        System.out.println("Nhap so phan tu cua mang: ");
        num = sc.nextInt();
        arr = new int[num];
        res = new int[num];
        System.out.println("Nhap so phan tu cua mang: ");
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
            res[i] = -1;
        }

        for (int i = 0; i < num; i++) {
            count = 1;
            for (int j = i + 1; j < num; j++) {
                if (res[j] != 0 && arr[i] == arr[j]) {
                    count++;
                    res[j] = 0;
                }

            }
            if (res[i] != 0) {
                res[i] = count;
            }

        }

        int max = res[0];
        for (int i = 0; i < num; i++) {
            if (res[i] > max) {
                max = res[i];
            }
        }
        System.out.println("So  lan xuat hien nhat la: " + max + "So do la : ");
        for (int i = 0; i < num; i++) {
            if (res[i] == max) {
                System.out.print(arr[i] + ", ");
            }

        }
    }
    }

