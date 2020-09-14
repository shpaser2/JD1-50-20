
package homework3;


public class CalculatorWithMathExtends extends CalculatorWithOperator
        implements Calculator {
    
    
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
    @Override
    public double powerDouble(double number, int power) {
        return Math.pow(number, power);
    }
    
    @Override
    public double absoluteValue(double value) {
        return Math.abs(value);
    }
    
    @Override
    public int squareRoot(int value) {
        return (int)Math.sqrt(value);
    }


    
}
