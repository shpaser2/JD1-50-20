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
 * Есть функция памяти значения:
 * При записи затирает предыдущее значение,
 * при вычитывании обнуляет хранимое значение.
 * Есть подсчёт выполненных операций.
 *
 * @version   1.00 14.09.2020
 * @author    Сергей Шпаковский
 */
public class CalculatorWithMemory implements Calculator {
    private int counter = 0;
    private double memory = 0;
    private double result = 0;
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
        this.result = calc.division(dividend, divider);
        return this.result;
    }
    
    /**
     * Умножение числа на чило
     * с увеличением счётчика выполненных операций.
     * @param factorOne первый множитель
     * @param factorTwo второй множитель
     * @return произведение множителей
     */
    public double multiplication(double factorOne, double factorTwo) {
        this.counter++;
        this.result = calc.multiplication(factorOne, factorTwo);
        return this.result;
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
        this.result = calc.subtraction(minuend, subtrahend);
        return this.result;
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
        this.result = calc.addition(numberOne, numberTwo);
        return this.result;
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
        this.result = calc.powerDouble(number, power);
        return this.result;
    }
    
    /**
     * Нахождение модуля от числа
     * с увеличением счётчика выполненных операций.
     * @param value дробное число.
     * @return неотрицательное дробное число.
     */
    public double absoluteValue(double value) {
        this.counter++;
        this.result = calc.absoluteValue(value);
        return this.result;
    }
    
    /**
     * Нахождение квадратного корня из числа.
     * @param value неотрицательное число
     * @return число, квадрат которого
     * меньше или равен числу-параметру.
     */
    public double squareRoot(double value) {
        this.counter++;
        this.result = calc.squareRoot(value);
        return this.result;
    }
    
    /**
     * Получение калькулятора,
     * которым затем будут выполнятся все вычисления.
     * @param calc
     */
    public CalculatorWithMemory(Calculator calc) {
        this.calc = calc;
    }
    
    /**
     * Возвращает значение счётчика совершенных операций.
     * @return количество совершенных операций.
     */
    public int getCountOperation() {
        return this.counter;
    }
    
    /**
     * Возвращает сохраненное ранее в памяти значение
     * и убирает его из памяти.
     * @return последнее значение, хранившееся в памяти.
     */
    public double getMemory() {
        double buffer = this.memory;
        setMemory(0);
        return buffer;
    }
    
    /**
     * Перезаписывает в память передаваемое значение.
     * @param memory значение, которое нужно сохранить в памяти.
     */
    public void setMemory(double memory) {
        this.memory = memory;
    }
    
    /**
     * Сохраняет в памяти результат выполнения последней операции
     * или сохраняет ноль, если небыло действий.
     */
    public void saveLastResult() {
        this.memory = this.result;
    }
}
