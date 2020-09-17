package oop;

import java.util.Comparator;

public class ManNameComparator implements Comparator<Man> {
    @Override
    public int compare(Man o1, Man o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
