import java.util.*;
import java.util.*;

// 64_iterators.java - beginner-friendly example for 64 iterators
public class 64Iterators {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b"); Iterator<String> it = list.iterator(); while (it.hasNext()) { System.out.println(it.next()); }
    }
}
