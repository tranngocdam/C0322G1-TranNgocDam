package ss16_io_text_file.thuc_hanh.tim_gia_tri;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
//    public List<Integer> readFile(String filePath){
//        List<Integer> numbers = new ArrayList<>();
//        try {
//            File file = new File(filePath);
//
//            if (!file.exists()) {
//                throw new FileNotFoundException();
//            }
//
//            BufferedReader br = new BufferedReader(new FileReader(file));
//            String line = "";
//            while ((line = br.readLine()) != null) {
//                numbers.add(Integer.parseInt(line));
//            }
//            br.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.err.println("Fie không tồn tại or nội dung có lỗi!");
//        }
//        return numbers;
//    }
    public List<Integer> readFile(String filePath){
        List<Integer>list=new ArrayList<>();
        try {
            File file = new File(filePath);
            if(!file.exists()){
                throw new FileNotFoundException();
            }
            FileReader fileReader=new FileReader(filePath);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String line="";
            while ((line=bufferedReader.readLine())!=null){
                list.add(Integer.parseInt(line));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

//    public void writeFile(String filePath, int max){
//        try {
//            FileWriter writer = new FileWriter(filePath);
//            BufferedWriter bufferedWriter = new BufferedWriter(writer);
//            bufferedWriter.write("Giá trị lớn nhất là: " + max);
//            bufferedWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    public void writeFile(String filePath, int max){
        try {
            FileWriter fileWriter=new FileWriter(filePath);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            bufferedWriter.write("giá trị: "+max);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
