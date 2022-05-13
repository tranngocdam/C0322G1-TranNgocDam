package case_study.common.math;

import bai_thi.common.exception.NumberFormatException;
import case_study.common.exception.CustomerCodeFormatException;
import case_study.common.exception.EmployeeCodeFormatException;
import case_study.common.exception.FacilityCodeFormatException;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MathCommon {
    private static Scanner scanner = new Scanner(System.in);

    public static Double getDouble() {
        String number = "";
        while (true) {
            try {
                number = scanner.nextLine();
                if (!number.matches("^(([3-9]([0-9])+)((\\.[0-9]+)?)|(([1-9][0-9]([0-9])+)(\\.[0-9])?))$")) {
                    throw new FacilityCodeFormatException("Lỗi, diện tích lớn hơn 30m2");
                }
                break;
            } catch (FacilityCodeFormatException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Lỗi đăng nhập, không chứa kí tự");
            }
        }
        return Double.parseDouble(number);
    }

    public static Double getDouble1() {
        String number = "";
        while (true) {
            try {
                number = scanner.nextLine();
                if (!number.matches("^([0-9])+(\\.([0-9])+)?$")) {
                    throw new NumberFormatException("Lỗi, phải là số dương và đúng định dạng(vd 23 or 23.4)");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        return Double.parseDouble(number);
    }

    public static Integer getInteger() {
        String number = "";
        while (true) {
            try {
                number = scanner.nextLine();
                if (!number.matches("^(1[0-9]|[1-9])$")) {
                    throw new FacilityCodeFormatException("Lỗi, người phải lớn hơn 0 và bé hơn 20");
                }
                break;
            } catch (FacilityCodeFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(number);
    }

    public static Integer getInteger1() {
        String number = "";
        while (true) {
            try {
                number = scanner.nextLine();
                if (!number.matches("^([0-9])([0-9]+)?$")) {
                    throw new FacilityCodeFormatException("Lỗi, cần nhập một số dương");
                }
                break;
            } catch (FacilityCodeFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(number);
    }

    public static Integer getSoCMND() {
        String number = "";
        while (true) {
            try {
                number = scanner.nextLine();
                if (!number.matches("^([1-9]{6})$")) {
                    throw new CustomerCodeFormatException("Lỗi, số CMND có 6 chữ số");
                }
                break;
            } catch (CustomerCodeFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(number);
    }

    public static Integer getSoDienThoai() {
        String number = "";
        while (true) {
            try {
                number = scanner.nextLine();
               // Pattern pattern = Pattern.compile("^[1-9]{5}$");
                if (!number.matches("^[1-9]{5}$")) {
                   throw new EmployeeCodeFormatException("Lỗi, số điện thoại có 5 chữ số");
                }
                break;
            }catch (EmployeeCodeFormatException e){
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(number);
    }

}
