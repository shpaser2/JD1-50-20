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

import java.util.Scanner;

/**
 * Класс - пример ...
 *
 * @version   1.00 06.09.2020
 * @author    Сергей Шпаковский
 */
public class ArrayConsoleInOutMain3 {
    
    /**
     * Точка входа и пример ...
     *
     * @param args массив строк, ввод
     */
    public static void main(String[] args) {
        int arrLength = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество чисел в массиве");
        arrLength = scanner.nextInt();
        int[] arr = new int[arrLength];
        if (arrLength <= 0) {
            System.out.println("Введена неверная длина массива. \n"
                    + "В следующий раз введите положительное "
                    + "число больше нуля.");
            return;
        }
        for (int i = 0; i < arrLength; i++) {
            if (i != 0){
                System.out.println("введите следующее число");    
            } else {
                System.out.println("введите число");
            }
            arr[i] = scanner.nextInt();
        }
        System.out.println("Все выводы массива в обратном порядке");
        int maxIndex = arrLength - 1;
        int index = maxIndex;
        System.out.println("\nВывод с помощью do..while");
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
        index = maxIndex;
        for (; index >= 0; index--) {
            System.out.print(arr[index] + " ");
        }
        System.out.println("\nВывод с помощью foreach");
        int[] turnedArray = new int[arrLength];
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
