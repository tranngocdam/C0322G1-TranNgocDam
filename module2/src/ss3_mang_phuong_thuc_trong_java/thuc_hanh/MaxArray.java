package ss3_mang_phuong_thuc_trong_java.thuc_hanh;
import java.util.Scanner;
public class MaxArray {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int array[];
        int n;
        do {
            System.out.print("Enter the n: ");
            n=input.nextInt();
            if(n>20){
                System.out.print("vui lòng nhập lại");
                System.out.println("");
            }
        }while (n<0||n>20);
        array=new int[n];
        int i;
        for (i=0; i<array.length; i++){
            System.out.print("element"+(i+1)+"=");
            array[i]=input.nextInt();
        }
        for (i=0; i<array.length; i++){
            System.out.print(array[i]+"\t");
        }
        System.out.println("");
        int max=array[0];
        for (i=0; i<array.length; i++){
            if (array[i]>max){
                max=array[i];
            }
        }
        System.out.print("Max is array= "+ max);
    }
}
