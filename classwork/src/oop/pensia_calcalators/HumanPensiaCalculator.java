package oop.pensia_calcalators;

import oop.ETypeMan;
import oop.Man;

public class HumanPensiaCalculator implements IPensiaCalculator{
    @Override
    public double calc(Man man) {
        if(!man.getType().equals(ETypeMan.HUMAN)){
            return 0;
        }
        //Много кода

        return 7 * man.getYearOld() * man.getHairLength();
    }
}
