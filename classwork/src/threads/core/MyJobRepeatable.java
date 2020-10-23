package threads.core;

import java.util.concurrent.TimeUnit;

public class MyJobRepeatable implements Runnable {
    @Override
    public void run() {
        String oldName = Thread.currentThread().getName();
        Thread.currentThread().setName("Заказ 7777");
        try {
            ThreadUtils.printAboutCurrentThread();
            while (1 == 1){
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "_");
            }
        } finally {
            Thread.currentThread().setName(oldName);
        }
    }
}
