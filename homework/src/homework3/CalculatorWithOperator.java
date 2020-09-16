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

import java.util.ArrayList;

/**
 * Класс простого калькулятора с использованием операторов ^/+-*
 * и функциями извлечения квадратного корня и возведения в степень,
 * нахождения модуля числа.
 *
 * @version   1.00 14.09.2020
 * @author    Сергей Шпаковский
 */
public class CalculatorWithOperator implements Calculator {
    
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
    public double multiplication(double factorOne, int factorTwo) {
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
     * Возведение в целую степень дробного числа.
     * @param number дробное или целое число
     * @param power целочисленная степень
     * @return  результат возведения в степень
     */
    public double powerDouble(double number, int power) {
        while (power > 1) {
            number *= number;
            power--;
        }
        return number;
    }
    
    /**
     * Нахождение модуля от числа.
     * @param value дробное число.
     * @return неотрицательное дробное число.
     */
    public double absoluteValue(double value) {
        return value > 0? value : -value;
    }
    
    /**
     * Нахождение квадратного корня из числа
     * алгоритмом разделения числа на группы по две цифры.
     * Так называемое нахождение корня в столбик.
     * Можно улучшить и доабвить задание точности вычисления
     * - количество знаков после запятой, если результат не целый.
     * @param value неотрицательное число
     * @return число, квадрат которого
     * меньше или равен числу-параметру.
     */
    public double squareRoot(double value) {
        ArrayList<Double> arrList = new ArrayList<Double>();
        
        while (value % 100 > 0) {
            arrList.add(value % 100);
            value /= 100;
        }
    
        double remainder = 0;
        int result = 0;
        for (int index = arrList.size() - 1; index >= 0; index--) {
            remainder = remainder * 100 + arrList.get(index);
            int numberX = 0;
            for (int i = 1; i < 10; i++) {
                int buffer = ((result * 2) * 10 + i) * i;
                double diff = remainder - buffer;
                if (diff < 0 || i == 9) {
                    if (diff < 0) {
                        numberX = i - 1;
                    } else if (i == 9) {
                        numberX = i;
                    }
                    remainder -= ((result * 2) * 10 + numberX) * numberX;
                    result = result * 10 + numberX;
                    break;
                }
            }
        }
        return result;
    }
}
