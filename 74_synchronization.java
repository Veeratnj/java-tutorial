import java.util.concurrent.*;
import java.util.concurrent.locks.*;

// 74_synchronization.java - beginner-friendly example for 74 synchronization
public class 74Synchronization {
    public static void main(String[] args) {
        CounterSync counter = new CounterSync(); counter.increment(); System.out.println("Done");
    }
}

class CounterSync { private int count = 0; public void increment() { synchronized (this) { count++; } } }
