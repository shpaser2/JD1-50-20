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
public class PowNumberMain {
    private static int MAX_POWER = 30;
    
    /**
     * Точка входа и пример ...
     *
     * @param args массив строк, ввод
     */
    //Степень - только положительная и целая. Возводимое число -
    // может быть отрицательным и дробным.
    public static void main(String[] args) {
        double number = 1;
        boolean resultIsDouble = false;
        int numberInt = 1;
        double result = 1;
        long resultInt = 1;
        double power;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Введите число для возведения в степень. \n Как"
                    + " знак разделитель дробной части использовать \",\" ");
            if (scanner.hasNextInt()) {
                numberInt = scanner.nextInt();
            } else {
                number = scanner.nextDouble();
                resultIsDouble = true;
            }
            System.out.println("Введите целую и положительную степень: ");
            power = scanner.nextDouble();
        } while (checkWrongParameters(power));
        
        if (resultIsDouble) {
            for (int i = 0; i < power; i++) {
                result *= number;
            }
            System.out.println(result);
        } else {
            for (int i = 0; i < power; i++) {
                resultInt *= numberInt;
            }
            System.out.println(resultInt);
        }
    }
    
    //XXX
    private static boolean checkWrongParameters(double power) {
        boolean checkIsNegative = power < 0;
        boolean checkNotInteger = (power % 1) > 0;
        boolean checkNotHighPower = Math.abs(power) > MAX_POWER;
        boolean checkResult =
                checkIsNegative || checkNotInteger || checkNotHighPower;
        if (checkResult) {
            if (checkIsNegative) {
                System.out.println("Введена отрицательная степень.");
            }
            if (checkNotInteger) {
                System.out.println("Введена дробная степень.");
            }
            if (checkNotHighPower) {
                System.out.println("Введена степень по модулю больше 30.");
            }
        }
        return checkResult;
    }
}
