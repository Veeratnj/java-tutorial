import java.util.concurrent.*;

// 71_threads_basics.java - beginner-friendly example for 71 threads basics
public class 71ThreadsBasics {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("Thread running")); thread.start();
    }
}
