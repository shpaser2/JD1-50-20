package oop;

public class Lamp {
    private boolean state;

    public void on(){
        this.state = true;
    }

    public void off(){
        this.state = false;
    }

    public static boolean isState() {
//        return state;
        return true;
    }
}
