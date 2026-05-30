import java.util.concurrent.*;

// 73_thread_lifecycle.java - beginner-friendly example for 73 thread lifecycle
public class 73ThreadLifecycle {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> System.out.println("Started")); thread.start(); thread.join(); System.out.println("Main finished");
    }
}
