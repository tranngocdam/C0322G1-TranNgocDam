package ss2_vong_lap_trong_java.bai_tap;
import java.util.Scanner;
public class IsPrime100 {
    public static void main(String[] args) {
        int n;
        boolean check;
        Scanner input=new Scanner(System.in);
        n=0;
        while (n<100){
            check = true;
            if (n<2){
                check=false;
            }else {
                for (int i=2; i<Math.sqrt(n); i++){
                    if (n%i==0){
                        check=false;
                        break;
                    }
                }
            }
            if (check==true){
                System.out.printf(n+",");
            }
            n++;
        }

    }
}
