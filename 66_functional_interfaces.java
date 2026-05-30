import java.util.*;

// 66_functional_interfaces.java - beginner-friendly example for 66 functional interfaces
public class 66FunctionalInterfaces {
    public static void main(String[] args) {
        Function<String, Integer> length = s -> s.length(); System.out.println(length.apply("Java"));
    }
}
