package bai_thi.common.read_write;

import bai_thi.model.DienThoaiChinhHang;
import bai_thi.model.DienThoaiSachTay;
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
    public static List<DienThoaiChinhHang> readToCSVDienThoaiChinhHang() {
        List<DienThoaiChinhHang>list=new ArrayList<>();
        List<String> stringList = readFileCsvToListString("src/bai_thi/common/data/DienThoaiChinhHang.csv");
        for (String item: stringList) {
            String[] arr=item.split(",");
            //list.add(new DienThoaiChinhHang();
        }
        return list;
    }
    public static List<DienThoaiSachTay> readToCSVDienThoaiSachTay() {
        List<DienThoaiSachTay>list=new ArrayList<>();
        List<String> stringList = readFileCsvToListString("src/bai_thi/common/data/DienThoaiSachTay.csv");
        for (String item: stringList) {
            String[] arr=item.split(",");
            //list.add(new DienThoaiSachTay(arr[0], arr[1], arr[2],Double.parseDouble(arr[3]), Integer.parseInt(arr[4]), arr[5], arr[6],Integer.parseInt(arr[7]));
        }
        return list;
    }

}
