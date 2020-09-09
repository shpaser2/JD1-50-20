package oop;

public class Man {
    private String name = "Иван";
    private int hairLength = 5;
    private int variable1 = 1;
    protected int variable2 = 2;
    int variable3 = 3;
    public int variable4 = 4;
    
    public String sayHello() {
        return "Привет";
    }
    
    public void grow() {
        hairLength++;
    }

    @Override
    public String toString() {
        return "Имя : " + this.name + ", Длина волос : " + this.hairLength;
    }
    
    private String random() {
        return "sdsdfdasgfgsrfhfasfgs";
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getHairLength() {
        return this.hairLength;
    }
    
    public Man() {
        this.name = "Иван";
        this.hairLength = 5;
    }
    
    public Man(String name, int hairLength) {
        this.name = name;
        this.hairLength = hairLength;
    }
}
