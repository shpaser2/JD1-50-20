package collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListMain4 {
    public static void main(String[] args) {
        List<Integer> data = new LinkedList<>();
    
        for (int i = 0; i < 1001; i++) {
            data.add(i);
        }
    
        System.out.println(data);
    
        Iterator<Integer> iterator = data.iterator();
        //not ok
//        data.add(55555);
        //ok
//        data.set(3, 5555);
        //not ok
//        data.remove(1000);
//        data.add(9999);
        //have no influence on iterator
        data = new LinkedList<>();
        
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
