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

/**
 * Класс - пример ...
 *
 * @version   1.00 06.09.2020
 * @author    Сергей Шпаковский
 */
public class MultiplicationTableMain {
    
    /**
     * Точка входа и пример ...
     *
     * @param args массив строк, ввод
     */
    public static void main(String[] args) {
        printPartOfTable(2, 5);
        System.out.println();
        printPartOfTable(6, 9);
    }
    
    //XXX
    private static void printPartOfTable(int startNum, int endNum) {
        int result;
        for (int i = 1; i <= 10; i++) {
            for (int ind = startNum; ind <= endNum; ind++) {
                result = ind * i;
                System.out.print(ind + " * " + i + "\t= " + result);
                if (ind != endNum) {
                    if (result < 10) {
                        System.out.print("\t\t");
                    } else {
                        System.out.print('\t');
                    }
                }
            }
            System.out.println();
        }
    }
}
