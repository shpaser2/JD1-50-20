package generic.dataContainer;


import oop.calc.dto.ICalc;

public class SortMain {
    public static void main(String[] args) {
        //solution to escape NPE - 5 .add() for array.length = 5
        DataContainer<Integer> container = new DataContainer(new Integer[5]);
        SomeComparator comparator = new SomeComparator();
        BadComparator badComparator = new BadComparator();
        container.add(4);
        container.add(7);
        container.add(25);
        container.add(1);
        container.add(0);
        System.out.println(container.toString());
        container.sort(comparator);
        System.out.println(container.toString());
        
        DataContainer<ICalc> iCalcDataContainer =
                new DataContainer<>(new ICalc[10]);
//        DataContainer.sort(iCalcDataContainer);
        DataContainer.sort(container);
        
        
        
    }
}
