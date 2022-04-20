package giai_thuat;
import java.util.Scanner;
public class giai_thuat_1 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
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
        String str="CodegymDaNang";
        String st= str.toLowerCase();
       for(int i=0; i<st.length(); i++){
        if (st[i].equals(str)){
            System.out.println("\t");
        }
        }
        System.out.println(st);
    }
}
