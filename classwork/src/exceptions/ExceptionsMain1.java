package exceptions;

import oop.Man;

import java.util.ArrayList;
import java.util.List;

public class ExceptionsMain1 {
    public static void main(String[] args) {
        //List<Man> mans = new ArrayList<>(Integer.MAX_VALUE);
        List<Man> mans = new ArrayList<>();
        List<Long> longs = new ArrayList<>();
//        while (1 == 1) {
//            mans.add(new Man());
//        }
        
        try {
//            List<Man> mans = new ArrayList<>(Integer.MAX_VALUE);
            while (1 == 1) {
//                mans.add(new Man());
                longs.add(10L);
            }
        } catch (OutOfMemoryError error) {
            System.out.println("поломалось");
//            System.exit(789);
        }
        System.out.println(longs.size());
        System.out.println("Мы работаем!");
    }
}
