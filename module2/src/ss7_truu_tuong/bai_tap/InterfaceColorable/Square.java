package ss7_truu_tuong.bai_tap.InterfaceColorable;

import ss7_truu_tuong.bai_tap.InterfaceResizeable.Shape;

public class Square extends Shape implements Colorable{
    private int edge = 1;
    public Square(){

    }
    public Square(int edge) {
        this.edge = edge;
    }

    public Square(String color, boolean filled, int edge) {
        super(color, filled);
        this.edge = edge;
    }

    public int getEdge() {
        return edge;
    }

    public void setEdge(int edge) {
        this.edge = edge;
    }
    public int getArea(){
        return edge*edge;
    }

    public void howToColor() {
        System.out.println("Color for all sides");
    }
}
