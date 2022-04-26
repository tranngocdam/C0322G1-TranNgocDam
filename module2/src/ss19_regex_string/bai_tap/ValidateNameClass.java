package ss19_regex_string.bai_tap;

import java.util.Scanner;

public class ValidateNameClass {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập tên lớp học: ");
        String nameClass=scanner.nextLine();
        while (!nameClass.matches("^(C|A|P)[0-9]{4}(G|H|I|K|L|M)$")){
            System.out.println("Nhập tên lớp sai");
            nameClass=scanner.nextLine();
        }
        System.out.println("Nhập đúng");
    }

}
