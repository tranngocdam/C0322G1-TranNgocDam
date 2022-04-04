package ss2_vong_lap_trong_java.thuc_hanh;
import java.util.Scanner;
public class BankInterest {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int month=1, i;
        double money=1.0, interestRate=1.0, totalInterest=0;
        System.out.print("Enter money: ");
        money=input.nextDouble();
        System.out.print("Enter month: ");
        month=input.nextInt();
        System.out.print("Enter interestRate: ");
        interestRate=input.nextDouble();
        for (i=0; i<month; i++){
            totalInterest += money * (interestRate/100) * month;
        }
        System.out.printf("Total of interest: "+totalInterest);
    }
}
