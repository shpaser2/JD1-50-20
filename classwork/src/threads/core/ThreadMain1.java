package threads.core;

public class ThreadMain1 {
    public static void main(String[] args) {
        ThreadUtils.printAboutCurrentThread();
        Thread th1 = new MyThread();
       // th1.start();    //do all work in other thread
        th1.run();      //just do all work in main
    }
}