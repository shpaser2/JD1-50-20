package oop.calc.dto;

public class FizikOld {
    private final ICalc calc;

    public FizikOld(ICalc calc) {
        this.calc = calc;
    }

    public double calc(int a, int b){
        return this.calc.minus(a, b);
    }

    public ICalc getCalc(){
        return this.calc;
    }
}
