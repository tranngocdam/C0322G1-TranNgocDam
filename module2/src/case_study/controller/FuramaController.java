package case_study.controller;

import case_study.common.exception.LimitMenuException;
import case_study.model.Facility;
import case_study.service.BookingService;
import case_study.service.CustomerService;
import case_study.service.EmployeeService;
import case_study.service.FacilityService;
import case_study.service.impl.BookingServiceImpl;
import case_study.service.impl.CustomerServiceImpl;
import case_study.service.impl.EmployeeServiceImpl;
import case_study.service.impl.FacilityServiceImpl;

import java.util.Scanner;

public class FuramaController {
    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeService employeeService = new EmployeeServiceImpl();
    private static CustomerService customerService = new CustomerServiceImpl();
    private static FacilityService facilityService = new FacilityServiceImpl();

    //private static BookingService bookingService=new BookingServiceImpl();
    public static void displayMainMenu() {
        while (true) {
            int choice;
            System.out.println("QUẢN LÍ FURAMA\n" +
                    "1. Employee Management\n" +
                    "2. Customer Management\n" +
                    "3. Facility Management \n" +
                    "4. Booking Management\n" +
                    "5. Promotion Management\n" +
                    "6. Exit");
            while (true) {
                try {
                    System.out.println("Please select: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice < 1 || choice > 6) {
                        throw new LimitMenuException("Lựa chọn không hợp lệ");
                    }
                    break;
                } catch (LimitMenuException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.err.println("Không nhập kí tự");
                }
            }
            switch (choice) {
                case 1:
                    boolean check1 = true;
                    int choice1;
                    while (check1) {
                        System.out.println("Employee Management\n" +
                                "1. Display list employees\n" +
                                "2. Add new employee\n" +
                                "3. Edit employee\n" +
                                "4. Return main menu");
                        while (true) {
                            try {
                                System.out.println("Please select: ");
                                choice1 = Integer.parseInt(scanner.nextLine());
                                if (choice1 < 1 || choice1 > 4) {
                                    throw new LimitMenuException("Lựa chọn không hợp lệ");
                                }
                                break;
                            } catch (LimitMenuException e) {
                                System.out.println(e.getMessage());
                            } catch (Exception e) {
                                System.err.println("Không nhập kí tự");
                            }
                        }
                        switch (choice1) {
                            case 1:
                                employeeService.display();
                                break;
                            case 2:
                                employeeService.add();
                                break;
                            case 3:
                                employeeService.edit();
                                break;
                            case 4:
                                check1 = false;
                                break;
                        }
                    }
                    break;
                case 2:
                    boolean check2 = true;
                    int choice2;
                    while (check2) {
                        System.out.println("Customer Management\n" +
                                "1.\tDisplay list customers\n" +
                                "2.\tAdd new customer\n" +
                                "3.\tEdit customer\n" +
                                "4.\tReturn main menu");

                        while (true) {
                            try {
                                System.out.println("Please select: ");
                                choice2 = Integer.parseInt(scanner.nextLine());
                                if (choice2 < 1 || choice2 > 4) {
                                    throw new LimitMenuException("Lựa chọn không hợp lệ");
                                }
                                break;
                            } catch (LimitMenuException e) {
                                System.out.println(e.getMessage());
                            } catch (Exception e) {
                                System.err.println("Không nhập kí tự");
                            }
                        }
                        switch (choice2) {
                            case 1:
                                customerService.display();
                                break;
                            case 2:
                                customerService.add();
                                break;
                            case 3:
                                customerService.edit();
                                break;
                            case 4:
                                check2 = false;
                                break;
                        }
                    }
                    break;
                case 3:
                    boolean check3 = true;
                    int choice3;
                    while (check3) {
                        System.out.println("Facility Management\n" +
                                "1\tDisplay list facility\n" +
                                "2\tAdd new facility\n" +
                                "3\tDisplay list facility maintenance\n" +
                                "4\tReturn main menu");
                        while (true) {
                            try {
                                System.out.println("Please select: ");
                                choice3 = Integer.parseInt(scanner.nextLine());
                                if (choice3 < 1 || choice3 > 4) {
                                    throw new LimitMenuException("Lựa chọn không hợp lệ");
                                }
                                break;
                            } catch (LimitMenuException e) {
                                System.out.println(e.getMessage());
                            } catch (Exception e) {
                                System.err.println("Không nhập kí tự");
                            }
                        }
                        switch (choice3) {
                            case 1:
                                facilityService.display();
                                break;
                            case 2:
                                facilityService.add();
                                break;
                            case 3:
                                facilityService.displayMainTenance();
                                break;
                            case 4:
                                check3 = false;
                                break;
                        }
                    }
                    break;
                case 4:
                    boolean check4 = true;
                    int choice4;
                    while (check4) {
                        System.out.println("Booking Managerment \n" +
                                "1.\tAdd new booking\n" +
                                "2.\tDisplay list booking\n" +
                                "3.\tCreate new constracts\n" +
                                "4.\tDisplay list contracts\n" +
                                "5.\tEdit contracts\n" +
                                "6.\tReturn main menu");
                        while (true) {
                            try {
                                System.out.println("Please select: ");
                                choice4 = Integer.parseInt(scanner.nextLine());
                                if (choice4<1||choice4>6){
                                    throw new LimitMenuException("Lựa chọn không hợp lệ");
                                }
                                break;
                            } catch (LimitMenuException e){
                                System.out.println(e.getMessage());
                            } catch (Exception e) {
                                System.err.println("Không nhập kí tự");
                            }
                        }
                        switch (choice4) {
                            case 1:
                                //bookingService.add();
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                check4 = false;
                                break;
                        }
                    }
                    break;
                case 5:
                    boolean check5 = true;
                    int choice5;
                    while (check5) {
                        System.out.println("Promotion Management\n" +
                                "1.\tDisplay list customers use service\n" +
                                "2.\tDisplay list customers get voucher\n" +
                                "3.\tReturn main menu");
                        while (true) {
                            try {
                                System.out.println("Please select: ");
                                choice5 = Integer.parseInt(scanner.nextLine());
                                if(choice5<1||choice5>3){
                                    throw new LimitMenuException("Lựa chọn không hợp lệ");
                                }
                                break;
                            }catch(LimitMenuException e){
                                System.out.println(e.getMessage());
                            } catch (Exception e) {
                                System.err.println("Không nhập kí tự");
                            }
                        }
                        switch (choice5) {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                check5 = false;
                                break;
                        }
                    }
                    break;
                case 6:
                    System.exit(0);
            }
        }

    }
}
