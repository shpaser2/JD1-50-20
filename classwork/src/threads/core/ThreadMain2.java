package threads.core;

public class ThreadMain2 {
    public static void main(String[] args) {
        ThreadUtils.printAboutCurrentThread();
        Thread th1 = new Thread(new MyJob());
        th1.start();   //run in another thread
    }
}