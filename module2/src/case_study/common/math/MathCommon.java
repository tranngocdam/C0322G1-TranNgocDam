package case_study.common.math;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MathCommon {
    private static Scanner scanner=new Scanner(System.in);
    public static Double getDouble(){
        String number="";
        while (true){
            number=scanner.nextLine();
            Pattern pattern=Pattern.compile("^[3-9][0-9]+(.[0-9]+)?|[1-9][0-9][0-9]+(.[0-9])?$");
            if (pattern.matcher(number).find()){
                break;
            }else {
                System.out.print("Nhập bị sai, số cần nhập lớn hơn 30: ");
            }

        }
        return Double.parseDouble(number);
    }
    public static Double getDouble1(){
        String number="";
        while (true){
            number=scanner.nextLine();
            Pattern pattern=Pattern.compile("^[0-9]+(.[0-9]+)?$");
            if (pattern.matcher(number).find()){
                break;
            }else {
                System.out.print("Nhập bị sai, chi phí thuê phải là số dương: ");
            }

        }
        return Double.parseDouble(number);
    }
    public static Integer getInteger(){
        String number="";
        while (true){
            number=scanner.nextLine();
            Pattern pattern=Pattern.compile("^(1[0-9]|[1-9])$");
            if (pattern.matcher(number).find()){
                break;
            }else {
                System.out.print("Nhập bị sai, số lượng người bé hơn 20 và lớn hơn 0: ");
            }

        }
        return Integer.parseInt(number);
    }
    public static Integer getInteger1(){
        String number="";
        while (true){
            number=scanner.nextLine();
            Pattern pattern=Pattern.compile("^[1-9]([0-9]+)?$");
            if (pattern.matcher(number).find()){
                break;
            }else {
                System.out.print("Nhập bị sai, số nhập phải dương: ");
            }

        }
        return Integer.parseInt(number);
    }
    public static Integer getSoCMND(){
        String number="";
        while (true){
            number=scanner.nextLine();
            Pattern pattern=Pattern.compile("^[1-9]{6}$");
            if (pattern.matcher(number).find()){
                break;
            }else {
                System.out.print("Nhập bị sai, số CMND gồm 6 số: ");
            }

        }
        return Integer.parseInt(number);
    }
    public static Integer getSoDienThoai(){
        String number="";
        while (true){
            number=scanner.nextLine();
            Pattern pattern=Pattern.compile("^[1-9]{5}$");
            if (pattern.matcher(number).find()){
                break;
            }else {
                System.out.print("Nhập bị sai, số điện thoại gồm 5 số: ");
            }
        }
        return Integer.parseInt(number);
    }
}
