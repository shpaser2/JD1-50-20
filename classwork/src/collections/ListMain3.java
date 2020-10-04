package collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListMain3 {
    public static void main(String[] args) {
        List<Integer> data = new LinkedList<>();
    
        for (int i = 0; i < 1001; i++) {
            data.add(i);
        }
    
        System.out.println(data);
    
        Iterator<Integer> iterator = data.iterator();
        
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    
        System.out.println("__________________");
        
        iterator = data.iterator();
//        while (true) {
        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//            //next line use sequence of two elements instead of one element
//            System.out.println(iterator.next() + iterator.next());
            Integer next = iterator.next();
            System.out.println(next + next);
        }
    }
}
