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
    
    /**
     * Точка входа и проверка созданных калькуляторов
     * разными входными данными.
     * @param args строки аргументов
     */
    public static void main(String[] args) {
        CalculatorMain calcM = new CalculatorMain();
        CalculatorWithOperator calc = new CalculatorWithOperator();
        calcM.test(calc);
    
        CalculatorWithMathCopy calcCopy = new CalculatorWithMathCopy();
        calcM.test(calcCopy);
        
        CalculatorWithMathExtends calcWithMath =
                new CalculatorWithMathExtends();
        calcM.test(calcWithMath);
    
        CalculatorWithCounter calc1 =
                new CalculatorWithCounter(new CalculatorWithOperator());
        CalculatorWithCounter calc2 =
                new CalculatorWithCounter(new CalculatorWithMathCopy());
        CalculatorWithCounter calc3 =
                new CalculatorWithCounter(new CalculatorWithMathExtends());
        
        calcM.test(calc1);
        System.out.println(calc1.getCountOperation());
        calcM.test(calc2);
        System.out.println(calc2.getCountOperation());
        calcM.test(calc3);
        System.out.println(calc3.getCountOperation());
        
        calcM.testCalcWithMemory();
    }
    
    /**
     * Тестирование всех калькуляторов пакета
     * кроме CalculatorWithCounter.
     * @param calc экземпляр калькулятора для вычислений
     */
    public void test(Calculator calc) {
        System.out.println(calc.getClass().getSimpleName());
//        System.out.println(calc.squareRoot(998001));
//        System.out.println(calc.squareRoot(28699));
//        System.out.println(calc.absoluteValue(-10));
//        System.out.println(calc.absoluteValue(10));
//        System.out.println(calc.powerDouble(1.5, 2));
//        System.out.println(calc.powerDouble(-1.5, 3));
//        System.out.println(calc.powerDouble(5, 2));
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
    
    /**
     * Тестирование всех калькуляторов типа CalculatorWithCounter.
     * @param calc экземпляр калькулятора для вычислений
     */
    public void test(CalculatorWithCounter calc) {
        System.out.print("CalculatorWithCounter uses ");
        System.out.println(calc.getCalc().getClass().getSimpleName()
                + " \n result and operations counter");
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
    
    /**
     * Вычисление выражения  "4.1 + 15 * 7 + (28 / 5) ^ 2"
     * с исползованием функции сохранения в память
     * результата последнего вычисления.
     */
    public void testCalcWithMemory() {
        System.out.println("CalculatorWithMemory "
                + "result and operations counter");
        CalculatorWithMemory calcWithMem =
                new CalculatorWithMemory(new CalculatorWithMathExtends());
        calcWithMem.powerDouble(calcWithMem.division(28, 5),2);
        calcWithMem.saveLastResult();
        calcWithMem.addition(calcWithMem.getMemory(),
                calcWithMem.multiplication(15, 7));
        calcWithMem.saveLastResult();
        calcWithMem.addition(4.1, calcWithMem.getMemory());
        calcWithMem.saveLastResult();
        System.out.println(calcWithMem.getMemory());
        System.out.println(calcWithMem.getCountOperation());
    }
}
