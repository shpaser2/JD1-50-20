package threads;

import threads.core.MyJob;
import threads.core.MyJobRepeatable;
import threads.core.ThreadUtils;

public class ThreadMain4 {
    public static void main(String[] args) {
        ThreadUtils.printAboutCurrentThread();
        Thread th1 = new Thread(new MyJobRepeatable());

        th1.start();
        th1.setDaemon(true);
    }
}
