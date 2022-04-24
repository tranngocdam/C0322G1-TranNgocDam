package giai_thuat;
import java.util.Scanner;
public class giai_thuat_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        for (int i = 1; i<6 ; i++) {
//            for (int j = 1; j<14 ; j++) {
//                if(j<12-3-i||j>12-4+i){
//                    System.out.print(" ");
//                }else {
//                        System.out.print(i);
//                }
//            }
//            System.out.println("");
//        }
//        for (int i = 4; i>0 ; i--) {
//            for (int j = 1; j<=12 ; j++) {
//                if(j<12-3-i||j>12-4+i){
//                    System.out.print(" ");
//                }else {
//                    System.out.print(i);
//                }
//            }
//            System.out.println("");
//        }
        int[] arr={10, 20, 30};
        int index;
        int element=0;
        try{
            System.out.print("Nhập vị trí index:");
            index=Integer.parseInt(input.nextLine());
            element=arr[index];
            //return;
        }catch (NumberFormatException e){
            index=0;
            element=arr[index];
            System.out.println("lỗi nhập");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("lỗi truy cập ngoài mảng");
        index=arr.length-1;
        element=arr[index];
        }
//        catch (Exception e){
//            System.out.println("lỗi");
//            index=arr.length-1;
//            element=arr[index];
//            e.printStackTrace();
//        }
        System.out.println("phần tử "+index+": "+element);
    }
}
