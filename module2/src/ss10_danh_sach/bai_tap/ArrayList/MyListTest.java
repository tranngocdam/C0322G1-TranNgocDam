package ss10_danh_sach.bai_tap.ArrayList;

public class MyListTest {
    public static class Student {
        private int id;
        private String name;

        public Student() {
        }

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    public static void main(String[] args) {
        Student a = new Student(1, "dũng");
        Student b = new Student(2, "hiệp");
        Student c = new Student(3, "hồng");
        Student d = new Student(4, "an");
        Student e = new Student(5, "hoa");
        Student f = new Student(6, "hoàng");
        MyList<Student> studentMyList = new MyList<>();

        // thêm phần tử vào list
        studentMyList.add(a);
        studentMyList.add(b);
        studentMyList.add(c);
        studentMyList.add(d);
        studentMyList.add(e);

        //phương thức thêm vào vi tri chỉ định
//        studentMyList.add(f,2);

        for (int i = 0; i < studentMyList.size(); i++) {
            Student student = (Student) studentMyList.elements[i];
            System.out.println(student.getId());
            System.out.println(student.getName());
        }
        //phương thức lấy phần tử ở ví trí cần lấy
        System.out.println("ptu can lay ra: " + studentMyList.get(3).getName());

        //phương thức lấy index của 1 phần tử trong mảng
        System.out.println("ptu thu: " + studentMyList.indexOf(c));

        //sd phương thức xóa tất cả clear
        // studentMyList.clear();

        //kiểm tra phần tử có trong mảng không
        System.out.println(studentMyList.contains(b));
        //sd phương thức size
        studentMyList.size();
        System.out.println("do dai mang= " + studentMyList.size());

        //phương thức clone tạo ra bản sao của mảng cũ
        MyList<Student> newStudentMyList = new MyList<>();
        newStudentMyList= studentMyList.clone();

        //xóa vị trí phần tự theo chỉ định
        Student student = newStudentMyList.remove(3);

        System.out.println("ban sao");
        for (int i = 0; i < newStudentMyList.size(); i++) {
            System.out.println(newStudentMyList.get(i).getName());
        }
    }
}
