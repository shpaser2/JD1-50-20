package oop.calc.dto;

public class CalcWithCopy implements ICalc{
    public double plus(double a, double b){
        return a + b;
    }

    public double minus(double a, double b){
        return a - b;
    }

    public double div(double a, double b){
        return a / b;
    }

    public double add(double a, double b){
        return a * b;
    }

    public double abs(double a){
        return Math.abs(a);
    }

    public double power(double a, int b){
        return Math.pow(a, b);
    }

    public double sqrt(double a){
        return Math.sqrt(a);
    }
}
