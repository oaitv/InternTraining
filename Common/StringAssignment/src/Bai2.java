import java.util.Locale;
import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sn = new Scanner (System.in);
        System.out.println ("Moi ban nhap 1 chuoi ky tu tu ban phim:");
        String input = sn.nextLine ();
        int lengInput = input.length ();

        char[] charInput = new char[lengInput];


        for (int i = 0; i < lengInput; i++) {
            if (Character.isUpperCase (input.charAt (0))) {
                if (i % 2 == 0) {
                    if (!Character.isUpperCase (input.charAt (i))) {
                        char temp = input.charAt (i);
                        charInput[i] = Character.toString (temp).toUpperCase ().charAt (0);
                    } else {
                        char temp = input.charAt (i);
                        charInput[i] = temp;
                    }

                } else {
                    if (Character.isUpperCase (input.charAt (i))) {
                        char temp = input.charAt (i);
                        charInput[i] = Character.toString (temp).toLowerCase ().charAt (0);
                    } else {
                        char temp = input.charAt (i);
                        charInput[i] = temp;
                    }
                }
            } else {
                if (i % 2 != 0) {
                    if (!Character.isLowerCase (input.charAt (i))) {
                        char temp = input.charAt (i);
                        charInput[i] = Character.toString (temp).toLowerCase ().charAt (0);
                    } else {
                        char temp = input.charAt (i);
                        charInput[i] = temp;
                    }

                } else {
                    if (Character.isLowerCase (input.charAt (i))) {
                        char temp = input.charAt (i);
                        charInput[i] = Character.toString (temp).toUpperCase ().charAt (0);
                    } else {
                        char temp = input.charAt (i);
                        charInput[i] = temp;
                    }
                }
            }


        }
        System.out.println (String.valueOf (charInput));
    }
}
