package ss19_regex_string.bai_tap;

import java.util.Scanner;

public class ValidateTelePhone {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Nhập số điện thoại: ");
        String numberPhone=scanner.nextLine();
        while (!numberPhone.matches("^\\([0-9]{2}\\)\\-\\([0][0-9]{9}\\)$")){
            System.out.println("nhập sai số điện thoại");
            numberPhone=scanner.nextLine();
        }
        System.out.println("nhập đúng");
    }
}
