package homework4;

import java.util.Arrays;

public class DataContainerMain {
    public static void main(String[] args) {
        DataContainer<Integer> numbers = new DataContainer<>();
        numbers.add(12);
        numbers.add(13);
        numbers.add(14);
        numbers.add(15);

        numbers.print();

        System.out.println(numbers.delete(2));
        System.out.println(numbers.delete(17));

        numbers.print();

        numbers.add(17);
        System.out.println(numbers.delete((Integer) 20));
        System.out.println(numbers.delete((Integer) 12));

        numbers.print();


//        Integer ig = 10;
//        Object obj = (Object)ig;
//        Integer ig1 = (Integer) obj;
//        System.out.println(((Integer)obj).doubleValue());
//        System.out.println(ig1.doubleValue());
    }


}
