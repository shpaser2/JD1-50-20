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
 * Класс тестирования калькуляторов.
 * Здесь есть проверка методов калькуляторов,
 * перечисленных в интерфейсе Calculator.
 *
 * @version   1.00 14.09.2020
 * @author    Сергей Шпаковский
 */
public class CalculatorMain {
    
    public static void main(String[] args) {
        CalculatorMain calcM = new CalculatorMain();
        CalculatorWithOperator calc = new CalculatorWithOperator();
        calcM.test(calc);
    
        CalculatorWithOperatorCopy calcCopy = new CalculatorWithOperatorCopy();
        calcM.test(calcCopy);
        
        CalculatorWithMathExtends calcWithMath =
                new CalculatorWithMathExtends();
        calcM.test(calcWithMath);
    
        CalculatorWithCounter calc1 =
                new CalculatorWithCounter(new CalculatorWithOperator());
        CalculatorWithCounter calc2 =
                new CalculatorWithCounter(new CalculatorWithOperatorCopy());
        CalculatorWithCounter calc3 =
                new CalculatorWithCounter(new CalculatorWithMathExtends());
        
        calcM.test(calc1);
        System.out.println(calc1.getCountOperation());
        calcM.test(calc2);
        System.out.println(calc2.getCountOperation());
        calcM.test(calc3);
        System.out.println(calc3.getCountOperation());
    
    
        System.out.println("CalculatorWithMemory "
                + "result and operations counter");
        CalculatorWithMemory calcWithMem =
                new CalculatorWithMemory(new CalculatorWithMathExtends());
        calcWithMem.setMemory(
                calcWithMem.powerDouble(calcWithMem.division(28, 5),2));
        calcWithMem.setMemory(calcWithMem.addition(calcWithMem.getMemory(),
                calcWithMem.multiplication(15, 7)));
        calcWithMem.setMemory(
                calcWithMem.addition(4.1, calcWithMem.getMemory()));
        System.out.println(calcWithMem.getMemory());
        System.out.println(calcWithMem.getCountOperation());
    }
    
    public void test(Calculator calc) {
        System.out.println(calc.getClass().getSimpleName()
                + " result and operations counter");
        
        System.out.println(calc.squareRoot(343396));
        System.out.println(calc.squareRoot(998001));
        System.out.println(calc.squareRoot(28699));
        System.out.println(calc.absoluteValue(-10));
        System.out.println(calc.absoluteValue(10));
        System.out.println(calc.powerDouble(1.5, 2));
        System.out.println(calc.powerDouble(-1.5, 2));
        System.out.println(calc.powerDouble(5, 2));
        
        double result = 0;
        result = calc.addition(4.1, calc.multiplication(15, 7));
        result = calc.addition(result, calc.powerDouble(
                calc.division(28, 5),2));
        System.out.println(result);
        //3.2.1
        System.out.println(calc.division(result, 0));
        //3.2.2
        System.out.println(calc.division(result, 0.0d));
    }
    
    public void test(CalculatorWithCounter calc) {
        System.out.print("CalculatorWithCounter uses ");
        System.out.println(calc.getCalc().getClass().getSimpleName());
        
        //3.1.1, 3.1.2
        System.out.println(calc.squareRoot(343396));
        System.out.println(calc.squareRoot(998001));
        System.out.println(calc.squareRoot(28699));
        System.out.println(calc.absoluteValue(-10));
        System.out.println(calc.absoluteValue(10));
        System.out.println(calc.powerDouble(1.5, 2));
        System.out.println(calc.powerDouble(-1.5, 2));
        System.out.println(calc.powerDouble(5, 2));
        double result = 0;
        result = calc.addition(4.1, calc.multiplication(15, 7));
        result = calc.addition(result, calc.powerDouble(
                calc.division(28, 5),2));
        System.out.println(result);
        //3.2.1
        System.out.println(calc.division(result, 0));
        //3.2.2
        System.out.println(calc.division(result, 0.0d));
    }
}
