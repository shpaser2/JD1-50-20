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

import java.util.ArrayList;

/**
 * Класс - пример ...
 *
 * @version   1.00 06.09.2020
 * @author    Сергей Шпаковский
 */
public class MultiplyDigitsMain {
    
    //Пример: Ввели 181232375,
    // должно получиться в консоли: 1 * 8 * 1 * 2 * …. * 5 = ответ
    /**
     * Точка входа и пример ...
     *
     * @param args массив строк, ввод
     */
    public static void main(String[] args) {
        try {
            int argument = Integer.parseInt(args[0]);
            if (argument < 10) {
                printHelp();
                return;
            }
            ArrayList arl = new ArrayList();
            while (argument > 0) {
                arl.add(argument % 10);
                argument /= 10;
            }
            int digitsNumber = arl.size();
            int[] digits = new int[digitsNumber];
            int ind = 0;
            for (Object i : arl) {
                digits[ind] = ((Integer)i).intValue();
                ind++;
            }
            long result = 1;
            int maxIndex = digits.length - 1;
            for (int index = maxIndex; index >= 0; index--) {
                if (index != maxIndex) {
                    System.out.print(" * ");
                }
                System.out.print(digits[index]);
                result *= digits[index];
                if (index == 0) {
                    System.out.println(" = " + result);
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            printHelp();
        }
    }
    
    //XXX
    private static void printHelp() {
        System.out.println("Argument must be positive integer number,\n"
                + "consist of two or more digits "
                + "and be lower than 2147483648.");
    }
}
