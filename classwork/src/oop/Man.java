package oop;

import oop.ETypeMan;

import java.util.Iterator;

public class Man implements Comparable<Man> {
    private String name;
    private int hairLength;
    private int yearOld;
    private ETypeMan type;

    protected int variable2;
    int variable3;

    public Man(){
        this.name = "Иван";
        this.hairLength = 5;
    }

    public Man(String name, int hairLength){
        this.name = name;
        this.hairLength = hairLength;
    }

    public ETypeMan getType() {
        return type;
    }

    public void setType(ETypeMan type) {
        this.type = type;
    }

    public int getYearOld() {
        return yearOld;
    }

    public void setYearOld(int yearOld) {
        this.yearOld = yearOld;
    }

    public String getName(){
        return this.name;
    }

    private String random(){
        return "adjsamnjbsldkjbhnadks";
    }

    public int getHairLength(){
        return this.hairLength;
    }

    public String sayHello() {
        return "Привет!";
    }

    public void grow() {
        hairLength++;
    }

    public String toString() {
        return "Имя : " + this.name + ", Длинна волос : " + this.hairLength;
    }

    @Override
    public int compareTo(Man o) {
        return this.hairLength - o.hairLength;
    }
}
