package ss15_xu_li_ngoai_le.bai_tap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int m, p, k;
        Scanner scanner=new Scanner(System.in);

            System.out.print("Hãy nhập cạnh m: ");
            m = Integer.parseInt(scanner.nextLine());
            System.out.print("Hãy nhập cạnh p: ");
            p = Integer.parseInt(scanner.nextLine());
            System.out.print("Hãy nhập cạnh k: ");
            k = Integer.parseInt(scanner.nextLine());
        try {
            Triangle triangle=new Triangle(m, p, k);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
