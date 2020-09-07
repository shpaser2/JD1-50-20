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
package cyclesAndArrays;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Класс - пример пузырьковой и шейкерной сортировок.
 * Также здесь есть создание массива рандомной длины с рандомными
 * числами и ввод целочисленного массива произвольной длины с консоли.
 *
 * @version   1.00 07.09.2020
 * @author    Сергей Шпаковский
 */
public class BubbleShakeSortsMain {
    
    /**
     * Точка входа и пример работы сортировки пузырьком,
     * шейкерной сортировки с целочисленными массивами.
     * Пример создания массива случайной длины со случайными
     * целыми числами и ввода целочисленного массива с консоли.
     * @param args массив строк, передаваемые аргументы при запуске
     */
    public static void main(String[] args) {
        int[][] testArrays = {{1, 2, 3, 4, 5, 6}, {1, 1, 1, 1},
                {9, 1, 5, 99, 9, 9}, {}};
        for (int[] array : testArrays) {
            sortArrayByTwoMethods(array);
        }
        createRandArray();
        createArrByConsoleInput();
    }
    
    /**
     * Сортировка int массива пузырьком и шейкерная
     * с отображением ДО и ПОСЛЕ.
     * @param array массив, копии которого будут отсортированы
     */
    private static void sortArrayByTwoMethods(int[] array) {
        int[] arr1 = array.clone();
        int[] arr2 = array.clone();
        System.out.println("Сортируем следующий массив: ");
        System.out.println(Arrays.toString(array));
        System.out.println("Сортировка шейкерная.");
        shakeSort(arr1);
        System.out.println(Arrays.toString(arr1));
        System.out.println("Сортировка пузырьком.");
        bubbleSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }
    
    /**
     * Пузырьковая сортировка целочисленного массива.
     * @param arr целочисленный массив для сортировки
     */
    private static void bubbleSort(int[] arr) {
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
    private static void shakeSort(int[] arr) {
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
    
    /**
     * Метод создает массив случайной длины со случайными целыми
     * числами.
     */
    private static void createRandArray() {
        Random random = new Random();
        int maxArrLength = 100;
        int maxNumberValue = 1993;
        int[] testRandArray = new int[random.nextInt(maxArrLength)];
        for (int i = 0; i < testRandArray.length; i++) {
            testRandArray[i] = random.nextInt(maxNumberValue);
        }
        System.out.println("Создан массив рандомной длины с рандомными "
                + "числами");
        System.out.println(Arrays.toString(testRandArray));
    }
    
    /**
     * Метод создает массив с помощью ввода целых чисел в консоль
     * через разделитель в виде пробела и/или запятой.
     */
    public static int[] createArrByConsoleInput() {
        boolean keyboardInputResultWrong = false;
        String[] partsWithNumbers = {};
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Введите целые числа через запятую и/или "
                    + "пробелы.");
            String rawNumbers = in.nextLine();
            if (rawNumbers.contains(".")) {
                System.out.println("Введены дробные числа или точки. "
                        + "Придется вводить заново.");
                keyboardInputResultWrong = true;
                continue;
            }
            String delimiters = "[ ,]+";
            partsWithNumbers = rawNumbers.split(delimiters);
        } while (keyboardInputResultWrong);
        int[] testHandArray = new int[partsWithNumbers.length];
        for (int i = 0; i < testHandArray.length; i++) {
            testHandArray[i] = Integer.parseInt(partsWithNumbers[i]);
        }
        System.out.println("Создан следующий массив чисел:");
        System.out.println(Arrays.toString(testHandArray));
        return testHandArray;
    }
}
