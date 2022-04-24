package ss16_IO_text_file.bai_tap.copy_file;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<String> strings = readAndWriteFile.readFile("src/ss16_IO_text_file/bai_tap/copy_file/source.txt");
        int count=0;
        for (String s:strings) {
            count+=s.length();
            readAndWriteFile.writeFile("src/ss16_IO_text_file/bai_tap/copy_file/target.txt", s);
        }
        System.out.println(count);
    }
}
