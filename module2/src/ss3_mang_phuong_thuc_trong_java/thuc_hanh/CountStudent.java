package ss3_mang_phuong_thuc_trong_java.thuc_hanh;
import java.util.Scanner;
public class CountStudent {
    public static void main(String[] args) {
        int student, i, count;
        int array[];
        Scanner input=new Scanner(System.in);
        do {
            System.out.print("Nhập số sinh viên: ");
            student=input.nextInt();
            if(student>30||student<0){
                System.out.println("Lỗi, vui lòng nhập lại");
            }
        }while (student<0||student>30);
         array=new int[student];
          i=0;
         while (i<array.length){
             System.out.print("Enter a mark for student "+(i+1)+"=");
             array[i]=input.nextInt();
             if(array[i]<0||array[i]>10){
                 System.out.println("lỗi");
                 i--;
             }
             i++;
         }
         count=0;
        for (int j = 0; j < array.length ; j++) {
            System.out.print(array[j]+"\t");
            if(array[j]>=5&&array[j]<=10){
                count++;
            }
        }
        System.out.println("");
        System.out.print("Số lượng sinh viên đỗ: "+ count);
    }
}
