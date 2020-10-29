package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class IOMain3 {
    public static void main(String[] args) {
        String path = ".." + File.separator + ".." + File.separator + ".." + File.separator + "file.txt";
        File file = new File(path);
        System.out.println(file.exists());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){
            long start = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                writer.write("1");
//                writer.flush();
//                if(i == 9999){
//                    throw new IllegalArgumentException("У нас всё очень плохо. Препод не знает о чём рассказывает");
//                }
            }
            long finish = System.currentTimeMillis();
            System.out.println(finish - start);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
