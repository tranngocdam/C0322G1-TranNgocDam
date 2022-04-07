package ss5_access_modifier.thuc_hanh;
import  java.util.Scanner;
public class StaticMethod {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Student.change(); //calling change method
        //creating objects
        Student s1 = new Student(111, "Hoang");
        Student s2 = new Student(222, "Khanh");
        Student s3 = new Student(333, "Nam");

        //calling display method
        s1.display();
        s2.display();
        s3.display();
    }
}
