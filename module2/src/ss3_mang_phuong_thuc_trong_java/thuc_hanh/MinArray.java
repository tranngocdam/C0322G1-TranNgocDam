package ss3_mang_phuong_thuc_trong_java.thuc_hanh;
import java.util.Scanner;
public class MinArray {
    public static void main(String[] args) {
        int array1[], array[];
        int n;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Enter the n: ");
            n=input.nextInt();
            if(n>20||n<0){
                System.out.println("Please, enter the n");
            }
        }while (n<0||n>20);
        array1=new int[n];
        int i;
        for (i=0; i< array1.length; i++){
            System.out.print("Elenment "+(i+1)+"=");
            array1[i]=input.nextInt();
        }
        System.out.println("");
        for (i=0; i< array1.length; i++){
            System.out.print(array1[i]+"\t");
        }
        System.out.println("");
            System.out.printf("Min array1: "+MinArr(array1));
    }
    public static int MinArr(int array[]){
        int min=array[0];
        int i;
        for (i=0; i<array.length; i++){
            if(array[i]<min){
                min=array[i];
            }
        }
        return min;
    }
}
