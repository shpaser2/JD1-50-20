package threads;

import threads.core.MyThread;
import threads.core.ThreadUtils;

public class ThreadMain1 {

//    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        ThreadUtils.printAboutCurrentThread();
        Thread th1 = new MyThread();
        th1.start();
        th1.stop();
    }
}
