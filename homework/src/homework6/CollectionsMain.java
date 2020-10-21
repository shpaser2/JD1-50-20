/*
 * Сергей Шпаковский
 *
 * Это программное обеспечение является публичной и открытой
 * информацией.
 *
 * АВТОР НЕ ДАЁТ НИКАКИХ ГАРАНТИЙ, ЯВНЫХ ИЛИ КОСВЕННЫХ (ВКЛЮЧАЯ - НО
 * НЕ ОГРАНИЧИВАЯСЬ ИМИ - ГАРАНТИИ РЕАЛИЗУЕМОСТИ), СООТВЕТСТВИЯ
 * ОПРЕДЕЛЁННОМУ НАЗНАЧЕНИЮ ИЛИ НЕНАРУШЕНИЯ УСЛОВИЙ, ЧТО СОДЕРЖИМОЕ
 * ДАННОГО ФАЙЛА ПОДХОДИТ ДЛЯ КАКИХ-ЛИБО ЦЕЛЕЙ ИЛИ ЧТО ЛЮБОЕ
 * ИСПОЛЬЗОВАНИЕ ИЛИ РЕАЛИЗАЦИЯ ТАКОГО СОДЕРЖИМОГО НЕ БУДЕТ НАРУШАТЬ
 * КАКИХ-ЛИБО ПАТЕНТОВ ТРЕТЬЕЙ СТОРОНЫ, АВТОРСКИХ ПРАВ, КОММЕРЧЕСКОЙ
 * ТАЙНЫ ИЛИ ИНЫХ ПРАВ.
 */
package homework6;

import collections.utils.RandomString;
import homework6.service.*;
import java.util.*;

/**
 * Класс пример работы с коллекциями и компараторами
 * @author Шпаковский Сергей
 * @version 0.4 22-10-2020
 */
public class CollectionsMain {
    private final static int PASSWORD_LENGTH = 15;
    private final static int MIN_PASSWORD_LENGTH = 5;
    private final static int NAME_LENGTH = 10;
    private final static int ANIMAL_MAX_AGE = 20;
    private final static int OBJECTS_AMOUNT = 100_000;

    /**
     * Точка входа программы.
     * @param args аргументы при запуске.
     */
    public static void main(String[] args) {
        allWorkWithPersons();
        allWorkWithAnimals();
    }

