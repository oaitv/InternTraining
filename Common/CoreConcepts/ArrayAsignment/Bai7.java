import java.util.Scanner;
public class Bai7 {
    public static void main(String[] args) {
        System.out.println("Nhập phần tử mảng: ");
        int n = new Scanner(System.in).nextInt();
        int[] a = new int[n];
        System.out.println("Nhập  x: ");
        int x = new Scanner(System.in).nextInt();
        System.out.println("Nhập mảng a: ");



        xuat(a,n);
        a=nhap(a,n,x);
        xuatMang(a,n);
    }

    private static void xuat(int[] a, int n) {
        for (int i=0; i<n+1; i++){
            System.out.print(a[i]+" ");
        }
    }

    private static int[] nhap(int[] a, int n, int x) {
        int index = n-1;
        int [] b = new int [n + 1];
        boolean check = false;
        for (int i = n; i>=0; i--){
            if (index > -1 && a[index] >x ){
                b[i] = a[index--];
            }else {
                if (!check){
                    b[i] = x;
                    check = true;
                }else {
                    b[i] = a[index--];
                }
            }
        }
        return b;
    }


    private static void xuatMang(int[] a, int n) {
        for (int i=0; i< n; i++){
            System.out.println("Phần tử thứ "+i+" : ");
            a[i] = new Scanner(System.in).nextInt();
        }
    }
}
