package ss1_introduction_to_java.bai_tap;
import java.util.Scanner;
public class HienThiLoiChao {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String name;
        System.out.print("Nhập tên: ");
        name= scanner.nextLine();
        System.out.println("hello   "+ name);
    }
}
