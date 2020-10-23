package threads.core;

public class ThreadMain4 {
    public static void main(String[] args) {
        ThreadUtils.printAboutCurrentThread();
        Thread th1 = new Thread(new MyJobRepeatable());
//        th1.setDaemon(true);
        th1.start();
//        th1.setDaemon(true);

    }
}
