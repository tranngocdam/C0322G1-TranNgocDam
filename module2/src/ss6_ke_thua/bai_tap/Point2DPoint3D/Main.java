package ss6_ke_thua.bai_tap.Point2DPoint3D;

public class Main {
    public static void main(String[] args) {
        Point2D point2D=new Point2D();
        System.out.println(point2D);

        point2D.setXY(5.1f,6.6f);
        System.out.println(point2D);

        Point3D point3D=new Point3D();
        System.out.println(point3D);

        point3D.setXYZ(2.4f, 3.9f, 9.8f);
        System.out.println(point3D);
    }
}
