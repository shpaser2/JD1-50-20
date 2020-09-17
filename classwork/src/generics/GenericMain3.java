package generics;

import generics.dto.BoxGeneric;
import generics.dto.BoxGenericTwo;
import oop.calc.dto.ICalc;

public class GenericMain3 {
    public static void main(String[] args) {
        BoxGeneric<String> box1 = new BoxGeneric<>();

        box1.setItem("Привет Илья");

        System.out.println(box1.getItem());

        BoxGeneric<Integer> box2 = new BoxGeneric<>();

        box2.setItem(123);


        BoxGenericTwo<String, Integer> box3 = new BoxGenericTwo<>();

        box3.setItem("Привет Илья");
//        box3.setItemTwo(123);


        Object item = box3.getItem();
        String item1 = box3.getItem();
    }
}
