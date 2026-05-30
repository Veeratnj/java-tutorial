import java.util.*;

// 67_stream_api.java - beginner-friendly example for 67 stream api
public class 67StreamApi {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4); int sum = numbers.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum(); System.out.println(sum);
    }
}
