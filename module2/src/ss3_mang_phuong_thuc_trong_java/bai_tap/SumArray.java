package ss3_mang_phuong_thuc_trong_java.bai_tap;
import java.util.Scanner;
public class SumArray {
    public static void main(String[] args) {
        double arr[][], sum;
        int m;
        Scanner input=new Scanner(System.in);
        System.out.print("Enter m: ");
        m=Integer.parseInt(input.nextLine());
        arr=new double[m][m];
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j <arr[i].length ; j++) {
                System.out.print("element["+i+"]["+j+"]=");
                arr[i][j]=Double.parseDouble(input.nextLine());
            }
        }
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println("");
        }
        sum=0.0;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                if(i==j){
                    sum+=arr[i][j];
                }
            }
        }
        System.out.print("Tổng đường chéo = "+ sum);
    }
}
