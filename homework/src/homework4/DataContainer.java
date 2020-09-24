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

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Класс поясняющий работу ArrayList и обобщенные типы.
 * @param <T> обобщенный тип хранимых данных.
 *
 * @version 2.00 21.09.2020
 * @author Сергей Шпаковский
 */
public class DataContainer<T> {
    private T[] arr;
    
    /**
     * Добавляет элемент в первую свободную ячейку массива.
     * Если все ячейки заняты - увеличивает длину массива на 1
     * и записывает новый жлемент в конец массива.
     * @param item элемент для записи в массив.
     * @return      индек элемента в массиве.
     */
    public int add(T item) {
        if (this.arr == null) {
            @SuppressWarnings("unchecked")
            T[] a = (T[]) Array.newInstance(item.getClass(), 1);
            this.arr = a;
        }
        int indexInsert = 0;
        for (; indexInsert < arr.length; indexInsert++) {
            if (arr[indexInsert] == null) {
                break;
            }
        }
        if (indexInsert == arr.length) {
            this.arr = Arrays.copyOf(this.arr, this.arr.length + 1);
        }
        this.arr[indexInsert] = item;
        return indexInsert;
    }
    
    /**
     * Удаление элемента из массива,
     * если есть элемент с таким индексом.
     * @param index индекс элемента для удаления.
     * @return      true если элемент удален успешно,
     *              false если такой элемент не найден.
     */
    public boolean delete(int index) {
        boolean result = false;
        if (index < arr.length - 1) {
            for (int i = index; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr = Arrays.copyOf(arr, arr.length - 1);
            result = true;
        }
        return result;
    }
    
    /**
     * Удаление элемента из массива,
     * если такой элемент в массиве есть.
     * @param item ссылка на элемент
     * @return      true если элемент удален успешно,
     *              false если такой элемент не найден.
     */
    public boolean delete(T item) {
        boolean result = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(item)) {
                delete(i);
                result = true;
                break;
            }
        }
        return result;
    }
    
    /**
     * Получение всего массива элементов типа Т.
     * @return
     */
    public T[] getItems() {
        return arr;
    }
    
    /**
     * Получение элемента массива по его индексу.
     * @param index индекс элемента массива
     * @return      ссылка на объект типа Т с индексом
     *                  в массиве равным index.
     */
    public T get(int index) {
        return arr[index];
    }
    
    /**
     * Вывод элементов массива в консоль (в целях отладки).
     */
    public void print() {
        for (T t : arr) {
            System.out.println(t);
        }
    }
    
    /**
     * Пузырьковая сортировка для массива объектов типа Т.
     * @param comparator интерфейс или объект с реализованным
     *                  методом сравнения двух объектов типа Т.
     */
    public void sort(Comparator<T> comparator) {
        T tmp;
        for (int maxUnsortedIndex = arr.length - 1;
                 maxUnsortedIndex > 0;
                 maxUnsortedIndex--) {
            for (int i = 0; i < maxUnsortedIndex; i++) {
                if (comparator.compare(this.arr[i], this.arr[i + 1]) > 0) {
                    tmp = this.arr[i];
                    this.arr[i] = this.arr[i + 1];
                    this.arr[i + 1] = tmp;
                }
            }
        }
    }
    
    /**
     * Формирует и возвращает строку с элементами массива.
     * @return строка не null элементов массива, разделенных ", ".
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (this.arr[i] != null) {
                stringBuilder.append(this.arr[i].toString());
            }
            if (i != arr.length - 1) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }
    
    /**
     * Сортирует элементы в переданном объекте DataContainer используя
     * реализацию сравнения вызываемую у хранимых объектов.
     * @param container переданный объект-контейнер.
     * @param <V>       обобщенный тип, который может отличаться
     *                      от типа класса.
     */
    public static <V extends Comparable> void sort(DataContainer<V> container){
        V tmp;
        for (int maxUnsortedIndex = container.arr.length - 1;
                 maxUnsortedIndex > 0;
                 maxUnsortedIndex--) {
            for (int i = 0; i < maxUnsortedIndex; i++) {
                if (container.arr[i].compareTo(container.arr[i + 1]) > 0) {
                    tmp = container.arr[i];
                    container.arr[i] = container.arr[i + 1];
                    container.arr[i + 1] = tmp;
                }
            }
        }
    }
    
    /**
     * Сортирует элементы в переданном объекте DataContainer используя
     * реализацию сравнения переданного компаратора.
     * @param container переданный объект-контейнер.
     * @param comparator переданный компаратор для сортировки.
     * @param <V>       обобщенный тип, который может отличаться
     *                      от типа класса.
     */
    public static <V> void sort(DataContainer<V> container,
                                Comparator<V> comparator){
        container.sort(comparator);
    }
}
