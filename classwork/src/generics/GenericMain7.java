package generics;

import oop.Man;
import oop.ManNameComparator;

public class GenericMain7 {
    public static void main(String[] args) {
        Man man1 = new Man("Илья", 123);
        Man man2 = new Man("ИльЯ", 12);

        System.out.println(man1.compareTo(man2));
        System.out.println(man2.compareTo(man1));

        ManNameComparator manNameComparator = new ManNameComparator();
        System.out.println(manNameComparator.compare(man1, man2));
        System.out.println(man1.getName().compareTo(man2.getName()));
    }
}
