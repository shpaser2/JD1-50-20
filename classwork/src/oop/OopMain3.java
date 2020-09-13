package oop;

import oop.pensia_calcalators.*;

import java.util.Scanner;

public class OopMain3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите вариант калькулятора");
        int variant = scanner.nextInt();

        Man man1 = new Man();
        man1.setType(ETypeMan.PRESIDENT);
        man1.setYearOld(68);

        Man man2 = new Man("Иван", 15);
        man2.setType(ETypeMan.HUMAN);
        man2.setYearOld(25);

        BuhMan buh = new BuhMan();
        System.out.println(buh.calc(getCalculator(variant), man1));
        System.out.println(buh.calc(getCalculator(variant), man2));
//        System.out.println(buh.calc(getCalculator(variant), buhMan));
    }

    public static IPensiaCalculator getCalculator(int variant){
        switch (variant){
            case 1:
                return new PresidentPensiaCalculator();
            case 2:
                return new MilitaryPensiaCalculator();
            case 3:
            default:
                return new HumanPensiaCalculator();
        }
    }
}
