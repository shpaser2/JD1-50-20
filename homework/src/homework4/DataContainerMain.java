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

import java.util.Arrays;

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
        System.out.println("check add: ");
        numbers.add(15);
        numbers.add(99);
        numbers.add(14);
        numbers.add(13);
        numbers.add(12);
        numbers.print();
    
        System.out.println("check delete by index 2 and 17: ");
        System.out.println(numbers.delete(2));
        System.out.println(numbers.delete(17));
        numbers.print();
    
        System.out.println("check delete by value 20 and 12: ");
        numbers.add(3);
        System.out.println(numbers.delete((Integer) 20));
        System.out.println(numbers.delete(Integer.valueOf(12)));
        numbers.print();
    
        System.out.println("check get: ");
        System.out.println(numbers.get(3));
        System.out.println("check getItem with Arrays.toString(): ");
        System.out.println(Arrays.toString(numbers.getItems()));
        
        System.out.println("check toString: ");
        System.out.println(numbers.toString());
        
        System.out.println("check static sort with implemented Comparable "
                + "inside <T> class: ");
        DataContainer.sort(numbers);
        System.out.println(numbers.toString());
        
        //TODO: add example sort with comparator
    }
}
