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
 * Класс - пример калькуляции факториала от числа,
 * переданного аргументом в программу.
 *
 * @version   1.01 06.09.2020
 * @author    Сергей Шпаковский
 */
public class MultiplyNumbersMain {
    
    /**
     * Вычисление факториала с обработкой переполнения, ошибок ввода,
     * отображением результата и множителя последних до переполнения.
     * @param args массив строк, аргументы при запуске
     */
    public static void main(String[] args) {
        try {
            int parameter = Integer.parseInt(args[0]);
            if (parameter <= 0) {
                printHelp();
                return;
            }
            long result = 1;
            long buffer = 1;
            int index = 1;
            for (; index <= parameter; index++) {
                if (index != 1) {
                    System.out.print(" * ");
                }
                System.out.print(index);
                buffer *= index;
                if (buffer > 0) {
                    result = buffer;
                } else {
                    System.out.println();
                    System.out.println("Calculation error. " +
                            "Last good result at " + (index - 1));
                    break;
                }
            }
            if (--index == parameter) {
                System.out.println(" = " + result);
            } else {
                System.out.println("Last result is " + result);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            printHelp();
        }
    }
    
    /**
     * Вывод подсказки для корректного использования аргумента.
     */
    private static void printHelp() {
        System.out.println("Argument must be integer " +
                "and higher than 0.");
    }
}
