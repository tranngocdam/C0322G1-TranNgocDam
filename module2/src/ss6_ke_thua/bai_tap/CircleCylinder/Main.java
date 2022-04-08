package ss6_ke_thua.bai_tap.CircleCylinder;

public class Main {
    public static void main(String[] args) {
        Cylinder cylinder=new Cylinder();
        System.out.println(cylinder);
        cylinder = new Cylinder(2, 2, "green");
        System.out.println(cylinder);
        cylinder.setRadius(4);
        cylinder.setHeight(6);
        cylinder.setColor("black");
        System.out.print(cylinder);
    }
}
