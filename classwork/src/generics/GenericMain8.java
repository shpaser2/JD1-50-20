package generics;

import oop.IPhone;
import oop.Man;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Supplier;

public class GenericMain8 {
    public static void main(String[] args) {
        Collection<Man> data1 = new ArrayList<>();


        job(data1, Man::new, 10000);

        sort(data1, Sorts::sortByName);
        sort(data1, Sorts::sortByYearOld);
    }

    public static <T> void sort(Collection<T> data, Comparator<T> comparator){
        Iterator<T> iterator = data.iterator();
        while (iterator.hasNext()){
            T left = iterator.next();
            T right = iterator.next();
            if(comparator.compare(left, right) > 1){

            }
        }
    }

    public static <T> void job(Collection<T> data, Supplier<T> supplier, int count){
        Generator.generator(data, supplier, count);
        Iterator<T> iterator = data.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
