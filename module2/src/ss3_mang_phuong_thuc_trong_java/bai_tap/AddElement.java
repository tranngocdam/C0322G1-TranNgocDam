package ss3_mang_phuong_thuc_trong_java.bai_tap;
import java.util.Scanner;
public class AddElement {
    public static void main(String[] args) {
        int value, index;
        Scanner input=new Scanner(System.in);
        int array[]={1,2,3,4,5,6,7,8,9};
        int n=array.length;
        System.out.print("Enter the value: ");
        value=input.nextInt();
        do {
            System.out.print("Enter the index: ");
            index=input.nextInt();
            if(index<-1||index>=array.length-1){
                System.out.print("Không chèn được phần tử vào mảng"+"\n");
            }
        }while (index<-1||index>=array.length-1);
        for (int i = n; i >=index+1 ; i--) {
            array[i]=array[i+1];
        }
        array[index]=value;
        n++;
        for (int i = 0; i <n ; i++) {
            System.out.print(array[i]+"\t");
        }

    }
}
