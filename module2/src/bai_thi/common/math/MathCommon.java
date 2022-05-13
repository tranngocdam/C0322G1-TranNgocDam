package bai_thi.common.math;

import case_study.common.exception.FacilityCodeFormatException;

import java.util.Scanner;

public class MathCommon {
    private static Scanner scanner=new Scanner(System.in);
    public static Double getDouble1() {
        String number = "";
        while (true) {
            try {
                number = scanner.nextLine();
                if (!number.matches("^([0-9])+(\\.([0-9])+)?$")) {
                    throw new FacilityCodeFormatException("Lỗi, phải là số dương và đúng định dạng(vd 23 or 23.4)");
                }
                break;
            } catch (FacilityCodeFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        return Double.parseDouble(number);
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
}
