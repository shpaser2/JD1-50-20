package oop;

public class OopMain1 {
    public static void main(String[] args) {
        Man man1 = new Man();
        Man man2 = new Man("Антон", 15);

        System.out.println(man1.getName());
        System.out.println(man1.getHairLength());
        System.out.println("_______");
        System.out.println(man1.getName() + " : " + man1.getHairLength());
        System.out.println(man1.getHairLength() + " : " + man1.getName());
        System.out.println(man2.toString());
    }
}
