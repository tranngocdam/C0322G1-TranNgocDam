package ss4_lop_doi_tuong_trong_java.bai_tap.Fan;

import ss4_lop_doi_tuong_trong_java.bai_tap.Fan.Fan;

public class MainFan {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setSpeed(fan1.FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);
        System.out.println(fan1);

        Fan fan2 = new Fan();
        fan2.setSpeed(fan2.MEDIUM);
        fan2.getRadius();
        fan2.getColor();
        fan2.getOn();
        System.out.println(fan2);
    }
}

