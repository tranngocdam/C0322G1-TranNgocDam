package ss3_mang_phuong_thuc_trong_java.bai_tap;
import java.util.Scanner;
public class AddElement {
    public static void main(String[] args) {
            int value, index;
            Scanner input = new Scanner(System.in);
             int array[]=new int[10];
            System.out.print("Enter the value: ");
            value = Integer.parseInt(input.nextLine());
            do {
                System.out.print("Enter the index: ");
                index = Integer.parseInt(input.nextLine());
                if (index <= -1 || index > array.length - 1) {
                    System.out.print("Cannot insert an element into array" + "\n");
                }
            } while (index <= -1 || index > array.length - 1);
            for (int i = array.length - 1; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = value;
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + "\t");
            }
    }
}
