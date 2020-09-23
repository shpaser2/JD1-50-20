package generics;

import oop.calc.dto.ICalc;

public class SortMain {
    public static void main(String[] args) {
        SomeComparator comparator = new SomeComparator();
        BadComparator badComparator = new BadComparator();
        DataContainer<Integer> container = new DataContainer(new Integer[5]);
        container.add(4);
        container.add(7);
        container.add(25);
        container.add(1);
        container.add(0);
        System.out.println(container.toString());
        container.sort(comparator);
//        container.sort(badComparator);
        System.out.println(container.toString());

        DataContainer<ICalc> iCalcDataContainer = new DataContainer<>(new ICalc[10]);
//        generics.DataContainer.sort(iCalcDataContainer);
        DataContainer.sort(container);
        DataContainer.sort(container, comparator);
    }
}
