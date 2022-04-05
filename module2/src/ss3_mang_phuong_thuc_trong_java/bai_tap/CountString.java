package ss3_mang_phuong_thuc_trong_java.bai_tap;
import java.util.Scanner;
public class CountString {
    public static void main(String[] args) {
        String str;
        char str1;
        int count;
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the character: ");
        str1= input.nextLine().charAt(0);
        str="tôi yêu việt nam";
        count=0;
        for (int i = 0; i <str.length() ; i++) {
            if (str.charAt(i)==str1){
                count++;
            }
        }
        System.out.print("Number of occurrences of character"+str1+": "+count);
    }
}
