package ss4_lop_doi_tuong_trong_java.thuc_hanh;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        double width, height;
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the width: ");
        width=Double.parseDouble(input.nextLine());
        System.out.print("Enter the height: ");
        height=Double.parseDouble(input.nextLine());
        Rectangle rectangle = new Rectangle(width, height);
        System.out.println("Your Rectangle \n"+ rectangle.display());
        System.out.println("Perimeter of the Rectangle: "+ rectangle.getPerimeter());
        System.out.println("Area of the Rectangle: "+ rectangle.getArea());
    }
}
