package ss4_lop_doi_tuong_trong_java.bai_tap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double a, b, c;
        Scanner input= new Scanner(System.in);
        System.out.print("Enter a:");
        a=Double.parseDouble(input.nextLine());
        System.out.print("Enter b:");
        b=Double.parseDouble(input.nextLine());
        System.out.print("Enter c:");
        c=Double.parseDouble(input.nextLine());
        QuadraticEquation quadraticEquation=new QuadraticEquation(a, b, c);
        System.out.println("Discriminant= "+quadraticEquation.getDiscriminant());
        if(quadraticEquation.getDiscriminant()>0){
            System.out.println("root1= "+quadraticEquation.getRoot1());
            System.out.println("root2= "+quadraticEquation.getRoot2());
        }else if(quadraticEquation.getDiscriminant()==0){
            System.out.print(quadraticEquation.getRoot());
        }else {
            System.out.print("The equation has no roots");
        }
    }

}
