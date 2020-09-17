package generics;

import generics.dto.BoxObject;
import oop.calc.dto.ICalc;

public class GenericMain2 {
    public static void main(String[] args) {
        BoxObject box1 = new BoxObject();

        box1.setItem("Привет Илья");

        Object item = box1.getItem();

        String item1 = (String) box1.getItem();

        System.out.println(item1);

        box1.setItem(123);

        int item2 = (int) box1.getItem();

        System.out.println(item2);
    }
}
