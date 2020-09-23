package collections;

import java.util.ArrayList;
import java.util.List;

public class ListMain1 {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        data.add(10);
        data.add(189);
        data.add(1000);
        data.add(99);
        data.add(1000);
        data.add(1000);

        System.out.println(data);

        data.add(1, 789);

        System.out.println(data);

        Integer oldValue = data.set(1, 0);

        System.out.println(data);
        System.out.println(oldValue);

//        data.remove(1000);
        data.remove(Integer.valueOf(1000));

        System.out.println(data);

        int indexFirst = data.indexOf(1000);
        int indexLast = data.lastIndexOf(1000);
        if(indexFirst != indexLast){
            for (int i = indexFirst + 1; i < indexLast; i++) {

            }
        }
    }
}
