/**
 * 24_AdvancedMultithreading.java - Advanced Concurrency
 * 
 * Covers Executor Framework, Callable, Future, volatile, and concurrency utilities
 */

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class AdvancedMultithreading {
    
    // volatile keyword - ensures visibility across threads
    private static volatile boolean running = true;
    
    // Atomic variable - thread-safe without synchronization
    private static AtomicInteger counter = new AtomicInteger(0);
    
    public static void main(String[] args) throws Exception {
        
        // ===== EXECUTOR FRAMEWORK =====
        
        System.out.println("=== EXECUTOR FRAMEWORK ===\n");
        
        // Fixed thread pool
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " executed by " + 
                                 Thread.currentThread().getName());
            });
        }
        
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
        
        
        // ===== CALLABLE AND FUTURE =====
        
        System.out.println("\n=== CALLABLE AND FUTURE ===\n");
        
        ExecutorService executor2 = Executors.newSingleThreadExecutor();
        
        // Callable returns a value
        Callable<Integer> task = () -> {
            Thread.sleep(1000);
            return 42;
        };
        
        Future<Integer> future = executor2.submit(task);
        
        System.out.println("Task submitted, doing other work...");
        
        // Get result (blocks until complete)
        Integer result = future.get();
        System.out.println("Result: " + result);
        
        executor2.shutdown();
        
        
        // ===== THREAD POOL TYPES =====
        
        System.out.println("\n=== THREAD POOL TYPES ===\n");
        
        // 1. Fixed Thread Pool
        ExecutorService fixed = Executors.newFixedThreadPool(2);
        System.out.println("Fixed pool created");
        fixed.shutdown();
        
        // 2. Cached Thread Pool
        ExecutorService cached = Executors.newCachedThreadPool();
        System.out.println("Cached pool created");
        cached.shutdown();
        
        // 3. Single Thread Executor
        ExecutorService single = Executors.newSingleThreadExecutor();
        System.out.println("Single thread executor created");
        single.shutdown();
        
        // 4. Scheduled Thread Pool
        ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(1);
        scheduled.schedule(() -> System.out.println("Delayed task"), 2, TimeUnit.SECONDS);
        scheduled.shutdown();
        
        
        // ===== VOLATILE KEYWORD =====
        
        System.out.println("\n=== VOLATILE KEYWORD ===\n");
        
        Thread writer = new Thread(() -> {
            try {
                Thread.sleep(1000);
                running = false;
                System.out.println("Writer: Set running to false");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        Thread reader = new Thread(() -> {
            while (running) {
                // Busy wait
            }
            System.out.println("Reader: Detected running is false");
        });
        
        writer.start();
        reader.start();
        writer.join();
        reader.join();
        
        
        // ===== ATOMIC VARIABLES =====
        
        System.out.println("\n=== ATOMIC VARIABLES ===\n");
        
        ExecutorService executor3 = Executors.newFixedThreadPool(3);
        
        for (int i = 0; i < 1000; i++) {
            executor3.submit(() -> counter.incrementAndGet());
        }
        
        executor3.shutdown();
        executor3.awaitTermination(5, TimeUnit.SECONDS);
        
        System.out.println("Counter value: " + counter.get());
        
        
        // ===== COUNTDOWNLATCH =====
        
        System.out.println("\n=== COUNTDOWNLATCH ===\n");
        
        CountDownLatch latch = new CountDownLatch(3);
        
        ExecutorService executor4 = Executors.newFixedThreadPool(3);
        
        for (int i = 1; i <= 3; i++) {
            final int workerId = i;
            executor4.submit(() -> {
                System.out.println("Worker " + workerId + " working...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Worker " + workerId + " done");
                latch.countDown();
            });
        }
        
        latch.await();  // Wait for all workers
        System.out.println("All workers completed!");
        
        executor4.shutdown();
        
        
        // ===== SEMAPHORE =====
        
        System.out.println("\n=== SEMAPHORE ===\n");
        
        Semaphore semaphore = new Semaphore(2);  // Only 2 permits
        
        ExecutorService executor5 = Executors.newFixedThreadPool(5);
        
        for (int i = 1; i <= 5; i++) {
            final int id = i;
            executor5.submit(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("Thread " + id + " acquired permit");
                    Thread.sleep(1000);
                    System.out.println("Thread " + id + " releasing permit");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        
        executor5.shutdown();
        executor5.awaitTermination(10, TimeUnit.SECONDS);
        
        
        System.out.println("\n=== SUMMARY ===\n");
        System.out.println("Executor: Manages thread pool");
        System.out.println("Callable: Returns value, throws exception");
        System.out.println("Future: Holds result of async computation");
        System.out.println("volatile: Ensures visibility across threads");
        System.out.println("Atomic: Thread-safe operations");
        System.out.println("CountDownLatch: Wait for multiple threads");
        System.out.println("Semaphore: Limit concurrent access");
    }
}

/*
 * KEY TAKEAWAYS:
 * 
 * EXECUTOR FRAMEWORK:
 * - Manages thread pool automatically
 * - newFixedThreadPool(n): Fixed number of threads
 * - newCachedThreadPool(): Creates threads as needed
 * - newSingleThreadExecutor(): Single worker thread
 * - newScheduledThreadPool(n): Scheduled tasks
 * 
 * CALLABLE & FUTURE:
 * - Callable: Like Runnable but returns value
 * - Future: Represents result of async computation
 * - get(): Blocks until result available
 * 
 * VOLATILE:
 * - Ensures variable visibility across threads
 * - Prevents caching in thread-local memory
 * - No atomicity guarantee
 * 
 * ATOMIC VARIABLES:
 * - Thread-safe without synchronization
 * - AtomicInteger, AtomicLong, AtomicBoolean
 * - incrementAndGet(), compareAndSet()
 * 
 * CONCURRENCY UTILITIES:
 * - CountDownLatch: Wait for N threads to complete
 * - Semaphore: Limit concurrent access
 * - CyclicBarrier: Threads wait for each other
 * 
 * COMPILE AND RUN:
 * javac 24_AdvancedMultithreading.java
 * java AdvancedMultithreading
 */
