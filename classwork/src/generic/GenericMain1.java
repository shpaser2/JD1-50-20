package generic;

//import homework.homework3.CalculatorWithOperator;
import generic.dto.BoxObject;

public class GenericMain1 {
    
    public static void main(String[] args) {
        BoxObject box1 = new BoxObject();
        
        box1.setItem("Привет Илья");
        String item1 = (String) box1.getItem();
        System.out.println(item1);
        
        box1.setItem(123);
        int item2 = (int) box1.getItem();
        System.out.println(item2);
        //box1.setItem(new Calculator());
        
    
        System.out.println(box1.getItem());
    }
}
