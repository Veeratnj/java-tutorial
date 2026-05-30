import java.util.concurrent.*;

// 78_completable_future.java - beginner-friendly example for 78 completable future
public class 78CompletableFuture {
    public static void main(String[] args) {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> "Done").thenAccept(System.out::println); future.get();
    }
}
