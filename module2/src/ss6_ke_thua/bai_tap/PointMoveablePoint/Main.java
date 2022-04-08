package ss6_ke_thua.bai_tap.PointMoveablePoint;

public class Main {
    public static void main(String[] args) {
        Point point=new Point();
        System.out.println(point);

        MoveablePoint moveablePoint=new MoveablePoint();
        System.out.println(moveablePoint);

        moveablePoint.setXY(5.6f, 6.7f);
        System.out.println(moveablePoint);

        moveablePoint.setSpeed(7.1f, 4.5f);
        System.out.println(moveablePoint);

        MoveablePoint moveablePoint1=new MoveablePoint(23.2f,3.4f, 4.3f,5.6f);
        System.out.println(moveablePoint1);
    }
}
