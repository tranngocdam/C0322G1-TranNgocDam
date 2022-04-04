package ss2_vong_lap_trong_java.thuc_hanh;
import java.util.Scanner;
public class UCLL {
    public static void main(String[] args) {
        int a, b;
        Scanner input=new Scanner(System.in);
        System.out.print("nhập a: ");
        a= input.nextShort();
        System.out.print("nhập b: ");
        b= input.nextInt();
        a = Math.abs(a);
        b = Math.abs(b);
        if (a==0||b==0){
            System.out.print("không có ước chung");
        }else {
            while (a!=b){
                if(a>b){
                    a=a-b;
                }else {
                    b=b-a;
                }
            }
            System.out.print("ước chung lớn nhất là: "+ a);
        }
    }
}
