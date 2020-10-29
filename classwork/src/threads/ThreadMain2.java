package threads;

import threads.core.MyJob;
import threads.core.MyThread;
import threads.core.ThreadUtils;

public class ThreadMain2 {
    public static void main(String[] args) {
        ThreadUtils.printAboutCurrentThread();
        Thread th1 = new Thread(new MyJob());
        th1.start();
    }
}
