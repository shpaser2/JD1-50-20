package threads.core;

public class MyThread extends Thread{

    public MyThread() {
    }

    public MyThread(Runnable target) {
        super(target);
    }

    @Override
    public synchronized void start() {
        System.out.println(System.currentTimeMillis());
        super.start();
        System.out.println(System.currentTimeMillis());
    }

    @Override
    public void run() {
        ThreadUtils.printAboutCurrentThread();
        System.out.println("123");
        super.run();
    }
}
