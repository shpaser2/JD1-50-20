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
 * Класс калькулятора с использованием для операций вычисления
 * другого передаваемого как параметр калькулятора.
 * При использовании калькулятора ведется подсчёт
 * произведенных операций.
 *
 * @version   1.00 14.09.2020
 * @author    Сергей Шпаковский
 */
public class CalculatorWithCounter implements Calculator {
    private int counter = 0;
    private Calculator calc;
    
    /**
     * Деление числа на число
     * с увеличением счётчика выполненных операций.
     * @param dividend делимое
     * @param divider делитель
     * @return результат деления делимого на делитель
     */
    public double division(double dividend, double divider) {
        this.counter++;
        return calc.division(dividend, divider);
    }
    
    /**
     * Умножение числа на чило
     * с увеличением счётчика выполненных операций.
     * @param factorOne первый множитель
     * @param factorTwo второй множитель
     * @return произведение множителей
     */
    public double multiplication(double factorOne, int factorTwo) {
        this.counter++;
        return calc.multiplication(factorOne, factorTwo);
    }
    
    /**
     * Нахождение разности двух чисел
     * с увеличением счётчика выполненных операций.
     * @param minuend  уменьшаемое
     * @param subtrahend  вычитаемое
     * @return  разность уменьшаемого и вычитаемого
     */
    public double subtraction(double minuend, double subtrahend) {
        this.counter++;
        return calc.subtraction(minuend, subtrahend);
    }
    
    /**
     * Сложение двух чисел с увеличением счётчика
     * выполненных операций.
     * @param numberOne первое слагаемое
     * @param numberTwo второе слагаемое
     * @return сумма слагаемых
     */
    public double addition(double numberOne, double numberTwo) {
        this.counter++;
        return calc.addition(numberOne, numberTwo);
    }
    
    /**
     * Возведение в целую степень дробного числа
     * с увеличением счётчика выполненных операций.
     * @param number дробное или целое число
     * @param power целочисленная степень
     * @return  результат возведения в степень
     */
    public double powerDouble(double number, int power) {
        this.counter++;
        return calc.powerDouble(number, power);
    }
    
    /**
     * Нахождение модуля от числа
     * с увеличением счётчика выполненных операций.
     * @param value дробное число.
     * @return неотрицательное дробное число.
     */
    public double absoluteValue(double value) {
        this.counter++;
         return calc.absoluteValue(value);
    }
    
    /**
     * Нахождение квадратного корня из числа.
     * @param value неотрицательное число
     * @return число, квадрат которого
     * меньше или равен числу-параметру.
     */
    public double squareRoot(double value) {
        this.counter++;
        return calc.squareRoot(value);
    }
    
    /**
     * Получение калькулятора,
     * которым затем будут выполнятся все вычисления.
     * @param calc
     */
    public CalculatorWithCounter(Calculator calc) {
        this.calc = calc;
    }
    
    /**
     * Возвращает значение счётчика совершенных операций.
     * @return количество совершенных операций
     */
    public int getCountOperation() {
        return this.counter;
    }
    
    /**
     * Возвращает ссылку на экземпляр используемого
     * для расчётов калькулятора.
     * @return ссылка на используемый калькулятор.
     */
    public Calculator getCalc() {
        return calc;
    }
}
