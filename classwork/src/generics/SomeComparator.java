package generics;

import java.io.Serializable;
import java.util.Comparator;

public class SomeComparator implements Comparator<Integer>, Serializable {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }
}
