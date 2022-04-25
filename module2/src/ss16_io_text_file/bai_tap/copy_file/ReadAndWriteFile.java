package ss16_io_text_file.bai_tap.copy_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public List<String> readFile(String filePath){
        List<String>strings = new ArrayList<>();
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                strings.add(line);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
        return strings;
    }

    public void writeFile(String filePath, String str){
        try {
            FileWriter writer = new FileWriter(filePath,true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(str);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
