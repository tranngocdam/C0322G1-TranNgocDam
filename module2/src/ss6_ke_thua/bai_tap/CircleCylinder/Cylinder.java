package ss6_ke_thua.bai_tap.CircleCylinder;

public class Cylinder extends Circle {
    private double height=0;
    public Cylinder(){
    }
    public Cylinder(double height, double radius, String color){
        super(radius, color);
        this.height=height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return getArea()*getHeight();
    }

    @Override
    public String toString() {
        return "Cylinder:" +
                "height="  + height +
                ""+super.toString() +
                "     volume= "   + getVolume() ;
    }
}
