
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
package homework2;

/**
 * Класс сортировок.
 * Здесь есть сортировка пузырьком и шейкерная 
 * для массивов типа int[].
 *
 * @version   1.00 14.09.2020
 * @author    Сергей Шпаковский
 */
public class Sorts {

    /**
     * Пузырьковая сортировка целочисленного массива.
     * @param arr целочисленный массив для сортировки
     */
    public static void bubbleSort(int[] arr) {
        for (int maxUnsortedIndex = arr.length - 1;
             maxUnsortedIndex > 0;
             maxUnsortedIndex--) {
            for (int i = 0; i < maxUnsortedIndex; i++) {
                if (arr[i] > arr[i + 1]) {
                    swapElements(arr, i, i + 1);
                }
            }
        }
    }
    
    /**
     * Шейкерная сортировка для int[].
     * @param arr целочисленный массив для сортировки.
     */
    public static void shakeSort(int[] arr) {
        int minUnsInd = 0;
        int maxUnsInd = arr.length - 1;
        boolean swapUp;
        boolean swapDown;
        do {
            swapUp = false;
            swapDown = false;
            for (int i = minUnsInd; i < maxUnsInd; i++) {
                if (arr[i] > arr[i + 1]) {
                    swapElements(arr, i, i + 1);
                    swapUp = true;
                }
            }
            maxUnsInd--;
            for (int i = maxUnsInd; i > minUnsInd; i--) {
                if (arr[i] < arr[i - 1]) {
                    swapElements(arr, i, i - 1);
                    swapDown = true;
                }
            }
            minUnsInd++;
        } while (swapUp || swapDown);
    }
    
    /**
     * Метод меняющий два любых элемента массива местами.
     * @param arr массив для действий
     * @param a индекс элемента для замены элементом с индексом b
     * @param b индекс другого элемента для замены с индексом a
     */
    private static void swapElements(int[] arr, int a, int b) {
        int buf;
        buf = arr[a];
        arr[a] = arr[b];
        arr[b] = buf;
    }
}
