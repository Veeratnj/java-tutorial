import java.util.concurrent.*;
import java.util.concurrent.locks.*;

// 79_concurrent_collections.java - beginner-friendly example for 79 concurrent collections
public class 79ConcurrentCollections {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>(); map.put("a", 1); System.out.println(map);
    }
}
