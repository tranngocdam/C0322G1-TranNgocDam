package ss5_access_modifier.bai_tap.access_modifier;
public class MainAccessModifier {
    public static void main(String[] args) {
        AccessModifier accessModifier=new AccessModifier();
        accessModifier.getRadius();
        System.out.println(accessModifier.getRadius());
        accessModifier.getArea();
        System.out.println(accessModifier.getArea());
        accessModifier.getColor();
        System.out.println(accessModifier.getColor());
        accessModifier.setRadius(5);
        System.out.println(accessModifier.getArea());
    }
}
