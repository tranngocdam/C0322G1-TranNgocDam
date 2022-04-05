package ss3_mang_phuong_thuc_trong_java.bai_tap;
import java.util.Scanner;
public class SumColArray {
    public static void main(String[] args) {
        double array[][], sum;
        int m, n, col;
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the row: ");
        m=Integer.parseInt(input.nextLine());
        System.out.print("Enter the col: ");
        n=Integer.parseInt(input.nextLine());
        array=new double[m][n];
        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j <array[i].length ; j++) {
                System.out.print("element["+i+"]["+j+"]=");
                array[i][j]=Double.parseDouble(input.nextLine());
            }
        }
        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j <array[i].length ; j++) {
                System.out.print(array[i][j]+"\t");
            }
            System.out.println("");
        }
        System.out.print("Enter the col: ");
        col=Integer.parseInt(input.nextLine());
        sum=0.0;
        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j <array[i].length ; j++) {
                if(array[i][j]==array[i][col]){
                    sum+=array[i][j];
                }
            }
        }
        System.out.print("Tổng cột "+col+ " = "+ sum);
    }
}
