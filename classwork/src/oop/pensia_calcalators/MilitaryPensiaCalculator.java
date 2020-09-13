package oop.pensia_calcalators;

import oop.ETypeMan;
import oop.Man;

public class MilitaryPensiaCalculator implements IPensiaCalculator {
    @Override
    public double calc(Man man) {
        if(!man.getType().equals(ETypeMan.MILITARY)){
            return 0;
        }
        //Много кода

        return 10 * man.getYearOld();
    }
}
