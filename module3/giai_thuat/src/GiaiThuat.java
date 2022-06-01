public class GiaiThuat {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        for (i = 0; i < 5; i++) {
            for (j = 0; j <10; j++) {
                if (i <= j) {
                    System.out.println("*");
                }
            }
        }
    }
}
