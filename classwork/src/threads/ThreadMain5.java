package threads;

import threads.core.MyJobRepeatable;
import threads.core.MyJobRepeatableNotInf;
import threads.core.ThreadUtils;

public class ThreadMain5 {
    public static void main(String[] args) {
        ThreadUtils.printAboutCurrentThread();
        Thread th1 = new Thread(new MyJobRepeatableNotInf());

//        th1.setDaemon(true);
        th1.start();
        try {
            th1.join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("А головной поток уже закончил работать");
    }
}
