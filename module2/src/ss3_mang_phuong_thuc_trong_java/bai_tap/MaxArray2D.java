package ss3_mang_phuong_thuc_trong_java.bai_tap;
import java.util.Scanner;
public class MaxArray2D {
    public static void main(String[] args) {
        double array[][]={{1.4, 9.0, 45.9}, {23.3, 3.9, 60.2}, {120.5, 9.9, 21.1}};
        double arr[][];
        Scanner input = new Scanner(System.in);
        System.out.printf("max:  "+MaxArray(array));
    }
    public static double MaxArray(double arr[][]){
        double max=arr[0][0];
        //double imax=0, jmax=0;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                if(arr[i][j]>max){
                    max=arr[i][j];
                    //imax=i;
                    //jmax=j;
                }
            }
        }
        return max;
    }
}
