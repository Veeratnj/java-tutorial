import java.util.concurrent.*;

// 72_runnable_interface.java - beginner-friendly example for 72 runnable interface
public class 72RunnableInterface {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("Runnable task"); new Thread(task).start();
    }
}
