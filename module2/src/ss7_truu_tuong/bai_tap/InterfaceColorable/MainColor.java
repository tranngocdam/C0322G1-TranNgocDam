package ss7_truu_tuong.bai_tap.InterfaceColorable;

import ss7_truu_tuong.bai_tap.InterfaceResizeable.Circle;
import ss7_truu_tuong.bai_tap.InterfaceResizeable.Rectangle;
import ss7_truu_tuong.bai_tap.InterfaceResizeable.Shape;

public class MainColor {
    public static void main(String[] args) {
        Shape[] shapes=new Shape[3];
        shapes[0]=new Square("red", true,9);
        shapes[1]=new Circle(6);
        shapes[2]=new Rectangle(5,6,"green", false);
        for (Shape shape : shapes) {
            if(shape instanceof Square){
                System.out.println("Area the Square : "+((Square) shape).getArea());
                ((Square) shape).howToColor();
            }
            if(shape instanceof Circle){
                System.out.println("Area the Circle : "+((Circle) shape).getArea());
            }
            if (shape instanceof Rectangle){
                System.out.println("Area the Rectangle: "+((Rectangle) shape).getArea());
            }
        }
    }
}
