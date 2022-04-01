package ss1_introduction_to_java.bai_tap;
import java.util.Scanner;
public class ChuyenDoiTienTe {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Nhập USD: ");
        double usd= scanner.nextDouble();
        double rate=23000;
        System.out.println("Tiền VND="+usd*rate);
    }
}
