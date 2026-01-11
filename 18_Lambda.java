/**
 * 18_Lambda.java - Lambda Expressions Tutorial (Java 8+)
 * 
 * Lambda expressions provide a clear and concise way to represent one method
 * interface using an expression. They enable functional programming in Java.
 */

import java.util.*;
import java.util.function.*;

// Functional interface
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

public class Lambda {
    public static void main(String[] args) {
        
        // ===== BASIC LAMBDA EXPRESSIONS =====
        
        System.out.println("=== BASIC LAMBDA ===\n");
        
        // Lambda with functional interface
        Calculator add = (a, b) -> a + b;
        Calculator subtract = (a, b) -> a - b;
        Calculator multiply = (a, b) -> a * b;
        
        System.out.println("10 + 5 = " + add.calculate(10, 5));
        System.out.println("10 - 5 = " + subtract.calculate(10, 5));
        System.out.println("10 * 5 = " + multiply.calculate(10, 5));
        
        // Lambda with multiple statements
        Calculator divide = (a, b) -> {
            if (b == 0) {
                System.out.println("Cannot divide by zero!");
                return 0;
            }
            return a / b;
        };
        
        System.out.println("10 / 2 = " + divide.calculate(10, 2));
        
        // ===== LAMBDA WITH NO PARAMETERS =====
        
        System.out.println("\n=== NO PARAMETERS ===\n");
        
        Runnable task = () -> System.out.println("Task executed!");
        task.run();
        
        // ===== LAMBDA WITH ONE PARAMETER =====
        
        System.out.println("\n=== ONE PARAMETER ===\n");
        
        Greeting greet = name -> System.out.println("Hello, " + name + "!");
        greet.sayHello("Alice");
        
        // ===== BUILT-IN FUNCTIONAL INTERFACES =====
        
        System.out.println("\n=== PREDICATE ===\n");
        
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4));
        System.out.println("Is 5 even? " + isEven.test(5));
        
        System.out.println("\n=== FUNCTION ===\n");
        
        Function<String, Integer> stringLength = s -> s.length();
        System.out.println("Length of 'Hello': " + stringLength.apply("Hello"));
        
        System.out.println("\n=== CONSUMER ===\n");
        
        Consumer<String> printer = s -> System.out.println("Message: " + s);
        printer.accept("Hello, World!");
        
        System.out.println("\n=== SUPPLIER ===\n");
        
        Supplier<Double> randomNumber = () -> Math.random();
        System.out.println("Random number: " + randomNumber.get());
        
        // ===== LAMBDA WITH COLLECTIONS =====
        
        System.out.println("\n=== LAMBDA WITH COLLECTIONS ===\n");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        // forEach with lambda
        System.out.print("Numbers: ");
        numbers.forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // Sorting with lambda
        List<String> names = Arrays.asList("Charlie", "Alice", "Bob");
        names.sort((a, b) -> a.compareTo(b));
        System.out.println("Sorted names: " + names);
        
        // Filtering with lambda
        List<Integer> evenNumbers = new ArrayList<>();
        numbers.forEach(n -> {
            if (n % 2 == 0) {
                evenNumbers.add(n);
            }
        });
        System.out.println("Even numbers: " + evenNumbers);
        
        // ===== METHOD REFERENCES =====
        
        System.out.println("\n=== METHOD REFERENCES ===\n");
        
        // Static method reference
        Function<String, Integer> parser = Integer::parseInt;
        System.out.println("Parsed '123': " + parser.apply("123"));
        
        // Instance method reference
        String text = "hello";
        Supplier<String> upperCase = text::toUpperCase;
        System.out.println("Uppercase: " + upperCase.get());
        
        // Constructor reference
        Supplier<ArrayList<String>> listSupplier = ArrayList::new;
        ArrayList<String> newList = listSupplier.get();
        newList.add("Item");
        System.out.println("New list: " + newList);
        
        // ===== LAMBDA EXAMPLES =====
        
        System.out.println("\n=== PRACTICAL EXAMPLES ===\n");
        
        // Filter and print
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        System.out.print("Even numbers: ");
        nums.stream()
            .filter(n -> n % 2 == 0)
            .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // Map and collect
        List<Integer> squared = nums.stream()
            .map(n -> n * n)
            .toList();
        System.out.println("Squared: " + squared);
        
        // Reduce
        int sum = nums.stream()
            .reduce(0, (a, b) -> a + b);
        System.out.println("Sum: " + sum);
    }
}

/*
 * KEY TAKEAWAYS:
 * - Lambda syntax: (parameters) -> expression
 * - For single parameter: parameter -> expression
 * - For multiple statements: (params) -> { statements }
 * - Functional interface: Interface with single abstract method
 * - Method references: Class::method (shorthand for lambdas)
 * 
 * BUILT-IN FUNCTIONAL INTERFACES:
 * - Predicate<T>: T -> boolean (test())
 * - Function<T,R>: T -> R (apply())
 * - Consumer<T>: T -> void (accept())
 * - Supplier<T>: () -> T (get())
 * - BiFunction<T,U,R>: (T,U) -> R
 * 
 * METHOD REFERENCE TYPES:
 * - Static: ClassName::staticMethod
 * - Instance: instance::instanceMethod
 * - Constructor: ClassName::new
 * 
 * COMPILE AND RUN:
 * javac 18_Lambda.java
 * java Lambda
 */
