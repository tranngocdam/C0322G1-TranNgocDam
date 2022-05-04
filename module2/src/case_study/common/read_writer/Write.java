package case_study.common.read_writer;

import case_study.model.Customer;
import case_study.model.Employee;
import case_study.model.Facility;
import case_study.model.Villa;
import ss17_binary_file_serialization.bai_tap.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

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
    public static void writeToCSVEmployee(List<Employee> employees, Boolean flag) {
        List<String> stringList = new ArrayList<>();
        for (Employee e:employees) {
            stringList.add(e.getIn());
        }
        writeDataToCSV(stringList,"src/case_study/common/data/employee.csv", flag);
    }
    public static void writeToCSVCustomer(List<Customer> customers, Boolean flag) {
        List<String> stringList = new ArrayList<>();
        for (Customer c: customers) {
            stringList.add(c.getCustomer());
        }
        writeDataToCSV(stringList,"src/case_study/common/data/customer.csv", flag);
    }
//    public static void writeToCSVVilla(LinkedHashMap<Villa, Integer> villa, Boolean flag) {
//        LinkedHashMap<String, Integer> stringList = new LinkedHashMap<>();
//        for (Villa v: villa) {
//            stringList.put(v.toString(), 1);
//        }
//        //writeDataToCSV(stringList,"src/case_study/common/data/villa.csv", flag);
//    }
}
