package ss4_lop_doi_tuong_trong_java.bai_tap;

public class MainFan {
    public static void main(String[] args) {
        Fan fan1 = new Fan(3, 10, "yellow");
        fan1.setOn(false);
        System.out.println(fan1.toString());

        Fan fan2 =new Fan(2,5,"blue");
        fan2.setOff(false);
        System.out.println(fan2.toString());
    }
}
