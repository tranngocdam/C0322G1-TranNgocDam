package ss12_map_tree.bai_tap.service.impl;

import ss12_map_tree.bai_tap.service.CompatorProduce;
import ss12_map_tree.bai_tap.model.Produce;
import ss12_map_tree.bai_tap.service.ProduceService;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ProductManager implements ProduceService {
    private static Scanner scanner=new Scanner(System.in);
    private static List<Produce>produces=new LinkedList<>();
    static {
        produces.add(new Produce("12", "kẹo", 12000));
        produces.add(new Produce("89", "bánh", 98000));
        produces.add(new Produce("76", "snack", 67110));
    }
    public void themMoi(){
        System.out.print("Nhập id: ");
        String id=scanner.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        String tenSanPham=scanner.nextLine();
        System.out.print("Nhập giá cả: ");
        int giaCa=Integer.parseInt(scanner.nextLine());
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
        System.out.print("Nhập id: ");
        String id=scanner.nextLine();
        boolean check=false;
        int index=-1;
        for (int i = 0; i < produces.size() ; i++) {
            if(id.equals(produces.get(i).getId())){
                check=true;
                index=i;
                break;
            }
        }
        if(check==false){
            System.out.println("id không tồn tại");
            return;
        }
        System.out.print("Nhập tên sản phẩm: ");
        String tenSanPham=scanner.nextLine();
        System.out.print("Nhập giá cả: ");
        int giaCa=Integer.parseInt(scanner.nextLine());
        Produce produce=new Produce(id, tenSanPham, giaCa);
        produces.set(index,produce);
    }

    @Override
    public void xoa() {
        System.out.print("Nhập id sản phẩm: ");
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
        boolean check=false;
        System.out.print("Nhập tên sản phẩm: ");
        String nameProduce=scanner.nextLine();
        for (int i = 0; i <produces.size() ; i++) {
            if(nameProduce.equals(produces.get(i).getNameProduce())){
                System.out.println(produces.get(i));
                check=true;
                break;
            }
        }
        if(check==false){
            System.out.println("Không có sản phẩm");
        }
    }

    @Override
    public void sapXep() {
        System.out.println("Chọn chức năng:\n" +
                "1. tăng dần\n" +
                "2. giảm dần");
        int choice=Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                Collections.sort(produces, new CompatorProduce());
                break;
            case 2:
                Collections.sort(produces, new CompatorProduce());
                Collections.reverse(produces);
                break;
        }
    }
}
