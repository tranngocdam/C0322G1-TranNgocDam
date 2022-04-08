package ss6_ke_thua.bai_tap.CircleCylinder;

public class Circle {
    private double radius=0;
    private String color="red";
    private final double PI = 3.14;
    public Circle(){
    }
    public Circle(double radius, String color){
        this.radius=radius;
        this.color=color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double getArea(){
        return Math.pow(radius, 2)* PI;
    }

    @Override
    public String toString() {
        return "      radius=" + radius +
                "     color=" + color ;
    }
}
