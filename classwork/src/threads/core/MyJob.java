package threads.core;

public class MyJob implements Runnable {
    @Override
    public void run() {
        ThreadUtils.printAboutCurrentThread();
        System.out.println("456");
    }
}
