import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
        students.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
        students.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội"));
        String path ="stu.datdeptroai";
        writeToFile(path,students);
        List<Student> list = readDataStuList(path);
        for (Student e: list
             ) {
            System.out.println(e);
        }
    }
    public static void writeToFile(String path, List<Student> students) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(students);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Student> readDataStuList(String path){
        List<Student> list = new ArrayList<>();
        try{
           ObjectInputStream ois =new ObjectInputStream(new FileInputStream(path));
           list = (List<Student>) ois.readObject();
           ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
