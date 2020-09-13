package oop;

import oop.pensia_calcalators.*;

public class OopMain4 {
    public static void main(String[] args) {
        Man man1 = new Man();
        man1.setType(ETypeMan.PRESIDENT);
        man1.setYearOld(68);

        Man man2 = new Man("Иван", 15);
        man2.setType(ETypeMan.HUMAN);
        man2.setYearOld(25);

        BuhMan buh = new BuhMan();
        IPensiaCalculator calculator = new MultiPensiaCalculator();
        System.out.println(buh.calc(calculator, man1));
        System.out.println(buh.calc(calculator, man2));
//        System.out.println(buh.calc(getCalculator(variant), buhMan));
    }

}
