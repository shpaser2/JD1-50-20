package exceptions;

import oop.Man;

import java.util.ArrayList;
import java.util.List;

public class ExceptionsMain1 {
    public static void main(String[] args) {

//        List<Man> mans = new ArrayList<>(Integer.MAX_VALUE);

        List<Man> mans = null;
        try {
//            System.out.println(1 / 0);
//            mans = new ArrayList<>();
            mans = new ArrayList<>(Integer.MAX_VALUE);
            while (1 == 1){
                mans.add(new Man());
            }
        } catch (OutOfMemoryError error){
            System.out.println("Вай как плохо");
//            System.exit(789);
        }

//        if(mans != null){
//            System.out.println(mans.size());
//        } else {
//            System.out.println("Нет людей");
//        }

        try {
            System.out.println(mans.size());
        } catch (NullPointerException e){
            System.out.println("Нет людей");
        }

        System.out.println("Мы работаем!");
    }
}
