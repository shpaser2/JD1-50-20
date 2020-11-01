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
        HashSet<Person> persons = new HashSet<>(OBJECTS_AMOUNT);
        createPersons(persons);

        LinkedList<Person> personLinkedList = new LinkedList<>();
        ArrayList<Person> personArrayList = new ArrayList<>();
        HashSet<Person> personHashSet = new HashSet<>();
        TreeSet<Person> personTreeSet = new TreeSet<>();

        //3.2.1.1-3.2.1.4 Заполняем коллекции с замером процесса по времени.
        measureFulfillingTime(persons, personLinkedList);
        measureFulfillingTime(persons, personArrayList);
        measureFulfillingTime(persons, personHashSet);
        measureFulfillingTime(persons, personTreeSet);

        //создание копий для сортировок
        LinkedList<Person> personLinkedListCopy =
                new LinkedList<>(personLinkedList);
        ArrayList<Person> personArrayListCopy =
                new ArrayList<>(personArrayList);
        HashSet<Person> personHashSetCopy = new HashSet<>(personHashSet);
        TreeSet<Person> personTreeSetCopy = new TreeSet<>(personTreeSet);

        //3.3.1. Сортируем коллекции встроенными средствами jdk
        PersonComparator personComparator = new PersonComparator();
        //new version with static methods with generic
        mySortWithTimeGeneric(personLinkedListCopy, personComparator, true);
        mySortWithTimeGeneric(personArrayListCopy, personComparator, true);
        mySortWithTimeGeneric(personHashSetCopy, personComparator, true);
        mySortWithTimeGeneric(personTreeSetCopy, personComparator, true);

        //3.3.2.* Сортируем коллекции собственным методом сортировки
        //new version with static methods with generic
        mySortWithTimeGeneric(personLinkedList, personComparator, false);
        mySortWithTimeGeneric(personArrayList, personComparator, false);
        mySortWithTimeGeneric(personHashSet, personComparator, false);
        mySortWithTimeGeneric(personTreeSet, personComparator, false);

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

        LinkedList<Animal> animalLinkedList = new LinkedList<>();
        ArrayList<Animal> animalArrayList = new ArrayList<>();
        HashSet<Animal> animalHashSet = new HashSet<>();
        TreeSet<Animal> animalTreeSet = new TreeSet<>();

        //3.2.1.1-3.2.1.4 Заполняем коллекции с замером процесса по времени.
        measureFulfillingTime(animals, animalLinkedList);
        measureFulfillingTime(animals, animalArrayList);
        measureFulfillingTime(animals, animalHashSet);
        measureFulfillingTime(animals, animalTreeSet);

        //создание копий для сортировок
        LinkedList<Animal> animalLinkedListCopy =
                new LinkedList<>(animalLinkedList);
        ArrayList<Animal> animalArrayListCopy =
                new ArrayList<>(animalArrayList);
        HashSet<Animal> animalHashSetCopy = new HashSet<>(animalHashSet);
        TreeSet<Animal> animalTreeSetCopy = new TreeSet<>(animalTreeSet);

        //3.3.1. Сортируем коллекции встроенными средствами jdk
        AnimalComparator animalComparator = new AnimalComparator();
        //new version with static methods with generic
        mySortWithTimeGeneric(animalArrayList, animalComparator, true);
        mySortWithTimeGeneric(animalLinkedList, animalComparator, true);
        mySortWithTimeGeneric(animalHashSet, animalComparator, true);
        mySortWithTimeGeneric(animalTreeSet, animalComparator, true);

        //3.3.2.* Сортируем коллекции собственным методом сортировки
        //new version with static methods with generic
        mySortWithTimeGeneric(animalLinkedListCopy, animalComparator, false);
        mySortWithTimeGeneric(animalArrayListCopy, animalComparator, false);
        mySortWithTimeGeneric(animalHashSetCopy, animalComparator, false);
        mySortWithTimeGeneric(animalTreeSetCopy, animalComparator, false);

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


    private static <T> void measureFulfillingTime(Set<T> source,
                                                  Collection<T> destination) {
        long startTime;
        long stopTime;
        startTime = System.currentTimeMillis();
        for (T t : source) {
            destination.add(t);
        }
        stopTime = System.currentTimeMillis();

        //3.4.1 Время заполнения коллекции
        printOperationCollectionNameTime("заполнение",
                destination, startTime, stopTime);
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
     * QuickSort сортировка для List коллекции объектов
     * с использованием компаратора и измерением времени
     * сортировки с последующим выводом сообщения о длительности
     * сортировки.
     * @param entities   коллекция для сортировки.
     * @param comparator объект с реализованным интерфейсом Comparator
     *                  для сравнения двух объектов типа T.
     */
    public static <T> void mySortWithTimeGeneric(List<T> entities,
            Comparator<T> comparator, boolean useEmbeddedSort) {
        long startTime;
        long stopTime;
        String message;
        startTime = System.currentTimeMillis();
        if (useEmbeddedSort) {
            entities.sort(comparator);
            message = "стандартная сортировка объектов в";
        } else {
            qSortGeneric(entities, comparator);
            message = "сортировка своим методом объектов в";
        }
        stopTime = System.currentTimeMillis();
        printOperationCollectionNameTime(
                message, entities, startTime, stopTime);
    }

    /**
     * QuickSort сортировка копии элементов в List для Set
     * коллекции объектов с использованием компаратора.
     * @param entities   Set коллекция, List копия элементов
     *                  которой которой будет отсортирована.
     * @param comparator объект с реализованным интерфейсом Comparator
     *                  для сравнения двух объектов.
     */
    public static <T> void mySortWithTimeGeneric(Set<T> entities,
            Comparator<T> comparator, boolean useEmbeddedSort) {
        long startTime;
        long stopTime;
        String message;
        ArrayList<T> bufCopy = new ArrayList<>(entities);
        startTime = System.currentTimeMillis();
        if (useEmbeddedSort) {
            bufCopy.sort(comparator);
            message = "стандартная сортировка копии объектов из";
        } else {
            qSortGeneric(bufCopy, comparator);
            message = "сортировка своим методом копии объектов из";
        }
        stopTime = System.currentTimeMillis();
        printOperationCollectionNameTime(
                message, entities, startTime, stopTime);
        bufCopy.clear();
    }

    /**
     * QuickSort сортировка для List коллекции
     * с использованием компаратора и без рекурсии.
     * @param entities коллекция List объектов T
     * @param comparator компаратор сравнения объектов T
     */
    private static <T> void qSortGeneric(List<T> entities,
            Comparator<T> comparator) {
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
        T pivot;              // опорный элемент
        T temp;
        lbstack[1] = 0;
        ubstack[1] = entities.size() - 1;
        do {
            // Взять границы lb и ub текущего массива из стека.
            lb = lbstack[stackpos];
            ub = ubstack[stackpos];
            stackpos--;
            do {
                // Шаг 1. Разделение по элементу pivot
                ppos = (lb + ub) / 2;
                i = lb; j = ub; pivot = entities.get(ppos);
                do {
                    while (comparator.compare(entities.get(i), pivot) < 0) i++;
                    while (comparator.compare(pivot, entities.get(j)) < 0) j--;
                    if (i <= j) {
                        temp = entities.get(i);
                        entities.set(i, entities.get(j));
                        entities.set(j, temp);
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
}
