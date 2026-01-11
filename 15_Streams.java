/**
 * 15_Streams.java - Java Stream API Tutorial (Java 8+)
 * 
 * The Stream API provides a functional approach to processing collections of objects.
 * Streams support operations like filter, map, reduce, and collect.
 */

import java.util.*;
import java.util.stream.*;

public class Streams {
    public static void main(String[] args) {
        
        // ===== CREATING STREAMS =====
        
        System.out.println("=== CREATING STREAMS ===\n");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream = numbers.stream();
        
        // ===== FILTER =====
        
        System.out.println("=== FILTER ===\n");
        
        List<Integer> evenNumbers = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);
        
        // ===== MAP =====
        
        System.out.println("\n=== MAP ===\n");
        
        List<Integer> squared = numbers.stream()
            .map(n -> n * n)
            .collect(Collectors.toList());
        System.out.println("Squared: " + squared);
        
        List<String> names = Arrays.asList("alice", "bob", "charlie");
        List<String> upperNames = names.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        System.out.println("Uppercase names: " + upperNames);
        
        // ===== REDUCE =====
        
        System.out.println("\n=== REDUCE ===\n");
        
        int sum = numbers.stream()
            .reduce(0, (a, b) -> a + b);
        System.out.println("Sum: " + sum);
        
        int product = numbers.stream()
            .reduce(1, (a, b) -> a * b);
        System.out.println("Product: " + product);
        
        // ===== SORTED =====
        
        System.out.println("\n=== SORTED ===\n");
        
        List<Integer> unsorted = Arrays.asList(5, 2, 8, 1, 9);
        List<Integer> sorted = unsorted.stream()
            .sorted()
            .collect(Collectors.toList());
        System.out.println("Sorted: " + sorted);
        
        List<Integer> reverseSorted = unsorted.stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
        System.out.println("Reverse sorted: " + reverseSorted);
        
        // ===== DISTINCT =====
        
        System.out.println("\n=== DISTINCT ===\n");
        
        List<Integer> duplicates = Arrays.asList(1, 2, 2, 3, 3, 3, 4);
        List<Integer> unique = duplicates.stream()
            .distinct()
            .collect(Collectors.toList());
        System.out.println("Unique: " + unique);
        
        // ===== LIMIT AND SKIP =====
        
        System.out.println("\n=== LIMIT AND SKIP ===\n");
        
        List<Integer> first5 = numbers.stream()
            .limit(5)
            .collect(Collectors.toList());
        System.out.println("First 5: " + first5);
        
        List<Integer> skip5 = numbers.stream()
            .skip(5)
            .collect(Collectors.toList());
        System.out.println("Skip 5: " + skip5);
        
        // ===== COUNT, MIN, MAX =====
        
        System.out.println("\n=== COUNT, MIN, MAX ===\n");
        
        long count = numbers.stream().count();
        System.out.println("Count: " + count);
        
        Optional<Integer> min = numbers.stream().min(Integer::compareTo);
        System.out.println("Min: " + min.orElse(0));
        
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        System.out.println("Max: " + max.orElse(0));
        
        // ===== ANY MATCH, ALL MATCH, NONE MATCH =====
        
        System.out.println("\n=== MATCHING ===\n");
        
        boolean hasEven = numbers.stream().anyMatch(n -> n % 2 == 0);
        System.out.println("Has even number: " + hasEven);
        
        boolean allPositive = numbers.stream().allMatch(n -> n > 0);
        System.out.println("All positive: " + allPositive);
        
        boolean noneNegative = numbers.stream().noneMatch(n -> n < 0);
        System.out.println("None negative: " + noneNegative);
        
        // ===== CHAINING OPERATIONS =====
        
        System.out.println("\n=== CHAINING ===\n");
        
        List<Integer> result = numbers.stream()
            .filter(n -> n % 2 == 0)
            .map(n -> n * 2)
            .sorted(Comparator.reverseOrder())
            .limit(3)
            .collect(Collectors.toList());
        System.out.println("Even, doubled, sorted desc, top 3: " + result);
        
        // ===== FOR EACH =====
        
        System.out.println("\n=== FOR EACH ===\n");
        
        System.out.print("Numbers: ");
        numbers.stream()
            .filter(n -> n <= 5)
            .forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
}

/*
 * KEY TAKEAWAYS:
 * - Streams don't store data, they process it
 * - Intermediate operations: filter, map, sorted (return Stream)
 * - Terminal operations: collect, reduce, forEach (return result)
 * - Streams can only be used once
 * - Lazy evaluation: operations execute only when terminal operation is called
 * 
 * COMMON OPERATIONS:
 * - filter(): Select elements
 * - map(): Transform elements
 * - reduce(): Combine elements
 * - collect(): Gather results
 * - sorted(): Sort elements
 * - distinct(): Remove duplicates
 * 
 * COMPILE AND RUN:
 * javac 15_Streams.java
 * java Streams
 */
