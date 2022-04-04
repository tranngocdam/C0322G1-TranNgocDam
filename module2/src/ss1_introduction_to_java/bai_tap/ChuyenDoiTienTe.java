package ss1_introduction_to_java.bai_tap;
import java.util.Scanner;
public class ChuyenDoiTienTe {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double usd, rate;
        System.out.print("Nhập USD: ");
         usd= scanner.nextDouble();
         rate=23000;
        System.out.println("Tiền VND="+usd*rate);
    }
}
