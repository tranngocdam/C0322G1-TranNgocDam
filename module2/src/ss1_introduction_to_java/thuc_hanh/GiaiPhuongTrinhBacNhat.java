package ss1_introduction_to_java.thuc_hanh;
import java.util.Scanner;
public class GiaiPhuongTrinhBacNhat {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = c', please enter constants:");
        Scanner scanner = new Scanner(System.in);
        double a, b, c, answer;
        System.out.print("a: ");
         a = scanner.nextDouble();
        System.out.print("b: ");
         b = scanner.nextDouble();
        System.out.print("c: ");
         c = scanner.nextDouble();
        if (a != 0) {
             answer = (c - b) / a;
            System.out.printf("Equation pass with x = %f!\n", answer);
        } else {
            if (b == c) {
                System.out.print("The solution is all x!");
            } else {
                System.out.print("No solution!");
            }
        }
    }
}
