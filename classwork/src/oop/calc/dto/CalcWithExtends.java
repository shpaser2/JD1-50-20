package oop.calc.dto;

public class CalcWithExtends extends CalcWithOperator implements ICalc{

    public double abs(double a){
        return Math.abs(a);
    }

    public double power(double a, int b){
        return Math.pow(a, b);
    }

    public double sqrt(double a){
        return super.sqrt(a);
    }
}
