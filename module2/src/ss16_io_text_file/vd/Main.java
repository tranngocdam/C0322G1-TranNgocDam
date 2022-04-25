package ss16_io_text_file.vd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void writeToFile(List<Student> students) {
        try {
            FileWriter fileWriter = new FileWriter("data.text");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Student s : students) {
                bufferedWriter.write(s.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {

        }
    }

    public List<Student> readFromFile() {
        List<Student>students=new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("data.text");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String txt[]=line.split(";");
                String name=txt[0];
                int age=Integer.parseInt(txt[1]);
                double mark=Double.parseDouble(txt[2]);
                students.add(new Student(name, age, mark));
            }
        } catch (Exception e) {
        }
        return students;
    }

    public static void main(String[] args) {
       Main m=new Main();
        List<Student> students =m.readFromFile();
        for (Student s: students) {
            System.out.println(s);
        }



    }
}
