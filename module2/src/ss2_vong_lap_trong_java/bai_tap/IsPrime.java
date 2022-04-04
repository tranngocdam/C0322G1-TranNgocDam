package ss2_vong_lap_trong_java.bai_tap;
import java.util.Scanner;
public class IsPrime {
    public static void main(String[] args) {
        int numbers, count, n;
        boolean check;
        Scanner input = new Scanner(System.in);
        count = 0;
        n=0;
        System.out.print("Enter the number:  ");
        numbers= input.nextInt();
        while (count<numbers){
            check=true;
            if(n<2){
                check=false;
            }else {
                for (int i=2; i<n; i++){
                    if(n%i==0){
                        check=false;
                        break;
                    }
                }
            }
            if(check==true){
                count++;
                System.out.printf(n+",");
            }
            n++;
        }

    }
}
