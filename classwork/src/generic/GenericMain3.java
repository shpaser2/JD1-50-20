package generic;

import generic.dto.BoxGeneric;
import generic.dto.BoxGenericTwo;

public class GenericMain3 {
    public static void main(String[] args) {
        //BoxGeneric<String> box1 = new BoxGeneric<String>(); for Java7 and
        // earlier
        BoxGeneric<String> box1 = new BoxGeneric<>();
        
        box1.setItem("Привет Илья");
        System.out.println(box1.getItem());
//        box1.setItem(123); //not work
    
        BoxGeneric<Integer> box2 = new BoxGeneric<>();
        box2.setItem(123);
        System.out.println(box2.getItem());
//        box2.setItem("Привет Илья"); //not work
    
        BoxGenericTwo<String, Integer> box3 = new BoxGenericTwo<>();
        
        box3.setItem("Привет Илья");
        box3.setItemTwo(123);
        
        Object item = box3.getItem();
        
    }
}
