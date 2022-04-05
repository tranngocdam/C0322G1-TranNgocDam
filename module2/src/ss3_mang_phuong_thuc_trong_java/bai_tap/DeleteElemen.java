package ss3_mang_phuong_thuc_trong_java.bai_tap;
import java.util.Scanner;
public class DeleteElemen {
    public static void main(String[] args) {
        int element, i;
        int array[];
        Scanner input=new Scanner(System.in);
        array=new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.print("Enter the a element: ");
        element=Integer.parseInt(input.nextLine());
        for (i=0; i<array.length;i++){
            if(array[i]==element){
                for (int j = i; j < array.length-1 ; j++) {
                    array[j]=array[j+1];
                }
                array[array.length-1]=0;
            }
        }
        for( i=0; i< array.length; i++){
            System.out.print(array[i]+"\t");
        }
    }
}
