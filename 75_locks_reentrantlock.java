import java.util.concurrent.*;
import java.util.concurrent.locks.*;

// 75_locks_reentrantlock.java - beginner-friendly example for 75 locks reentrantlock
public class 75LocksReentrantlock {
    public static void main(String[] args) {
        CounterLock counter = new CounterLock(); counter.increment(); System.out.println("Done");
    }
}

class CounterLock { private int count = 0; private final Lock lock = new ReentrantLock(); public void increment() { lock.lock(); try { count++; } finally { lock.unlock(); } } }
