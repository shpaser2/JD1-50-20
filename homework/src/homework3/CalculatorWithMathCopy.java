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
 * Копия класса простого калькулятора с использованием
 * операторов ^/+-* и функциями извлечения квадратного корня
 * и возведения в степень, нахождения модуля числа.
 *
 * @version   1.00 14.09.2020
 * @author    Сергей Шпаковский
 */
public class CalculatorWithMathCopy implements Calculator {
    
    /**
     * Деление числа на число
     * @param dividend делимое
     * @param divider делитель
     * @return результат деления делимого на делитель
     */
    public double division(double dividend, double divider) {
        return dividend / divider;
    }
    
    /**
     * Умножение числа на чило
     * @param factorOne первый множитель
     * @param factorTwo второй множитель
     * @return произведение множителей
     */
    public double multiplication(double factorOne, double factorTwo) {
        return factorOne * factorTwo;
    }
    
    /**
     * Нахождение разности двух чисел.
     * @param minuend  уменьшаемое
     * @param subtrahend  вычитаемое
     * @return  разность уменьшаемого и вычитаемого
     */
    public double subtraction(double minuend, double subtrahend) {
        return minuend - subtrahend;
    }
    
    /**
     * Сложение двух чисел.
     * @param numberOne первое слагаемое
     * @param numberTwo второе слагаемое
     * @return сумма слагаемых
     */
    public double addition(double numberOne, double numberTwo) {
        return numberOne + numberTwo;
    }
    
    /**
     * Возведение в целую степень дробного числа
     * c использованием библиотеки Math.
     * @param number дробное или целое число
     * @param power целочисленная степень
     * @return  результат возведения в степень
     */
    public double powerDouble(double number, int power) {
        return Math.pow(number, power);
    }
    
    /**
     * Нахождение модуля от числа c использованием библиотеки Math.
     * @param value дробное число.
     * @return неотрицательное дробное число.
     */
    public double absoluteValue(double value) {
        return Math.abs(value);
    }
    
    /**
     * Нахождение квадратного корня из числа.
     * @param value неотрицательное число
     * @return число, квадрат которого
     * меньше или равен числу-параметру.
     */
    public double squareRoot(double value) {
        return Math.sqrt(value);
    }
}
