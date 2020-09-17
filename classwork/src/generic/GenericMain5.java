package generic;

import generic.dto.BoxNumber;

public class GenericMain5 {
    
    public static void main(String[] args) {
        BoxNumber<Integer> box1 = new BoxNumber<>();
        //BoxNumber<String> box2 = new BoxNumber<>(); //not work
        box1.setItem(123);
        System.out.println(box1.getItem());
        
        
    }
}
