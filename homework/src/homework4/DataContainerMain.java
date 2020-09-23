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
package homework4;

/**
 *  Класс демонстрации функционала
 *  и проверки работы объекта-контейнера.
 */
public class DataContainerMain {
    
    /**
     * Здесь проверяются методы
     * объектов-контейнеров класса DataContainer.
     * @param args параметры передаваемые при запуске программы.
     */
    public static void main(String[] args) {
        DataContainer<Integer> numbers = new DataContainer<>();
        numbers.add(12);
        numbers.add(13);
        numbers.add(14);
        numbers.add(15);

        numbers.print();

        System.out.println(numbers.delete(2));
        System.out.println(numbers.delete(17));

        numbers.print();

        numbers.add(17);
        System.out.println(numbers.delete((Integer) 20));
        System.out.println(numbers.delete(Integer.valueOf(12)));

        numbers.print();
        
        //TODO: add examples with sort, toString, get, getItems,
        // sort with comparator, sort with "... extends comarable".
    }
}
