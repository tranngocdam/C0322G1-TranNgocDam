package ss1_introduction_to_java.thuc_hanh;
import java.util.Scanner;
public class ToanTu {
    public static void main(String[] args) {
        float width, height, area;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter width: ");
        width = scanner.nextFloat();
        System.out.println("Enter height: ");
        height = scanner.nextFloat();
        area = width * height;
        System.out.println("Area is: " + area);
    }
}
