package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class IOMain2 {
    public static void main(String[] args) {
        BufferedWriter writer = null;
        try {
            String path = ".." + File.separator + ".." + File.separator + ".." + File.separator + "file.txt";
            writer = new BufferedWriter(new FileWriter(path));

            long start = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                writer.write("1");
//                writer.flush();
                if(i == 9999){
                    throw new IllegalArgumentException("У нас всё очень плохо. Препод не знает о чём рассказывает");
                }
            }
            long finish = System.currentTimeMillis();
            System.out.println(finish - start);
        } catch (IOException e){
            System.out.println(e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e){
                    System.out.println("Всё ну очень плохо");
                }
            }
        }
    }
}
