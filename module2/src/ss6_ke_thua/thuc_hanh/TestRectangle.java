package ss6_ke_thua.thuc_hanh;

public class TestRectangle {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        rectangle = new Rectangle(2.3, 5.8);
        System.out.println(rectangle);
        rectangle.setLength(5);
        rectangle.setWidth(4);
        rectangle.setFilled(true);
        rectangle.setColor("red");
        System.out.println(rectangle);
        rectangle = new Rectangle(2.5, 3.8, "orange", false);
        System.out.println(rectangle);

    }
}
