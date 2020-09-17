package generics;

import generics.dto.BoxNumber;

public class GenericMain5 {
    public static void main(String[] args) {
        BoxNumber<Number> box1 = new BoxNumber<>();

        box1.setItem(123);

        Number item = box1.getItem();
        Number item2 = box1.getItem();

        System.out.println(item);
        System.out.println(item2);
        System.out.println(item.doubleValue() + item2.doubleValue());
    }
}
