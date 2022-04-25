package ss17_binary_file_serialization.bai_tap.common.read_write;

import ss17_binary_file_serialization.bai_tap.model.Product;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class WriteAndRead {
    public static List<Product> readFile(){
        List<Product>products= new ArrayList<>();
        try {
            FileInputStream fileInputStream=new FileInputStream("src/ss17_binary_file_serialization/bai_tap/common/data/data.txt");
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            products=(List<Product>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return products;
    }
    public static void WriteFile(List<Product> products){
        try {
            FileOutputStream fileOutputStream=new FileOutputStream("src/ss17_binary_file_serialization/bai_tap/common/data/data.txt");
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(products);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
