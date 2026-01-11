/**
 * 14_Generics.java - Java Generics Tutorial
 * 
 * Generics enable types (classes and interfaces) to be parameters when defining
 * classes, interfaces, and methods. They provide compile-time type safety.
 */

import java.util.*;

// Generic class
class Box<T> {
    private T item;
    
    public void set(T item) { this.item = item; }
    public T get() { return item; }
}

// Generic class with multiple type parameters
class Pair<K, V> {
    private K key;
    private V value;
    
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    public K getKey() { return key; }
    public V getValue() { return value; }
}

// Generic method
class GenericMethods {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    
    public static <T extends Comparable<T>> T findMax(T[] array) {
        T max = array[0];
        for (T element : array) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }
}

public class Generics {
    public static void main(String[] args) {
        
        // Generic class usage
        System.out.println("=== GENERIC CLASS ===\n");
        
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello");
        System.out.println("String box: " + stringBox.get());
        
        Box<Integer> intBox = new Box<>();
        intBox.set(123);
        System.out.println("Integer box: " + intBox.get());
        
        // Multiple type parameters
        System.out.println("\n=== PAIR CLASS ===\n");
        
        Pair<String, Integer> pair = new Pair<>("Age", 25);
        System.out.println(pair.getKey() + ": " + pair.getValue());
        
        // Generic methods
        System.out.println("\n=== GENERIC METHODS ===\n");
        
        Integer[] numbers = {1, 5, 3, 9, 2};
        String[] words = {"apple", "zebra", "banana"};
        
        System.out.print("Numbers: ");
        GenericMethods.printArray(numbers);
        
        System.out.print("Words: ");
        GenericMethods.printArray(words);
        
        System.out.println("Max number: " + GenericMethods.findMax(numbers));
        System.out.println("Max word: " + GenericMethods.findMax(words));
        
        // Generic collections
        System.out.println("\n=== GENERIC COLLECTIONS ===\n");
        
        ArrayList<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        System.out.println("Names: " + names);
        
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        System.out.println("Map: " + map);
    }
}

/*
 * KEY TAKEAWAYS:
 * - Generics provide type safety at compile time
 * - <T> is a type parameter (can be any name)
 * - Bounded types: <T extends SomeClass>
 * - Wildcards: <?>, <? extends Type>, <? super Type>
 * - Cannot create instances of type parameters
 * - Cannot use primitives (use wrapper classes)
 * 
 * COMPILE AND RUN:
 * javac 14_Generics.java
 * java Generics
 */
