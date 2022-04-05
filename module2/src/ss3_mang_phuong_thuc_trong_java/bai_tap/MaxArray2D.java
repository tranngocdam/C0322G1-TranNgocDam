package ss3_mang_phuong_thuc_trong_java.bai_tap;
import java.util.Scanner;
public class MaxArray2D {
    public static void main(String[] args) {
        double array[][];
        Scanner input = new Scanner(System.in);
        array=new double[][]{{1.4, 9.0, 45.9}, {23.3, 3.9, 60.2}, {120.5, 9.9, 21.1}};
        double b[]=MaxArray(array);
        System.out.println("max:  "+b[0]);
        System.out.println("imax:  "+b[1]);
        System.out.println("jmax:  "+b[2]);
    }
    public static double[] MaxArray(double arr[][]){
        double max=arr[0][0];
        double arr1[]=new double[3];
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                if(arr[i][j]>max){
                   max=arr[i][j];
                   arr1[0]=max;
                   arr1[1]=i;
                   arr1[2]=j;

                }
            }
        }
        return arr1;
    }
}
