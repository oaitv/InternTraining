
import java.util.*;
public class Bai4 {

    public static void main(String[] args) {
        String s0= new String();
        Scanner in= new Scanner(System.in);
        System.out.println("nhap xau ban dau: ");
        s0= in.nextLine();
        String arr[]= new String[20];
        int max=1; int n=0;
        StringTokenizer s1= new StringTokenizer(s0);
        while(s1.hasMoreTokens()){
            arr[n]= s1.nextToken();
            n++;
        }
        for(int i=0;i<n;i++){
            if(arr[i].length()>max) max=arr[i].length();
        }
        System.out.println("do dai cua tu lon nhat la: " +max);
        System.out.println("vi tri cac tu co do dai lon nhat la: ");
        for(int i=0;i<n;i++) {
            if(arr[i].length()==max)
            {
                System.out.println("  "+i);
            }
        }

    }

}