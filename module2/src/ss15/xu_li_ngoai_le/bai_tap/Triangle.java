package ss15.xu_li_ngoai_le.bai_tap;

public class Triangle {
       private int a, b, c;
    public Triangle(int a, int b, int c) throws TriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new TriangleException("không phải tam giác");
        } else if (a + b < c || a + c < b || b + c < a) {
            throw new TriangleException("không phải tam giác");
        } else {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}

