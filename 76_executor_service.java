import java.util.concurrent.*;

// 76_executor_service.java - beginner-friendly example for 76 executor service
public class 76ExecutorService {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2); executor.submit(() -> System.out.println("Task")); executor.shutdown();
    }
}
