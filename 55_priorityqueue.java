import java.util.*;

// 55_priorityqueue.java - beginner-friendly example for 55 priorityqueue
public class 55Priorityqueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); pq.offer(30); pq.offer(10); System.out.println(pq.poll());
    }
}
