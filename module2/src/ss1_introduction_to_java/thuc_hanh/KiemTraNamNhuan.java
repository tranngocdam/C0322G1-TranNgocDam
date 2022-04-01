package ss1_introduction_to_java.thuc_hanh;
import java.util.Scanner;
public class KiemTraNamNhuan {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Nhập năm:");
        int year=scanner.nextInt();
        if(year%4==0){
            if (year%100==0){
                if (year%400==0){
                    System.out.print("Năm nhuận");
                }else {
                    System.out.print("Năm không nhuận");
                }
            }else {
                System.out.print("Năm nhuận");
            }
        }else {
            System.out.print("Năm không nhuận");
        }
    }
}
