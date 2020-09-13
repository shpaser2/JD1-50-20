package oop.pensia_calcalators;

import oop.Man;

public class MultiPensiaCalculator implements IPensiaCalculator{

    @Override
    public double calc(Man man) {
        return getCalculator(man).calc(man);
    }

    public IPensiaCalculator getCalculator(Man man){
        switch (man.getType()){
            case PRESIDENT:
                return new PresidentPensiaCalculator();
            case MILITARY:
                return new MilitaryPensiaCalculator();
            case HUMAN:
            default:
                return new HumanPensiaCalculator();
        }
    }
}
