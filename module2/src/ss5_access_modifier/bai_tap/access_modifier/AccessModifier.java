package ss5_access_modifier.bai_tap.access_modifier;

public class AccessModifier {
    private double radius=1.0;
    private String color = "red";
    public   AccessModifier(){
    }
    public AccessModifier(double radius){
        this.radius=radius;
    }
     protected double getRadius() {
        return radius;
    }
    void setRadius(double radius){
        this.radius=radius;
    }
     double getArea(){
        return Math.pow(radius, 2)*3.14;
    }
    String getColor(){
        return this.color;
    }
}
