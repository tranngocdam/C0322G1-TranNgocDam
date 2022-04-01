package ss1_introduction_to_java.bai_tap;
import java.util.Scanner;
public class DocSoThanhChu {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập a: ");
        int a = scanner.nextInt();
        String string="";
        if(a<10&&a>=0){
            switch (a){
                case 0:
                    System.out.println("zero");
                    break;
                case 1:
                    System.out.println("one");
                    break;
                case 2:
                    System.out.println("tow");
                    break;
                case 3:
                    System.out.println("three");
                    break;
                case 4:
                    System.out.println("four");
                    break;
                case 5:
                    System.out.println("five");
                    break;
                case 6:
                    System.out.println("six");
                    break;
                case 7:
                    System.out.println("seven");
                    break;
                case 8:
                    System.out.println("eight");
                    break;
                case 9:
                    System.out.println("nine");
                    break;
            }
        }else if(a>=10&&a<20){
            int k=a%10;
            switch (k){
                case 0:
                    System.out.println("ten");
                    break;
                case 1:
                    System.out.println("eleven");
                    break;
                case 2:
                    System.out.println("twelve");
                    break;
                case 3:
                    System.out.println("thirteen");
                    break;
                case 4:
                    System.out.println("fourteen");
                    break;
                case 5:
                    System.out.println("fifteen");
                    break;
                case 6:
                    System.out.println("sixteen");
                    break;
                case 7:
                    System.out.println("seventeen");
                    break;
                case 8:
                    System.out.println("eighteen");
                    break;
                case 9:
                    System.out.println("nineteen");
                    break;
            }
        }else if(a>=20&&a<100){
            int tens=a/10;
            int ones=a%10;
            switch (tens){
                case 2 :
                    string="twenty";
                    break;
                case 3:
                    string="thirty";
                    break;
                case 4:
                    string="forty";
                    break;
                case 5:
                    string="fifty";
                    break;
                case 6:
                    string="sixty";
                    break;
                case 7:
                    string="seventy";
                    break;
                case 8:
                    string="eighty";
                    break;
                case 9:
                    string="ninety";
                    break;
            }
            switch (ones){
                case 0:
                    string+="";
                    break;
                case 1:
                    string+="one";
                    break;
                case 2:
                    string+="tow";
                    break;
                case 3:
                    string+="three";
                    break;
                case 4:
                    string+="four";
                    break;
                case 5:
                    string+="five";
                    break;
                case 6:
                    string+="six";
                    break;
                case 7:
                    string+="seven";
                    break;
                case 8:
                    string+="eight";
                    break;
                case 9:
                    string+="nine";
                    break;
            }
            //System.out.printf(string);
        }else if(a>=100&&a<1000){
            int tram=a/100;
            int chuc=(a%100)/10;
            int donVi=(a%100)%10;
            switch (tram){
                case 1:
                    string="one hundred";
                    break;
                case 2:
                    string="two hundred";
                    break;
                case 3:
                    string="three hundred";
                    break;
                case 4:
                    string="four hundred";
                    break;
                case 5:
                    string="five hundred";
                    break;
                case 6:
                    string="six hundred";
                    break;
                case 7:
                    string="seven hundred";
                    break;
                case 8:
                    string="eight hundred";
                    break;
                case 9:
                    string="nine hundred";
                    break;
            }
            switch (chuc){
                case 0:
                    string+="";
                    break;
                case 1:
                    string+=" and ten";
                    break;
                case 2:
                    string+=" and twenty";
                    break;
                case 3:
                    string+=" and thirty";
                    break;
                case 4:
                    string+=" and forty";
                    break;
                case 5:
                    string+=" and fifty";
                    break;
                case 6:
                    string+=" and sixty";
                    break;
                case 7:
                    string+=" and seventy";
                    break;
                case 8:
                    string+=" and eighty";
                    break;
                case 9:
                    string+=" and ninety";
                    break;
            }
            switch (donVi){
                case 0:
                    string+="";
                    break;
                case 1:
                    string+=" one";
                    break;
                case 2:
                    string+=" tow";
                    break;
                case 3:
                    string+=" three";
                    break;
                case 4:
                    string+=" four";
                    break;
                case 5:
                    string+=" five";
                    break;
                case 6:
                    string+=" six";
                    break;
                case 7:
                    string+=" seven";
                    break;
                case 8:
                    string+=" eight";
                    break;
                case 9:
                    string+=" nine";
                    break;
            }
            System.out.print(string);
        }else {
            System.out.print("Số quá lớn");
        }
    }
}
