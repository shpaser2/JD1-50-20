package io;

import generics.SomeComparator;
import generics.dto.BoxObject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class IOMain4 {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("data.bin");
             ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeInt(12345);
            oos.writeObject("Today");
            oos.writeObject(new Date());

            BoxObject boxObject = new BoxObject();
            boxObject.setItem(new SomeComparator());

            oos.writeObject(boxObject);
        } catch (FileNotFoundException e){
            System.out.println("Что-то не так с файлом, " + e.getMessage());
        } catch (IOException e){
            System.out.println("Что-то совсем не так, " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
