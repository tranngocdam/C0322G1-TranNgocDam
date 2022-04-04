package ss3_mang_phuong_thuc_trong_java.thuc_hanh;
import java.util.Scanner;
public class CelsiusFahrenheit {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        double fahrenheit;
        double celsius;
        int choice;
        do {
            System.out.println("Menu");
            System.out.println("1. Fahrenheit to celsius");
            System.out.println("2. Celsius to fahrenheit");
            System.out.println("0.Exit");
            System.out.print("Enter the choice:  ");
            choice=input.nextInt();
            switch (choice){
                case 1:
                    System.out.print("Enter fahrenheit: ");
                    fahrenheit=input.nextDouble();
                    System.out.printf("Fahrenheit to celsius: "+ fahrenheitToCelsius(fahrenheit));
                    System.out.println("");
                    break;
                case 2:
                    System.out.print("Enter celsius: ");
                    celsius=input.nextDouble();
                    System.out.printf("Celsius to fahrenheit: "+ celsiusToFahrenheit(celsius));
                    System.out.println("");
                    break;
                case 0:
                    System.exit(0);
            }
        }while (choice!=0);
    }
    public static double fahrenheitToCelsius(double celsius){
        double fahrenheit=(9.0 / 5) * celsius + 32;
        return fahrenheit;
    }
    public static double  celsiusToFahrenheit(double fahrenheit) {
        double celsius = (5.0 / 9) * (fahrenheit - 32);
        return celsius;
    }
}
