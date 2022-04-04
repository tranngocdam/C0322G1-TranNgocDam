package ss3_mang_phuong_thuc_trong_java.thuc_hanh;
import java.util.Scanner;
public class DaoNguocCacPhanTuMang {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int size;
        int array[];
        do{
            System.out.print("Enter the size: ");
            size=input.nextInt();
            if(size > 20){
                System.out.print("Size does not exceed 20 ");
            }
        }while (size<0||size>20);
        array= new int[size];
        int i;
        for (i=0; i<array.length; i++){
            System.out.print("Element "+(i+1)+"=");
            array[i]= input.nextInt();
        }
        for (i=0; i<array.length; i++){
            System.out.print(array[i]+"\t");
        }
        System.out.println("");
        int first=0;
        int last=array.length-1;
        while (first<last){
            int dem=array[first];
            array[first]=array[last];
            array[last]=dem;
            first++;
            last--;
        }
        for (i=0; i<array.length; i++){
            System.out.print(array[i]+"\t");
        }
    }
}
