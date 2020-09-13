package oop;

import oop.pensia_calcalators.IPensiaCalculator;

public class BuhMan {

    public double calc(IPensiaCalculator calculator, Man man){
        return calculator.calc(man);
    }
}
