import java.util.*;

// 69_method_references.java - beginner-friendly example for 69 method references
public class 69MethodReferences {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("a", "b"); items.forEach(System.out::println);
    }
}
