package case_study.common.read_writer;

import case_study.model.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
            list.add(new Customer(arr[0], arr[1], arr[2],Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), arr[5], arr[6], arr[7], arr[8]));
        }
        return list;
    }
}
