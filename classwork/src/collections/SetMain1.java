package collections;

import generics.BadComparator;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetMain1 {
    public static void main(String[] args) {
        Set<String> data1 = new TreeSet<>(new BadComparator().reversed());
        Set<String> data2 = new HashSet<>();
        data1.add("я");
        data1.add("ы");
        data1.add("а");

        data2.add("ы");
        data2.add("а");
        data2.add("я");

        System.out.println(data1);
        System.out.println(data2);
    }
}
