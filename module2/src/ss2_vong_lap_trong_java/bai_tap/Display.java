package ss2_vong_lap_trong_java.bai_tap;
import java.util.Scanner;
public class Display {
    public static void main(String[] args) {
        int choice, i, j;
        Scanner input=new Scanner(System.in);
        choice=-1;
        while (choice!=0){
            System.out.println("Menu");
            System.out.println("1. Draw the rectangle");
            System.out.println("2. Draw the triangle botton-left");
            System.out.println("3. Draw the triangle top-left");
            System.out.println("4. Draw the isosceles triangle");
            System.out.println("exit");
            System.out.print("Enter your choice: ");
            choice= input.nextInt();
            switch (choice){
                case 1:
                    for ( i=0; i<4; i++){
                        for (j=0; j<7; j++){
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;
                case 2:
                    for (i=1; i<=5; i++){
                        for (j=1; j<=i; j++){
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;
                case 3:
                    for (i=5; i>=1; i--){
                        for (j=1; j<=i; j++){
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;
                case 4:
                    for (i=1; i<=4; i++){
                        for (j=1; j<=7; j++){
                            if(j>=4-i+1&&j<=4+i-1){
                                System.out.print("*");
                            }else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println("");
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
