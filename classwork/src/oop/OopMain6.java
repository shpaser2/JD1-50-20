package oop;

public class OopMain6 {
    public static void main(String[] args) {
        Lamp lamp1 = new Lamp();
        lamp1.on();
        Lamp.isState();

        Lamp lamp2 = new Lamp();
        lamp2.off();

        System.out.println(lamp1.isState());
        System.out.println(lamp2.isState());

        lamp1.on();

        System.out.println(lamp1.isState());
        System.out.println(lamp2.isState());

    }
}
