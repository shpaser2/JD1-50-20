package collections;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetMain5 {
    public static void main(String[] args) {
        Set<String> data = new LinkedHashSet<>();
        boolean answ1 = data.add(new String("Привет"));
        boolean answ2 = data.add(new String("Пока"));
        boolean answ3 = data.add(new String("Привет"));

        System.out.println(answ1);
        System.out.println(answ2);
        System.out.println(answ3);

        System.out.println(data);

        Iterator<String> iterator = data.iterator();
    }
}
