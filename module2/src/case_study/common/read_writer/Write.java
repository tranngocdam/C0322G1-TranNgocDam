package case_study.common.read_writer;

import case_study.model.*;
import ss17_binary_file_serialization.bai_tap.model.Product;

import java.io.*;
import java.util.*;

public class Write {
    public static void writeDataToCSV(List<String> stringList, String pathFile, Boolean flag) {
        File file = new File(pathFile);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, flag);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (String string : stringList) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    public static void writeDataToCSV1(
//            Map<String, Integer> stringList, String pathFile, Boolean flag) {
//            File file = new File(pathFile);
//            FileWriter fileWriter = null;
//            BufferedWriter bufferedWriter = null;
//            try {
//                fileWriter = new FileWriter(file, flag);
//                bufferedWriter = new BufferedWriter(fileWriter);
//                for (String string : stringList.keySet()) {
//                    bufferedWriter.write(string);
//                    bufferedWriter.newLine();
//                }
//                bufferedWriter.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//    }
    public static void writeToCSVEmployee(List<Employee> employees, Boolean flag) {
        List<String> stringList = new ArrayList<>();
        for (Employee e:employees) {
            stringList.add(e.getIn());
        }
        writeDataToCSV(stringList,"src/case_study/common/data/employee.csv", flag);
    }
    public static void writeToCSVCustomer(List<Customer> customers, Boolean flag) {
        List<String> stringList = new LinkedList<>();
        for (Customer c: customers) {
            stringList.add(c.getCustomer());
        }
        writeDataToCSV(stringList,"src/case_study/common/data/customer.csv", flag);
    }
    public static void writeToCSVVilla(Map<Villa, Integer> villa, Boolean flag) {
        List<String>stringList=new ArrayList<>();
        for (Map.Entry<Villa,Integer> villaIntegerEntry:villa.entrySet()) {
            stringList.add(villaIntegerEntry.getKey().toString()+", "+villaIntegerEntry.getValue());
        }
        writeDataToCSV(stringList,"src/case_study/common/data/villa.csv", flag);
    }
    public static void writeToCSVRoom(Map<Room, Integer> room, Boolean flag) {
        List<String>stringList=new ArrayList<>();
        for (Map.Entry<Room,Integer>roomIntegerEntry:room.entrySet()) {
            stringList.add(roomIntegerEntry.getKey().toString()+", "+roomIntegerEntry.getValue());
        }
        writeDataToCSV(stringList,"src/case_study/common/data/room.csv", flag);
    }
    public static void writeToCSVHouse(Map<House, Integer> house, Boolean flag) {
        List<String>stringList=new ArrayList<>();
        for (Map.Entry<House,Integer>houseIntegerEntry:house.entrySet()) {
            stringList.add(houseIntegerEntry.getKey().toString()+", "+houseIntegerEntry.getValue());
        }
        writeDataToCSV(stringList,"src/case_study/common/data/house.csv", flag);
    }
}
