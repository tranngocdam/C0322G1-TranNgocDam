package ss3_mang_phuong_thuc_trong_java.bai_tap;
import java.util.Scanner;
public class MinArray2D {
    public static void main(String[] args) {
        int array[][];
        Scanner input=new Scanner(System.in);
         array= new int[3][2];
        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j <array[i].length ; j++) {
                System.out.printf("element["+i+"]"+"["+j+"]=");
                array[i][j]=Integer.parseInt(input.nextLine());
            }
        }
        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j <array[i].length ; j++) {
                System.out.print(array[i][j]+"\t");
            }
            System.out.println("");
        }
        System.out.println("min array= "+MinArray(array)[0]);
        System.out.println("imin array= "+MinArray(array)[1]);
        System.out.println("jmin array= "+MinArray(array)[2]);
    }
    public static int[] MinArray(int arr[][]){
        int min=arr[0][0];
        int arr1[]=new int[3];
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                if(arr[i][j]<min){
                    min=arr[i][j];
                    arr1[0]=min;
                    arr1[1]=i;
                    arr1[2]=j;
                }
            }
        }
        return arr1;
    }
}

