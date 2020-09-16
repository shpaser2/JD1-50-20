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
package homework3;

/**
 * Интерфейс общих методов для калькуляторов.
 * Используется для упрощения использования классов калькуляторов
 * классами CalculatorWithCounter и CalculatorWithMemory.
 *
 * @version   1.00 14.09.2020
 * @author    Сергей Шпаковский
 */
public interface Calculator {
    
    /**
     * Деление числа на число
     * @param dividend делимое
     * @param divider делитель
     * @return результат деления делимого на делитель
     */
    double division(double dividend, double divider);
    
    /**
     * Умножение числа на чило
     * @param factorOne первый множитель
     * @param factorTwo второй множитель
     * @return произведение множителей
     */
    double multiplication(double factorOne, int factorTwo);
    
    /**
     * Нахождение разности двух чисел.
     * @param minuend  уменьшаемое
     * @param subtrahend  вычитаемое
     * @return  разность уменьшаемого и вычитаемого
     */
    double subtraction(double minuend, double subtrahend);
    
    /**
     * Сложение двух чисел.
     * @param numberOne первое слагаемое
     * @param numberTwo второе слагаемое
     * @return сумма слагаемых
     */
    double addition(double numberOne, double numberTwo);
    
    /**
     * Возведение в целую степень дробного числа.
     * @param number дробное или целое число
     * @param power целочисленная степень
     * @return  результат возведения в степень
     */
    double powerDouble(double number, int power);
    
    /**
     * Нахождение модуля от числа.
     * @param value дробное число.
     * @return неотрицательное дробное число.
     */
    double absoluteValue(double value);
    
    /**
     * Нахождение квадратного корня из числа.
     * @param value неотрицательное число
     * @return число, квадрат которого
     * меньше или равен числу-параметру.
     */
    double squareRoot(double value);
}
