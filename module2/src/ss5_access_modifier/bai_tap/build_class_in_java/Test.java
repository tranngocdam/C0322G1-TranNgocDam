package ss5_access_modifier.bai_tap.build_class_in_java;

public class Test {
    public static void main(String[] args) {
        Student student=new Student();
        student.getName();
        System.out.println(student.getName());
        student.getClasses();
        System.out.println(student.getClasses());
        student.setName("Henry");
        student.setClasses("s04");
        System.out.print(student);
    }
}
