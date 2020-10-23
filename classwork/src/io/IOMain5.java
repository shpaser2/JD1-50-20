package io;

import generics.dto.BoxObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;

public class IOMain5 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("data.bin");
            ObjectInputStream ois = new ObjectInputStream(fis)){
            int i = ois.readInt();
            String today = (String) ois.readObject();
            Date date = (Date) ois.readObject();

            BoxObject box = (BoxObject) ois.readObject();

            System.out.println(i);
            System.out.println(today);
            System.out.println(date);
            System.out.println(box);
            System.out.println(box.getItem());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
