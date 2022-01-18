import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sn = new Scanner (System.in);
        System.out.println ("Moi ban nhap chuoi tu ban phim:");
        String ABC = sn.nextLine ();
        String temp;
        String[] splited = ABC.split ("\\s+");
        System.out.println (String.join(",", splited));
        for (int i = 0; i < splited.length; i++)
        {
            for (int j = i + 1; j < splited.length; j++) {
                if (splited[i].compareTo(splited[j])>0)
                {
                    temp = splited[i];
                    splited[i] = splited[j];
                    splited[j] = temp;
                }
            }
        }
        System.out.print("Các chuỗi sau khi sắp xếp là:");
        for (int i = 0; i <= splited.length - 1; i++)
        {
            System.out.print(splited[i] + ", ");
        }
    }

}