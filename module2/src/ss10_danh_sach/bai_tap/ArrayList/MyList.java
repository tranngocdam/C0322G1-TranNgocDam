package ss10_danh_sach.bai_tap.ArrayList;
import java.util.Arrays;
public class MyList<E> {
    //tạo thuộc tính: size ,DEFAULT_CAPACITY, Object elements[]
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    Object elements[];

    //tạo constructor không tham số
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    //tạo constructor có tham số là sức chứa truyền vào =10
    public MyList(int capacity) {
        if (capacity >= 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("capactity: " + capacity);
        }
    }

    //thêm phần tử vào my list theo chỉ định
    public void add(E element, int index) {
        if (index > elements.length) {
            throw new IllegalArgumentException("index: " + index);
        } else if (elements.length == size) {
            this.ensureCapacity(5);
        }

        //nếu vị trí của phần tử trong mảng không có giá trị
        // thì thêm phần tử đó vào ví trí đó
        if (elements[index] == null) {
            elements[index] = element;
            size++;
        } else {
            for (int i = size + 1; i >= index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            size++;
        }

    }

    public E remove(int index) {
        if (index < 0 || index > elements.length){
            throw new IllegalArgumentException("error index: "+ index);
        }
        E element=(E) elements[index];
        for (int i = index; i < size-1; i++) {
            elements[i]=elements[i+1];
        }
        elements[size-1]=null;
        size--;
        return element;
    }

    //phương thức trả về số lượng
    public int size() {
        return this.size;
    }

    //sao chép 1 mảng mới
    public MyList<E> clone() {
        MyList<E> v = new MyList<>();
        v.elements = Arrays.copyOf(this.elements, this.size);
        v.size = this.size;
        return v;
    }

    //kiểm tra phần tử có trong mảng hay không
    public boolean contains(E element) {
        return this.indexOf(element) >= 0;
    }


    //phương thức lấy index của 1 phần tử trong mảng
    public int indexOf(E element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (this.elements[i].equals(element)) {
                return i;
            }
        }
        return index;
    }


    //    phương thức thêm 1 phần tử  vào mylist
    public boolean add(E element) {
        if (elements.length == size) {
            this.ensureCapacity(5);
        }
        elements[size] = element;
        size++;
        return true;
    }

    //phương thức tăng kích thước cho mảng và copy phần tử mảng cũ vào mảng mới
    public void ensureCapacity(int minCapacity) {
        if (minCapacity >= 0) {
            int newSize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
        } else {
            throw new IllegalArgumentException("minCaparacity:" + minCapacity);
        }
    }

    //phương thức xóa phẩn tử trong mảng
    public void clear() {
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }

    //phương thức lấy 1 phần tử tại ví trí index
    public E get(int index) {
        return (E) elements[index];
    }
}
