package case_study.common.read_writer;

import case_study.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Read {
    private static List<String> readFileCsvToListString(String pathFile) {
        List<String> stringList = new ArrayList<>();
        File file = new File(pathFile);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }
    public static List<Customer> readToCSVCustomer() {
        List<Customer>list=new ArrayList<>();
        List<String> stringList = readFileCsvToListString("src/case_study/common/data/customer.csv");
        for (String item: stringList) {
            String[] arr=item.split(",");
            //list.add(new Customer(arr[0], arr[1], arr[2],Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), arr[5], arr[6], arr[7], arr[8]));
        }
        return list;
    }
    public static List<Employee> readToCSVEmployee() {
        List<Employee>list=new ArrayList<>();
        List<String> stringList = readFileCsvToListString("src/case_study/common/data/employee.csv");
        for (String item: stringList) {
            String[] arr=item.split(",");
            list.add(new Employee(arr[0], arr[1], arr[2],Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), arr[5], arr[6], arr[7], arr[8], Double.parseDouble(arr[9])));
        }
        return list;
    }
    public static Map<Villa, Integer> readToCSVVilla() {
        List<String> stringList = readFileCsvToListString("src/case_study/common/data/villa.csv");
        Map<Villa, Integer> villaIntegerLinkedHashMap=new LinkedHashMap<>();
        for (String item: stringList) {
            String[] arr=item.split(",");
//            String maDichVu, String tenDichVu, Double dienTichSuDung, Double chiPhiThue, Integer soLuongNguoi, String kieuThue, String tieuChuanPhong, Double dienTichHoBoi, Integer soTang
            villaIntegerLinkedHashMap.put(new Villa(arr[0], arr[1], Double.parseDouble(arr[2]), Double.parseDouble(arr[3]), Integer.parseInt(arr[4]), arr[5], arr[6],  Double.parseDouble(arr[7]), Integer.parseInt(arr[8])),Integer.parseInt(arr[9]));
        }
        return villaIntegerLinkedHashMap;
    }
    public static Map<Room, Integer> readToCSVRoom() {
        List<String> stringList = readFileCsvToListString("src/case_study/common/data/room.csv");
        Map<Room, Integer> roomIntegerLinkedHashMap=new LinkedHashMap<>();
        for (String item: stringList) {
            String[] arr=item.split(",");
            //String maDichVu, String tenDichVu, Double dienTichSuDung, Double chiPhiThue, Integer soLuongNguoi, String kieuThue, String dichVuMienPhi
            roomIntegerLinkedHashMap.put(new Room(arr[0], arr[1], Double.parseDouble(arr[2]), Double.parseDouble(arr[3]), Integer.parseInt(arr[4]), arr[5], arr[6]),Integer.parseInt(arr[7]));
        }
        return roomIntegerLinkedHashMap;
    }
    public static Map<House, Integer> readToCSVHouse(){
        List<String>stringList=readFileCsvToListString("src/case_study/common/data/house.csv");
        Map<House, Integer> houseIntegerMap=new LinkedHashMap<>();
        for (String item: stringList) {
            String[] arr=item.split(",");
            //String maDichVu, String tenDichVu, Double dienTichSuDung, Double chiPhiThue, Integer soLuongNguoi, String kieuThue, String tieuChuanPhong, Integer soTang
            houseIntegerMap.put(new House(arr[0], arr[1], Double.parseDouble(arr[2]),Double.parseDouble(arr[3]),Integer.parseInt(arr[4]), arr[5], arr[6], Integer.parseInt(arr[7])),Integer.parseInt(arr[8]));
        }
        return houseIntegerMap;
    }
}
