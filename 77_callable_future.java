import java.util.concurrent.*;

// 77_callable_future.java - beginner-friendly example for 77 callable future
public class 77CallableFuture {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor(); Callable<Integer> task = () -> 42; Future<Integer> future = executor.submit(task); System.out.println(future.get()); executor.shutdown();
    }
}
