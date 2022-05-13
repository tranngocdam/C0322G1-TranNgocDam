package bai_thi.common.read_write;

import bai_thi.model.DienThoaiChinhHang;
import bai_thi.model.DienThoaiSachTay;
import case_study.model.Employee;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
    public static void writeToCSVDienThoaiChinhHang(List<DienThoaiChinhHang> dienThoaiChinhHangs, Boolean flag) {
        List<String> stringList = new ArrayList<>();
        for (DienThoaiChinhHang d: dienThoaiChinhHangs) {
            stringList.add(d.toString());
        }
        writeDataToCSV(stringList,"src/bai_thi/common/data/DienThoaiChinhHang.csv", flag);
    }
    public static void writeToCSVDienThoaiSachTay(List<DienThoaiSachTay> dienThoaiSachTays, Boolean flag) {
        List<String> stringList = new ArrayList<>();
        for (DienThoaiSachTay d1: dienThoaiSachTays) {
            stringList.add(d1.toString());
        }
        writeDataToCSV(stringList,"src/bai_thi/common/data/DienThoaiSachTay.csv", flag);
    }
}
