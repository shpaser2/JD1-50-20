package generics;

import generics.dto.BoxObject;
import oop.calc.dto.CalcWithOperator;
import oop.calc.dto.Fizik;

public class GenericMain1 {
    public static void main(String[] args) {
        BoxObject box1 = new BoxObject();

        box1.setItem("Привет Илья");
        box1.setItem(123);
        box1.setItem(new CalcWithOperator());

        System.out.println(box1.getItem());
    }
}
