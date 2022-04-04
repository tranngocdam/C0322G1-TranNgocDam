package ss2_vong_lap_trong_java.thuc_hanh;
import java.util.Scanner;
public class Prime {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n, i;
        boolean check;
        System.out.print("Enter the number: ");
        n= scanner.nextInt();
        if(n<2){
            System.out.printf(n+"  is not a prime");
        }else {
            i=2;
            check = true;
            while (i<n){
               if(n%i==0){
                   check=false;
                   break;
               }
               i++;
            }
            if(check==true){
                System.out.printf(n+" is a prime");
            }else {
                System.out.printf(n+" is not a prime");
            }
        }
    }
}
