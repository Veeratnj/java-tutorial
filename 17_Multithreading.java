/**
 * 17_Multithreading.java - Multithreading Tutorial
 * 
 * Multithreading allows concurrent execution of two or more parts of a program.
 * This tutorial covers thread creation, synchronization, and basic concepts.
 */

// Thread by extending Thread class
class MyThread extends Thread {
    private String name;
    
    public MyThread(String name) {
        this.name = name;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + ": " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Thread by implementing Runnable
class MyRunnable implements Runnable {
    private String name;
    
    public MyRunnable(String name) {
        this.name = name;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + ": " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Synchronized example
class Counter {
    private int count = 0;
    
    public synchronized void increment() {
        count++;
    }
    
    public int getCount() {
        return count;
    }
}

public class Multithreading {
    public static void main(String[] args) {
        
        // ===== EXTENDING THREAD CLASS =====
        
        System.out.println("=== EXTENDING THREAD ===\n");
        
        MyThread thread1 = new MyThread("Thread-1");
        MyThread thread2 = new MyThread("Thread-2");
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // ===== IMPLEMENTING RUNNABLE =====
        
        System.out.println("\n=== IMPLEMENTING RUNNABLE ===\n");
        
        Thread thread3 = new Thread(new MyRunnable("Runnable-1"));
        Thread thread4 = new Thread(new MyRunnable("Runnable-2"));
        
        thread3.start();
        thread4.start();
        
        try {
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // ===== LAMBDA EXPRESSION =====
        
        System.out.println("\n=== LAMBDA EXPRESSION ===\n");
        
        Thread thread5 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Lambda thread: " + i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        thread5.start();
        
        try {
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // ===== SYNCHRONIZATION =====
        
        System.out.println("\n=== SYNCHRONIZATION ===\n");
        
        Counter counter = new Counter();
        
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        
        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Final count: " + counter.getCount());
        
        // ===== THREAD INFORMATION =====
        
        System.out.println("\n=== THREAD INFORMATION ===\n");
        
        Thread current = Thread.currentThread();
        System.out.println("Current thread: " + current.getName());
        System.out.println("Thread ID: " + current.getId());
        System.out.println("Thread priority: " + current.getPriority());
        System.out.println("Is alive: " + current.isAlive());
    }
}

/*
 * KEY TAKEAWAYS:
 * - Two ways to create threads: extend Thread or implement Runnable
 * - start() begins thread execution, run() contains thread code
 * - join() waits for thread to complete
 * - sleep() pauses thread execution
 * - synchronized prevents race conditions
 * - Prefer Runnable over Thread (better design)
 * 
 * THREAD LIFECYCLE:
 * 1. New: Thread created but not started
 * 2. Runnable: Thread ready to run
 * 3. Running: Thread executing
 * 4. Blocked/Waiting: Thread waiting for resource
 * 5. Terminated: Thread finished execution
 * 
 * COMPILE AND RUN:
 * javac 17_Multithreading.java
 * java Multithreading
 */
