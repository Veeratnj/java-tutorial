import java.util.Optional;

// 68_optional.java - beginner-friendly example for 68 optional
public class 68Optional {
    public static void main(String[] args) {
        Optional<String> value = Optional.of("Hello"); value.ifPresent(System.out::println);
    }
}
