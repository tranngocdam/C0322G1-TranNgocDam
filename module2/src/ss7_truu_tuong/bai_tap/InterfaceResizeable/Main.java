package ss7_truu_tuong.bai_tap.InterfaceResizeable;

public class Main {
    public static void main(String[] args) {
        Shape shape=new Shape();
        Circle circle=new Circle(4);
        circle.resize(7);
        System.out.println(circle);

        Rectangle rectangle= new Rectangle(6, 7);
        rectangle.resize(6);
        System.out.println(rectangle);


    }
}