    /**
     * Все действия производимые с классом Person
     * - сортировки различных коллекций, итерирование, удаление
     * с измерением длительности выполнения в миллисекундах.
     */
    private static void allWorkWithPersons() {
        System.out.println(" ***** действия с Person ***** ");
        long startTime;
        long stopTime;
        //3.1 При помощи рандома генерируем 100_000 разных объектов
        // одного класса.
        HashSet<Person> perons = new HashSet<>(OBJECTS_AMOUNT);
        createPersons(perons);

        //3.2.1. Заполняем LinkedList
        startTime = System.currentTimeMillis();
        LinkedList<Person> personLinkedList = new LinkedList<>(perons);
        stopTime = System.currentTimeMillis();

        //3.4.1 Время заполнения коллекции LinkedList
        printOperationCollectionNameTime("заполнение",
                personLinkedList, startTime, stopTime);

        //3.2.2. Заполняем ArrayList
        startTime = System.currentTimeMillis();
        ArrayList<Person> personArrayList = new ArrayList<>(perons);
        stopTime = System.currentTimeMillis();

        //3.4.1 Время заполнения коллекции ArrayList
        printOperationCollectionNameTime("заполнение",
                personArrayList, startTime, stopTime);

        //3.2.3. Заполняем HashSet
        startTime = System.currentTimeMillis();
        HashSet<Person> personHashSet = new HashSet<>(perons);
        stopTime = System.currentTimeMillis();

        //3.4.1 Время заполнения коллекции HashSet
        printOperationCollectionNameTime("заполнение",
                personHashSet, startTime, stopTime);

        //3.2.4. Заполняем TreeSet
        startTime = System.currentTimeMillis();
        TreeSet<Person> personTreeSet = new TreeSet<>(perons);
        stopTime = System.currentTimeMillis();

        //3.4.1 Время заполнения коллекции TreeSet
        printOperationCollectionNameTime("заполнение",
                personTreeSet, startTime, stopTime);

        //создание копий для сортировок
        LinkedList<Person> personLinkedListCopy =
                new LinkedList<>(personLinkedList);
        ArrayList<Person> personArrayListCopy =
                new ArrayList<>(personArrayList);
        HashSet<Person> personHashSetCopy = new HashSet<>(personHashSet);
        TreeSet<Person> personTreeSetCopy = new TreeSet<>(personTreeSet);

        //3.3.1. Сортируем коллекции встроенными средствами jdk
        PersonComparator personComparator = new PersonComparator();
        sortPersonsWithTime(personArrayList, personComparator);
        sortPersonsWithTime(personLinkedList, personComparator);
        sortPersonsWithTime(personHashSet, personComparator);
        sortPersonsWithTime(personTreeSet, personComparator);
        //Альтернативные сортировки стандартными средствами с помощью лямбд
//        personHashSet.stream().sorted(personComparator)
//                .forEach(s -> System.out.print(s));
//        personTreeSet.stream().sorted(personComparator)
//                .forEach(s -> System.out.print(s));

        //3.3.2.* Сортируем коллекции собственным методом сортировки
        mySortPersonsWithTime(personLinkedListCopy, personComparator);
        mySortPersonsWithTime(personArrayListCopy, personComparator);
        mySortPersonsWithTime(personHashSetCopy, personComparator);
        mySortPersonsWithTime(personTreeSetCopy, personComparator);
        //  3.4.2. Итерирования коллекции:
        //  3.4.2.1. При помощи iterator
        iterThroughList(personArrayList);
        //  3.4.2.2. При помощи любого другого способа (не foreach)
        forThroughList(personArrayList);
        //  3.4.3. Удаления всех элементов коллекции (выбрать один из):
        //  3.4.3.1. При помощи iterator
        deleteAll(personArrayList);
        //  3.4.3.2. При помощи любого другого способа
        deleteAllListWithTime(personLinkedList);
    }

    /**
     * Все действия производимые с классом Animal
     * - сортировки различных коллекций, итерирование, удаление
     * с измерением длительности выполнения в миллисекундах.
     */
    private static void allWorkWithAnimals() {
        System.out.println(" ***** действия с Animal ***** ");
        long startTime;
        long stopTime;
        //3.1 При помощи рандома генерируем 100_000 разных объектов
        // одного класса.
        HashSet<Animal> animals = new HashSet<>(OBJECTS_AMOUNT);
        createAnimals(animals);

        //3.2.1. Заполняем LinkedList
        startTime = System.currentTimeMillis();
        LinkedList<Animal> animalLinkedList = new LinkedList<>(animals);
        stopTime = System.currentTimeMillis();

        //3.4.1 Время заполнения коллекции LinkedList
        printOperationCollectionNameTime("заполнение",
                animalLinkedList, startTime, stopTime);

        //3.2.2. Заполняем ArrayList
        startTime = System.currentTimeMillis();
        ArrayList<Animal> animalArrayList = new ArrayList<>(animals);
        stopTime = System.currentTimeMillis();

        //3.4.1 Время заполнения коллекции ArrayList
        printOperationCollectionNameTime("заполнение",
                animalArrayList, startTime, stopTime);

        //3.2.3. Заполняем HashSet
        startTime = System.currentTimeMillis();
        HashSet<Animal> animalHashSet = new HashSet<>(animals);
        stopTime = System.currentTimeMillis();

        //3.4.1 Время заполнения коллекции HashSet
        printOperationCollectionNameTime("заполнение",
                animalHashSet, startTime, stopTime);

        //3.2.4. Заполняем TreeSet
        startTime = System.currentTimeMillis();
        TreeSet<Animal> animalTreeSet = new TreeSet<>(animals);
        stopTime = System.currentTimeMillis();

        //3.4.1 Время заполнения коллекции TreeSet
        printOperationCollectionNameTime("заполнение",
                animalTreeSet, startTime, stopTime);

        //создание копий для сортировок
        LinkedList<Animal> animalLinkedListCopy =
                new LinkedList<>(animalLinkedList);
        ArrayList<Animal> animalArrayListCopy =
                new ArrayList<>(animalArrayList);
        HashSet<Animal> animalHashSetCopy = new HashSet<>(animalHashSet);
        TreeSet<Animal> animalTreeSetCopy = new TreeSet<>(animalTreeSet);

        //3.3.1. Сортируем коллекции встроенными средствами jdk
        AnimalComparator animalComparator = new AnimalComparator();
        sortWithTime(animalArrayList, animalComparator);
        sortWithTime(animalLinkedList, animalComparator);
        sortWithTime(animalHashSet, animalComparator);
        sortWithTime(animalTreeSet, animalComparator);
        //Альтернативные сортировки стандартными средствами с помощью лямбд
//        animalHashSet.stream().sorted(animalComparator)
//                .forEach(s -> System.out.print(s));
//        animalTreeSet.stream().sorted(animalComparator)
//                .forEach(s -> System.out.print(s));

        //3.3.2.* Сортируем коллекции собственным методом сортировки
        mySortWithTime(animalLinkedListCopy, animalComparator);
        mySortWithTime(animalArrayListCopy, animalComparator);
        mySortWithTime(animalHashSetCopy, animalComparator);
        mySortWithTime(animalTreeSetCopy, animalComparator);
        //  3.4.2. Итерирования коллекции:
        //  3.4.2.1. При помощи iterator
        iterThroughList(animalArrayList);
        //  3.4.2.2. При помощи любого другого способа (не foreach)
        forThroughList(animalArrayList);
        //  3.4.3. Удаления всех элементов коллекции (выбрать один из):
        //  3.4.3.1. При помощи iterator
        deleteAll(animalArrayList);
        //  3.4.3.2. При помощи любого другого способа
        deleteAllListWithTime(animalLinkedList);
    }

