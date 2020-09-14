package homework3;

public class CalculatorWithMemory implements Calculator {
    private int counter = 0;
    private double memory = 0;
    private Calculator calc;
    
    
    public double division(double dividend, double divider) {
        this.counter++;
        return calc.division(dividend, divider);
    }
    
    
    public double multiplication(double factorOne, int factorTwo) {
        this.counter++;
        return calc.multiplication(factorOne, factorTwo);
    }
    
    
    public double subtraction(double minuend, double subtrahend) {
        this.counter++;
        return calc.subtraction(minuend, subtrahend);
    }
    
    
    public double addition(double numberOne, double numberTwo) {
        this.counter++;
        return calc.addition(numberOne, numberTwo);
    }
    

    public double powerDouble(double number, int power) {
        this.counter++;
        return calc.powerDouble(number, power);
    }
    
    
    public double absoluteValue(double value) {
        this.counter++;
        return calc.absoluteValue(value);
    }
    
    
    public int squareRoot(int value) {
        this.counter++;
        return calc.squareRoot(value);
    }
    
    
    public CalculatorWithMemory(Calculator calc) {
        this.calc = calc;
    }
    
    
    public int getCountOperation() {
        return this.counter;
    }
    
    
    public double getMemory() {
        double buffer = this.memory;
        setMemory(0);
        return buffer;
    }
    
    
    public void setMemory(double memory) {
        this.memory = memory;
    }
}