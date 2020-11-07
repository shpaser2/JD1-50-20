package homework9;

import java.util.Comparator;

public class MarksComparator implements Comparator<Student> {

    /**
     * Для сортировки от большего к меньшему - в убывающем порядке.
     */
    @Override
    public int compare(Student o1, Student o2) {
        return o2.getMark() - o1.getMark();
    }
}
