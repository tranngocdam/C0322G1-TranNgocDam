package ss3_mang_phuong_thuc_trong_java.thuc_hanh;
import java.util.Scanner;
public class FinStudent {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String student[]={"tuấn", "tú", "cường", "linh", "hin", "minh", "liễu", "dũng", "anh"};
        String name;
        boolean check=false;
        System.out.print("Nhập tên: ");
        name=input.nextLine();
        int i;
        for (i=0; i<student.length; i++){
            if(student[i].equals(name)){
                System.out.print("Position of the students in the list " + name + " is: " + i);
                check =true;
                break;
            }
        }
        if(!check){
            System.out.print("No find name");
        }
    }
}
