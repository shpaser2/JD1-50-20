package homework6;

import java.util.Comparator;

public class AnimalComparator implements Comparator<Animal> {

    @Override
    public int compare(Animal o1, Animal o2) {
        int ageCompareResult = o1.getAge() - o2.getAge();
        if (ageCompareResult == 0) {
            return o1.getNick().compareToIgnoreCase(o2.getNick());
        } else {
            return ageCompareResult;
        }
    }
}
