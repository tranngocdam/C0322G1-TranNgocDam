package ss3_mang_phuong_thuc_trong_java.bai_tap;
import java.util.Scanner;
public class AddArray2 {
    public static void main(String[] args) {
        int array1[];
        int array2[];
        int array3[];
        Scanner input=new Scanner(System.in);
        array1=new int[5];
        array2=new int[5];
        array3=new int [array1.length+array2.length];
        for (int i = 0; i <array1.length ; i++) {
            array3[i]=array1[i];
        }
        for (int i = 0; i <array2.length ; i++) {
            array3[i+ array1.length]=array2[i];
        }
    }
}
