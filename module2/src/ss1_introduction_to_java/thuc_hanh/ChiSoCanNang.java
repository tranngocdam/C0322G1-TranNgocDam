package ss1_introduction_to_java.thuc_hanh;
import java.util.Scanner;
public class ChiSoCanNang {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Nhập cân nặng: ");
        double weight= scanner.nextDouble();
        System.out.print("Nhập chiều cao: ");
        double height=scanner.nextDouble();
        double bmi=weight/(Math.pow(height, 2));
        if(bmi<18){
            System.out.println("bmi="+bmi+"   underweight");
        }else if(bmi<25.0){
            System.out.println("bmi="+bmi+"    normal");
        }else if(bmi<30.0){
            System.out.println("bmi="+bmi+"    overweight");
        }else {
            System.out.println("bmi="+bmi+"    obese");
        }
    }
}