    /**
     * Вывод соощения о длительности операции над переданной
     * коллекцией на основании переданного времени начала операции,
     * окончания операции, краткого пояснения операции, коллекции
     * с которой работали.
     * Вывод в формате "Операция: ХХХХ. Заняла YYYY мс"
     * где ХХХХ - пояснение операции и название коллекции,
     * YYYY - длительность операции в миллисекундах.
     * @param operationName пояснение к операции.
     * @param c коллекция, название которой будет после пояснения.
     * @param start время старта операции в миллисекундах с помощью
     *              System.currentTimeMillis().
     * @param stop  время окончания операции в миллисекундах с помощью
     *              System.currentTimeMillis().
     */
    private static void printOperationCollectionNameTime(String operationName,
                                                  Collection c, long start,
                                                  long stop) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Операция: ").append(operationName).append(" ")
                .append(c.getClass().getName().substring(10))
                .append(". Заняла ").append(stop - start).append(" мс");
        System.out.println(stringBuffer.toString());
    }

    /**
     * Итерирование всей коллекции типа List или наследника List
     * с замером времени в миллисекундах.
     * @param list коллекция для итерирования.
     */
    private static void iterThroughList(List list) {
        long startTime;
        long stopTime;
        startTime = System.currentTimeMillis();
        Iterator<Animal> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        stopTime = System.currentTimeMillis();
        printOperationCollectionNameTime(
                "итерирования c Iterator коллекции",
                list, startTime, stopTime);
    }

    /**
     * Итерирование коллекции без использования итератора или foreach
     * с замером времени выполниния от начала до конца.
     * @param list коллекция для итерирования.
     */
    private static void forThroughList(List list) {
        long startTime;
        long stopTime;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        stopTime = System.currentTimeMillis();
        printOperationCollectionNameTime(
                "итерирования коллекции без foreach",
                list, startTime, stopTime);
    }

    /**
     * Удаление всех элементов коллекции типа List или его наследника
     * с помощью стандартной функции.
     * @param list коллекция в которой будут удалены элементы.
     */
    private static void deleteAllListWithTime(List list) {
        long startTime;
        long stopTime;
        startTime = System.currentTimeMillis();
        list.clear();
        stopTime = System.currentTimeMillis();
        printOperationCollectionNameTime(
                "удаление с .clear() всех элементов в",
                list, startTime, stopTime);
    }

    /**
     * Удаление всех элементов коллекции типа List или его наследника
     * с использованием итератора.
     * @param c коллекция в которой будут удалены элементы.
     */
    private static void deleteAll(Collection c) {
        long startTime;
        long stopTime;
        Iterator iterator = c.iterator();
        startTime = System.currentTimeMillis();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        stopTime = System.currentTimeMillis();
        printOperationCollectionNameTime(
                "удаление с Iterator всех элементов в",
                c, startTime, stopTime);
    }

    /**
     * Генерирует указанное в константе OBJECTS_AMOUNT количество
     * уникальных объектов Person с указанными в константах лимитами
     * длины пароля (PASSWORD_LENGTH и MIN_PASSWORD_LENGTH)
     * и длины имени (NAME_LENGTH).
     * @param persons коллекция в которую будет записано
     *                OBJECTS_AMOUNT объектов Person.
     */
    private static void createPersons(Set<Person> persons) {
        int bound = PASSWORD_LENGTH - MIN_PASSWORD_LENGTH;
        Random random = new Random();
        while (persons.size() != OBJECTS_AMOUNT) {
            persons.add(new Person(RandomString.nextString(NAME_LENGTH),
                    RandomString.nextString(random.nextInt(bound)
                            + MIN_PASSWORD_LENGTH)));
        }
    }

    /**
     * QuickSort сортировка копии элементов в List для Set
     * коллекции объектов типа Person
     * с использованием компаратора для Person.
     * @param persons   Set коллекция Person, List копия элементов
     *                  которой которой будет отсортирована.
     * @param comparator объект с реализованным интерфейсом Comparator
     *                  для сравнения двух объектов типа Person.
     */
    public static void mySortPersonsWithTime(Set<Person> persons,
                                      Comparator<Person> comparator) {
        long startTime;
        long stopTime;
        ArrayList<Person> bufCopy = new ArrayList<>(persons);
        startTime = System.currentTimeMillis();
        //sortPersons(persons, comparator); //>2+ hours for 100_000
//        quickSortPerson(bufCopy, 0, persons.size() - 1, comparator);
        qSortPerson(bufCopy, comparator);
        stopTime = System.currentTimeMillis();
        printOperationCollectionNameTime(
                "сортировка своим методом List копии объектов из",
                persons, startTime, stopTime);
        bufCopy.clear();
    }

    /**
     * Стандартная сортировка копии элементов в List для Set
     * коллекции объектов типа Person.
     * @param comparator объект с реализованным интерфейсом Comparator
     *                   для сравнения двух объектов типа Person.
     */
    public static void sortPersonsWithTime(Set<Person> persons,
                                    Comparator<Person> comparator) {
        long startTime;
        long stopTime;
        ArrayList<Person> bufCopy = new ArrayList<>(persons);
        startTime = System.currentTimeMillis();
        bufCopy.sort(comparator);
        stopTime = System.currentTimeMillis();
        printOperationCollectionNameTime(
                "стандартная сортировка копии объектов из",
                persons, startTime, stopTime);
        bufCopy.clear();
    }

    /**
     * QuickSort сортировка для List коллекции объектов типа Person
     * с использованием компаратора для Person и измерением времени
     * сортировки с последующим выводом сообщения о длительности
     * сортировки.
     * @param persons   коллекция для сортировки.
     * @param comparator объект с реализованным интерфейсом Comparator
     *                  для сравнения двух объектов типа Person.
     */
    public static void mySortPersonsWithTime(List<Person> persons,
                                      Comparator<Person> comparator) {
        long startTime;
        long stopTime;
        startTime = System.currentTimeMillis();
        //sortPersons(persons, comparator); //>2+ hours for 100_000
        //quickSortPerson(persons, 0, persons.size() - 1, comparator);
        qSortPerson(persons, comparator);   //без рекурсии быстрее
        stopTime = System.currentTimeMillis();
        printOperationCollectionNameTime(
                "сортировка своим методом объектов в",
                persons, startTime, stopTime);
    }

    /**
     * Стандартная сортировка для List коллекции объектов типа Person
     * с использованием компаратора для Person и измерением времени
     * сортировки с последующим выводом сообщения о длительности
     * сортировки.
     * @param persons   коллекция для сортировки.
     * @param comparator объект с реализованным интерфейсом Comparator
     *                  для сравнения двух объектов типа Person.
     */
    public static void sortPersonsWithTime(List<Person> persons,
                                    Comparator<Person> comparator) {
        long startTime;
        long stopTime;
        startTime = System.currentTimeMillis();
        persons.sort(comparator);
        stopTime = System.currentTimeMillis();
        printOperationCollectionNameTime(
                "стандартная сортировка объектов в",
                persons, startTime, stopTime);
    }

    /**
     * Пузырьковая сортировка для List коллекции объектов типа Person.
     * @param comparator объект с реализованным интерфейсом Comparator
     *                  для сравнения двух объектов типа Person.
     */
    public static void sortPersons(List<Person> persons,
                            Comparator<Person> comparator) {
        Person tmp;
        for (int i = 0; i < persons.size() - 1; i++) {
            for (int j = 0; j < persons.size() - 1; j++) {
                if (comparator.compare(persons.get(j),
                        persons.get(j + 1)) > 0) {
                    tmp = persons.get(j);
                    persons.set(j, persons.get(j + 1));
                    persons.set(j + 1, tmp);
                }
            }
        }
    }

    /**
     * Метод сортировки части значений для работы сортировки quickSort
     * @param list коллекция типа List для сортировки quicksort'ом
     * @param begin элемент с которого начинается сортировка
     * @param end элемент до которого заканчивается сортировка
     * @param comparator компаратор, по которому пройдёт сортировка.
     * @return коллекция с отсортированной частью
     */
    private static int partitionPerson(List<Person> list, int begin, int end,
                                 Comparator<Person> comparator) {
        int pivot = end;

        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (comparator.compare(list.get(i), list.get(pivot)) < 0) {
                Person temp = list.get(counter);
                list.set(counter, list.get(i));
                list.set(i, temp);
                counter++;
            }
        }
        Person temp = list.get(pivot);
        list.set(pivot, list.get(counter));
        list.set(counter, temp);

        return counter;
    }

    /**
     * Сортировка QuickSort для коллекций типа List c объектами Person
     * @param list List c объектами Person
     * @param begin индекс элемента начала сортировки
     * @param end индекс элемента окончания сортировки
     * @param comparator компаратор, по которому пройдёт сортировка.
     */
    private static void quickSortPerson(List<Person> list, int begin, int end,
                                        Comparator<Person> comparator) {
        if (end <= begin) {
            return;
        }
        int pivot = partitionPerson(list, begin, end, comparator);
        quickSortPerson(list, begin, pivot-1, comparator);
        quickSortPerson(list, pivot+1, end, comparator);
    }

    /**
     * QuickSort сортировка для List коллекции объектов типа Person
     * с использованием компаратора для Person без рекурсии.
     * Подходит для больших коллекций Person и работает с ними
     * быстрее и без {@link StackOverflowError}.
     * @param people коллекция List объектов Person
     * @param comparator компаратор сравнения объектов Person
     */
    private static void qSortPerson(List<Person> people,
                                    Comparator<Person> comparator) {
        final int MAXSTACK = 20480; // максимальный размер стека
        int i, j;   			// указатели, участвующие в разделении
        int lb, ub;  		// границы сортируемого в цикле фрагмента
        // стек запросов каждый запрос задается парой значений,
        // а именно: левой(lbstack) и правой(ubstack)
        // границами промежутка
        int[] lbstack = new int[MAXSTACK];
        int[] ubstack = new int[MAXSTACK];

        int stackpos = 1;   	// текущая позиция стека
        int ppos;            // середина массива
        Person pivot;              // опорный элемент
        Person temp;
        lbstack[1] = 0;
        ubstack[1] = people.size() - 1;
        do {
            // Взять границы lb и ub текущего массива из стека.
            lb = lbstack[stackpos];
            ub = ubstack[stackpos];
            stackpos--;
            do {
                // Шаг 1. Разделение по элементу pivot
                ppos = (lb + ub) / 2;
                i = lb; j = ub; pivot = people.get(ppos);
                do {
                    while (comparator.compare(people.get(i), pivot) < 0) i++;
                    while (comparator.compare(pivot, people.get(j)) < 0) j--;
                    if (i <= j) {
                        temp = people.get(i);
                        people.set(i, people.get(j));
                        people.set(j, temp);
                        i++; j--;
                    }
                } while (i <= j);
                // Сейчас указатель i указывает на начало правого подмассива,
                // j - на конец левого (см. иллюстрацию выше), lb ? j ? i ? ub.
                // Возможен случай, когда указатель
                // i или j выходит за границу массива
                // Шаги 2, 3. Отправляем большую часть в стек  и двигаем lb,ub
                if (i < ppos) {     // правая часть больше
                    if (i < ub) {     //  если в ней больше 1 элемента - нужно
                        stackpos++;       //  сортировать, запрос в стек
                        lbstack[stackpos] = i;
                        ubstack[stackpos] = ub;
                    }
                    ub = j;             //  следующая итерация разделения
                    //  будет работать с левой частью
                } else {       	    // левая часть больше
                    if (j > lb) {
                        stackpos++;
                        lbstack[stackpos] = lb;
                        ubstack[stackpos] = j;
                    }
                    lb = i;
                }
            } while (lb < ub);      // пока в меньшей части более 1 элемента
        } while (stackpos != 0);    // пока есть запросы в стеке
    }

    /**
     * QuickSort сортировка для List коллекции объектов типа Animal
     * с использованием компаратора для Animal без рекурсии.
     * Подходит для больших коллекций Animal и работает с ними
     * быстрее и без {@link StackOverflowError}.
     * @param animals коллекция List объектов Animal
     * @param comparator компаратор сравнения объектов Animal
     */
    private static void qSortAnimal(List<Animal> animals,
                                    Comparator<Animal> comparator) {
        final int MAXSTACK = 20480; // максимальный размер стека
        int i, j;   			// указатели, участвующие в разделении
        int lb, ub;  		// границы сортируемого в цикле фрагмента
        // стек запросов каждый запрос задается парой значений,
        // а именно: левой(lbstack) и правой(ubstack)
        // границами промежутка
        int[] lbstack = new int[MAXSTACK];
        int[] ubstack = new int[MAXSTACK];

        int stackpos = 1;   	// текущая позиция стека
        int ppos;            // середина массива
        Animal pivot;              // опорный элемент
        Animal temp;
        lbstack[1] = 0;
        ubstack[1] = animals.size() - 1;
        do {
            // Взять границы lb и ub текущего массива из стека.
            lb = lbstack[stackpos];
            ub = ubstack[stackpos];
            stackpos--;
            do {
                // Шаг 1. Разделение по элементу pivot
                ppos = (lb + ub) / 2;
                i = lb; j = ub; pivot = animals.get(ppos);
                do {
                    while (comparator.compare(animals.get(i), pivot) < 0) i++;
                    while (comparator.compare(pivot, animals.get(j)) < 0) j--;
                    if (i <= j) {
                        temp = animals.get(i);
                        animals.set(i, animals.get(j));
                        animals.set(j, temp);
                        i++; j--;
                    }
                } while (i <= j);
                // Сейчас указатель i указывает на начало правого подмассива,
                // j - на конец левого (см. иллюстрацию выше), lb ? j ? i ? ub.
                // Возможен случай, когда указатель
                // i или j выходит за границу массива
                // Шаги 2, 3. Отправляем большую часть в стек  и двигаем lb,ub
                if (i < ppos) {     // правая часть больше
                    if (i < ub) {     //  если в ней больше 1 элемента - нужно
                        stackpos++;       //  сортировать, запрос в стек
                        lbstack[stackpos] = i;
                        ubstack[stackpos] = ub;
                    }
                    ub = j;             //  следующая итерация разделения
                    //  будет работать с левой частью
                } else {       	    // левая часть больше
                    if (j > lb) {
                        stackpos++;
                        lbstack[stackpos] = lb;
                        ubstack[stackpos] = j;
                    }
                    lb = i;
                }
            } while (lb < ub);      // пока в меньшей части более 1 элемента
        } while (stackpos != 0);    // пока есть запросы в стеке
    }

    /**
     * Генерирует указанное в константе OBJECTS_AMOUNT количество
     * уникальных объектов Animal с указанными в константах лимитами
     * длины пароля (PASSWORD_LENGTH и MIN_PASSWORD_LENGTH)
     * и длины имени (NAME_LENGTH).
     * @param animals   коллекция в которую будет записано
     *                 OBJECTS_AMOUNT объектов Animal.
     */
    private static void createAnimals(Set<Animal> animals) {
        Random random = new Random();
        while (animals.size() != OBJECTS_AMOUNT) {
            animals.add(new Animal(random.nextInt(ANIMAL_MAX_AGE),
                    RandomString.nextString(NAME_LENGTH)));
        }
    }

    /**
     * QuickSort сортировка копии элементов в List для Set
     * коллекции объектов типа Animal
     * с использованием компаратора для Animal.
     * @param animals   Set коллекция Animal, List копия элементов
     *                  которой которой будет отсортирована.
     * @param comparator объект с реализованным интерфейсом Comparator
     *                  для сравнения двух объектов типа Animal.
     */
    public static void mySortWithTime(Set<Animal> animals,
                                      Comparator<Animal> comparator) {
        long startTime;
        long stopTime;
        ArrayList<Animal> bufCopy = new ArrayList<>(animals);
        startTime = System.currentTimeMillis();
        //sort(bufCopy, comparator);
        qSortAnimal(bufCopy, comparator);
        stopTime = System.currentTimeMillis();
        printOperationCollectionNameTime(
                "сортировка своим методом List копии объектов из",
                animals, startTime, stopTime);
        bufCopy.clear();
    }

    /**
     * Стандартная сортировка List копии элементов из Set
     * коллекции объектов типа Animal.
     * @param comparator объект с реализованным интерфейсом Comparator
     *                  для сравнения двух объектов типа Animal.
     */
    public static void sortWithTime(Set<Animal> animals,
                                      Comparator<Animal> comparator) {
        long startTime;
        long stopTime;
        ArrayList<Animal> bufCopy = new ArrayList<>(animals);
        startTime = System.currentTimeMillis();
        bufCopy.sort(comparator);
        stopTime = System.currentTimeMillis();
        printOperationCollectionNameTime(
                "стандартная сортировка копии объектов из",
                animals, startTime, stopTime);
        bufCopy.clear();
    }

    /**
     * QuickSort сортировка для List коллекции объектов типа Animal
     * с использованием компаратора для Animal и измерением времени
     * сортировки с последующим выводом сообщения о длительности
     * сортировки.
     * @param animals   коллекция для сортировки.
     * @param comparator объект с реализованным интерфейсом Comparator
     *                  для сравнения двух объектов типа Animal.
     */
    public static void mySortWithTime(List<Animal> animals,
                                      Comparator<Animal> comparator) {
        long startTime;
        long stopTime;
        startTime = System.currentTimeMillis();
        //sort(animals, comparator);
        qSortAnimal(animals, comparator);
        stopTime = System.currentTimeMillis();
        printOperationCollectionNameTime(
                "сортировка своим методом объектов в",
                animals, startTime, stopTime);
    }

    /**
     * Стандартная сортировка для List коллекции объектов типа Animal
     * с использованием компаратора для Animal и измерением времени
     * сортировки с последующим выводом сообщения о длительности
     * сортировки.
     * @param animals   коллекция для сортировки.
     * @param comparator объект с реализованным интерфейсом Comparator
     *                  для сравнения двух объектов типа Animal.
     */
    public static void sortWithTime(List<Animal> animals,
                                      Comparator<Animal> comparator) {
        long startTime;
        long stopTime;
        startTime = System.currentTimeMillis();
        animals.sort(comparator);
        stopTime = System.currentTimeMillis();
        printOperationCollectionNameTime(
                "стандартная сортировка объектов в",
                animals, startTime, stopTime);
    }

    /**
     * Пузырьковая сортировка для List коллекции объектов типа Animal.
     * @param comparator объект с реализованным интерфейсом Comparator
     *                  для сравнения двух объектов типа Animal.
     */
    public static void sort(List<Animal> animals,
                            Comparator<Animal> comparator) {
        Animal tmp;
        for (int i = 0; i < animals.size() - 1; i++) {
            for (int j = 0; j < animals.size() - 1; j++) {
                if (comparator.compare(animals.get(j),
                        animals.get(j + 1)) > 0) {
                    tmp = animals.get(j);
                    animals.set(j, animals.get(j + 1));
                    animals.set(j + 1, tmp);
                }
            }
        }
    }
}
