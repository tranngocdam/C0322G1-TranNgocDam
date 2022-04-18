package ss12_map_tree.bai_tap;

import bai_tap_oop.service.impl.OtoServiceImpl;
import ss12_map_tree.ProduceService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager implements ProduceService {
    private static Scanner scanner=new Scanner(System.in);
    private static List<Produce>produces=new ArrayList<>();
    static {
        produces.add(new Produce("12", "kẹo", 12000));
        produces.add(new Produce("89", "bánh", 98000));
        produces.add(new Produce("76", "snack", 67110));
    }
    public void themMoi(){
        System.out.println("Nhập id: ");
        String id=scanner.nextLine();
        System.out.println("Nhập tên sản phẩm: ");
        String tenSanPham=scanner.nextLine();
        System.out.println("Nhập giá cả: ");
        double giaCa=Double.parseDouble(scanner.nextLine());
        Produce produce=new Produce(id, tenSanPham, giaCa);
        produces.add(produce);
    }
    public void hienThi(){
        for (Produce produce:produces) {
            System.out.println(produce);
        }
    }

    @Override
    public void sua() {

    }

    @Override
    public void xoa() {
        System.out.println("Nhập id sản phẩm: ");
        String id=scanner.nextLine();
        for (int i = 0; i <produces.size() ; i++) {
            if(id.equals(produces.get(i).getId())){
                produces.remove(i);
                break;
            }

        }
    }

    @Override
    public void timKiem() {
        System.out.println("Nhập tên sản phẩm: ");
        String nameProduce=scanner.nextLine();
        for (int i = 0; i <produces.size() ; i++) {
            if(nameProduce.equals(produces.get(i).getNameProduce())){
                System.out.println(produces.get(i));
                break;
            }
        }
    }
}
