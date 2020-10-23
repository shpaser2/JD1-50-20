package threads.core;

public class ThreadUtils {
    public static void printAboutCurrentThread(){
        Thread current = Thread.currentThread();
        System.out.println("Id = " + current.getId());
        System.out.println("Name = " + current.getName());
        System.out.println("ThreadGroup = " + current.getThreadGroup());
        System.out.println("Priority = " + current.getPriority());
        System.out.println("State = " + current.getState());
        System.out.println("Daemon = " + current.isDaemon());
        System.out.println("Alive = " + current.isAlive());
        System.out.println("____________________________");
    }
}
