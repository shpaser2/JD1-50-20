
package homework3;

import java.util.ArrayList;

public class CalculatorWithOperator {
    
    //4 метода (деления, умножение, вычитание, сложение) каждый из этих
    // методов должен принимать два параметра (определитесь с их типами)
    // и должны возвращать результать
    // (определиться с возвращаемым типом результата)
    // при помощи ключевого слово return.
    
    //3.1.1
    public double division(double dividend, double divider) {
        return dividend / divider;
    }
    
    public double multiplication(double factorOne, int factorTwo) {
        return factorOne * factorTwo;
    }
    
    public double subtraction(double minuend, double subtrahend) {
        return minuend - subtrahend;
    }
    
    public double addition(double numberOne, double numberTwo) {
        return numberOne + numberTwo;
    }
    //end 3.1.1
    
    //1.2 Также должно быть ещё 2-3 метода
    // (Возведение в степень дробного положительного числа в целую степень,
    // Модуль числа, Корень из числа**).
    // В методах можно использовать оператор + / * -.
    // Использование библиотеки Math ЗАПРЕЩЕНО!.
    
    //3.1.2
    public double powerDouble(double number, int power) {
        while (power > 1) {
            number *= number;
            power--;
        }
        return number;
    }
    
    public double absoluteValue(double value) {
        return value > 0? value : -value;
    }
    
    public int squareRoot(int value) {
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        
        while (value % 100 > 0) {
            arrList.add(value % 100);
            value /= 100;
        }
    
        int remainder = 0;
        int result = 0;
        for (int index = arrList.size() - 1; index >= 0; index--) {
            remainder = remainder * 100 + arrList.get(index);
            int numberX = 0;
            for (int i = 1; i < 10; i++) {
                int buffer = ((result * 2) * 10 + i) * i;
                int diff = remainder - buffer;
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
