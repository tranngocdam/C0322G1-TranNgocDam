package ss5_access_modifier.bai_tap.build_class_in_java;

public class Student {
    private String name= "John";
    private String classes= "CO2";
    public Student(){
    }
    public String getName() {
        return name;
    }
    protected void setName(String name){
        this.name=name;
    }
     String getClasses() {
        return classes;
    }
     void setClasses(String classes) {
        this.classes = classes;
    }
    public String toString(){
        return  ""+name+
                "\n" +classes;
    }
}
