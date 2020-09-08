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

import java.util.Scanner;

/**
 * Класс - пример ввода массивов через консоль,
 * вывода масивов в прямом и обратном порядке,
 * вывода только четных элементов массива.
 *
 * @version   2.01 07.09.2020
 * @author    Сергей Шпаковский
 */
public class ArrayConsoleInOutMain {
    
    /**
     * Точка входа и пример массива целых чисел двумя способами
     * через консоль, вывода введенного массива в прямом и обратном
     * порядке с помощью do..while, while, for, foreach.
     * @param args массив строк, ввод
     */
    public static void main(String[] args) {
        int[] arr = BubbleShakeSortsMain.createArrByConsoleInput();
        printArrayByAllCyclesForward(arr);          //2.1.1-2.1.4
        printEverySecondElement(arr);               //2.2
        arr = intArrFromConsoleBySingleNumbers();
        printArrayByAllCyclesBackward(arr);         //2.3.1-2.3.4
    }
    
    /**
     * Ввод массива целых чисел через консоль без использования
     * разделителей ',' или пробела
     * по одному числу в каждую новую строку.
     * "Разделитель" чисел в данном случае - нажатие клавиши Enter.
     * @return массив целых чисел
     */
    public static int[] intArrFromConsoleBySingleNumbers() {
        Scanner scanner = new Scanner(System.in);
        int arrLength;
        boolean lengthIsCorrect = false;
        do {
            System.out.println("\n\nВведите количество чисел в массиве");
            arrLength = scanner.nextInt();
            if (arrLength <= 0) {
                System.out.println("Введена неверная длина массива.\n"
                        + "В следующий раз введите положительное "
                        + "число больше нуля.");
            } else {
                lengthIsCorrect = true;
            }
        } while (!lengthIsCorrect);
        int[] arr = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            if (i != 0){
                System.out.println("введите следующее число");
            } else {
                System.out.println("введите число");
            }
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
    
    /**
     * Вывод переданного аргументом массива в прямом
     * порядке с помощью do..while, while, for, foreach.
     * @param arr целочисленный массив
     */
    public static void printArrayByAllCyclesForward(int[] arr) {
        int arrLength = arr.length;
        int index = 0;
        System.out.println("\nВывод с помощью do..while");
        do {
            System.out.print(arr[index] + " ");
            index++;
        } while (index < arrLength);
        System.out.println("\nВывод с помощью while");
        index = 0;
        while (index < arrLength) {
            System.out.print(arr[index] + " ");
            index++;
        }
        System.out.println("\nВывод с помощью for");
        for (index = 0; index < arrLength; index++) {
            System.out.print(arr[index] + " ");
        }
        System.out.println("\nВывод с помощью foreach");
        for (int element : arr) {
            System.out.print(element + " ");
        }
    }
    
    /**
     * Вывод в консоль каждого второго элемента массива.
     * @param arr целочисленный массив
     */
    public static void printEverySecondElement(int[] arr) {
        System.out.println("\n\nВывод каждого второго элемента массива.");
        for (int index = 0; index < arr.length; index++) {
            if (index % 2 == 1) {
                System.out.print(arr[index] + " ");
            }
        }
    }
    
    /**
     * Вывод переданного аргументом массива в обратном
     * порядке с помощью do..while, while, for, foreach.
     * @param arr целочисленный массив
     */
    public static void printArrayByAllCyclesBackward(int[] arr) {
        System.out.println("\n\nВсе выводы массива в обратном порядке");
        int maxIndex = arr.length - 1;
        int index = maxIndex;
        System.out.println("Вывод с помощью do..while");
        do {
            System.out.print(arr[index] + " ");
            index--;
        } while (index >= 0);
        System.out.println("\nВывод с помощью while");
        index = maxIndex;
        while (index >= 0) {
            System.out.print(arr[index] + " ");
            index--;
        }
        System.out.println("\nВывод с помощью for");
        for (index = maxIndex; index >= 0; index--) {
            System.out.print(arr[index] + " ");
        }
        System.out.println("\nВывод с помощью foreach");
        int[] turnedArray = new int[arr.length];
        index = maxIndex;
        for (int element : arr) {
            turnedArray[index] = element;
            index--;
        }
        for (int element : turnedArray) {
            System.out.print(element + " ");
        }
    }
}
