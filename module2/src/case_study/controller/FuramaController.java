package case_study.controller;

import java.util.Scanner;

public class FuramaController {
    private static Scanner scanner=new Scanner(System.in);
    public static void displayMainMenu(){
        System.out.println("QUẢN LÍ FURAMA\n" +
                "1. Employee Management\n" +
                "2. Customer Management\n" +
                "3. Facility Management \n" +
                "4. Booking Management\n" +
                "5. Promotion Management\n" +
                "6. Exit\n");
        System.out.println("Please select: ");
        int choise=Integer.parseInt(scanner.nextLine());
        switch (choise){
            case 1:
                System.out.println("Employee Management\n" +
                        "1. Display list employees\n" +
                        "2. Add new employee\n" +
                        "3. Edit employee\n" +
                        "4. Return main menu\n");
                int choice1=Integer.parseInt(scanner.nextLine());
                switch (choice1){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;

                }
                break;
            case 2:
                System.out.println("Customer Management\n" +
                        "1.\tDisplay list customers\n" +
                        "2.\tAdd new customer\n" +
                        "3.\tEdit customer\n" +
                        "4.\tReturn main menu\n");
                int choice2=Integer.parseInt(scanner.nextLine());
                switch (choice2){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                }
                break;
            case 3:

        }

    }
}
