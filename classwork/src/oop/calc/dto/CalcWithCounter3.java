package oop.calc.dto;

public class CalcWithCounter3 implements ICalcWithCounter{

    private long counter = 0;
    private final ICalc calc;

    public CalcWithCounter3(ICalc calc){
        this.calc = calc;
    }

    public double plus(double a, double b){
        this.counter++;
        return this.calc.plus(a, b);
    }

    public double minus(double a, double b){
        this.counter++;
        return this.calc.minus(a, b);
    }

    public double div(double a, double b){
        this.counter++;
        return this.calc.div(a, b);
    }

    public double add(double a, double b){
        this.counter++;
        return this.calc.add(a, b);
    }

    public double abs(double a){
        this.counter++;
        return this.calc.abs(a);
    }

    public double power(double a, int b){
        this.counter++;
        return this.calc.power(a, b);
    }

    public double sqrt(double a){
        this.counter++;
        return this.calc.sqrt(a);
    }

    public long getCounter() {
        return counter;
    }
}
