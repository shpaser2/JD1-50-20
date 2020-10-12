package homework6;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int passwordsCompareResult = o1.getPassword().length()
            - o2.getPassword().length();
        if (passwordsCompareResult == 0) {
            return o1.getNick().compareToIgnoreCase(o2.getNick());
        } else {
            return passwordsCompareResult;
        }
    }
}
