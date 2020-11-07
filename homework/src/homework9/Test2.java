package homework9;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import static homework8.SiteLoader.service.FilesHandling.getPathToSrcDir;

public class Test2 {
    public static void main(String[] args) {
        //5. В новом классе прочитать этот файл и вывести последние N студентов.
        Test2 test = new Test2();
        String pathToSrcDir = getPathToSrcDir(test);
        String pathToTopStudents = pathToSrcDir + File.separator
                + "topStudents.bin";
        int topStudentsAmount = 20;
        ArrayList<Student> topStudents = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(pathToTopStudents))) {
            for (int i = 0; i < topStudentsAmount; i++) {
                topStudents.add(i, (Student) ois.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(topStudents.toArray()));
    }
}
