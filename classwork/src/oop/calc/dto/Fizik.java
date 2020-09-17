package oop.calc.dto;

public class Fizik<T extends ICalc> {
    private final T calc;

    public Fizik(T calc) {
        this.calc = calc;
    }

    public double calc(int a, int b){
        return this.calc.minus(a, b);
    }

    public T getCalc(){
        return this.calc;
    }
}
