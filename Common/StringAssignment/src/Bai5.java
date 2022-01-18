import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sn = new Scanner (System.in);
        System.out.println ("Moi ban nhap ho:");
        String ho = sn.nextLine ();
        System.out.println ("Moi ban nhap dem:");
        String dem = sn.nextLine ();
        System.out.println ("Moi ban nhap ten:");
        String ten = sn.nextLine ();
        System.out.println ("ho va ten cua ban la:" + ten + " " + ho + " " + dem);
    }

}
