/**
 * 13_Collections.java
 * 
 * TOPIC: Java Collections Framework
 * 
 * The Collections Framework provides a set of classes and interfaces for storing
 * and manipulating groups of objects. It includes List, Set, Map, and Queue.
 * 
 * KEY CONCEPTS:
 * - List (ArrayList, LinkedList)
 * - Set (HashSet, TreeSet, LinkedHashSet)
 * - Map (HashMap, TreeMap, LinkedHashMap)
 * - Queue and Deque
 * - Collection operations (add, remove, iterate)
 * - Sorting and searching
 */

import java.util.*;

public class Collections {
    
    public static void main(String[] args) {
        
        // ===== ARRAYLIST =====
        
        System.out.println("=== ARRAYLIST ===\n");
        
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple");  // Duplicates allowed
        
        System.out.println("Fruits: " + fruits);
        System.out.println("Size: " + fruits.size());
        System.out.println("First fruit: " + fruits.get(0));
        System.out.println("Contains Banana: " + fruits.contains("Banana"));
        
        fruits.remove("Apple");  // Removes first occurrence
        System.out.println("After removing Apple: " + fruits);
        
        
        // ===== LINKEDLIST =====
        
        System.out.println("\n=== LINKEDLIST ===\n");
        
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.addFirst(5);
        numbers.addLast(40);
        
        System.out.println("Numbers: " + numbers);
        System.out.println("First: " + numbers.getFirst());
        System.out.println("Last: " + numbers.getLast());
        
        numbers.removeFirst();
        numbers.removeLast();
        System.out.println("After removing first and last: " + numbers);
        
        
        // ===== HASHSET =====
        
        System.out.println("\n=== HASHSET ===\n");
        
        HashSet<String> colors = new HashSet<>();
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Red");  // Duplicate ignored
        
        System.out.println("Colors: " + colors);
        System.out.println("Size: " + colors.size());
        System.out.println("Contains Blue: " + colors.contains("Blue"));
        
        
        // ===== TREESET (Sorted) =====
        
        System.out.println("\n=== TREESET ===\n");
        
        TreeSet<Integer> sortedNumbers = new TreeSet<>();
        sortedNumbers.add(50);
        sortedNumbers.add(10);
        sortedNumbers.add(30);
        sortedNumbers.add(20);
        
        System.out.println("Sorted numbers: " + sortedNumbers);
        System.out.println("First: " + sortedNumbers.first());
        System.out.println("Last: " + sortedNumbers.last());
        
        
        // ===== HASHMAP =====
        
        System.out.println("\n=== HASHMAP ===\n");
        
        HashMap<String, Integer> ages = new HashMap<>();
        ages.put("Alice", 25);
        ages.put("Bob", 30);
        ages.put("Charlie", 28);
        
        System.out.println("Ages: " + ages);
        System.out.println("Alice's age: " + ages.get("Alice"));
        System.out.println("Contains key Bob: " + ages.containsKey("Bob"));
        System.out.println("Contains value 30: " + ages.containsValue(30));
        
        // Iterate over map
        System.out.println("\nIterating:");
        for (Map.Entry<String, Integer> entry : ages.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        
        // ===== TREEMAP (Sorted by keys) =====
        
        System.out.println("\n=== TREEMAP ===\n");
        
        TreeMap<String, String> capitals = new TreeMap<>();
        capitals.put("USA", "Washington DC");
        capitals.put("France", "Paris");
        capitals.put("Japan", "Tokyo");
        capitals.put("India", "New Delhi");
        
        System.out.println("Capitals (sorted by country): " + capitals);
        
        
        // ===== QUEUE =====
        
        System.out.println("\n=== QUEUE ===\n");
        
        Queue<String> queue = new LinkedList<>();
        queue.offer("First");
        queue.offer("Second");
        queue.offer("Third");
        
        System.out.println("Queue: " + queue);
        System.out.println("Peek: " + queue.peek());
        System.out.println("Poll: " + queue.poll());
        System.out.println("After poll: " + queue);
        
        
        // ===== STACK =====
        
        System.out.println("\n=== STACK ===\n");
        
        Stack<String> stack = new Stack<>();
        stack.push("Bottom");
        stack.push("Middle");
        stack.push("Top");
        
        System.out.println("Stack: " + stack);
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("After pop: " + stack);
        
        
        // ===== SORTING =====
        
        System.out.println("\n=== SORTING ===\n");
        
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9));
        System.out.println("Original: " + nums);
        
        java.util.Collections.sort(nums);
        System.out.println("Sorted: " + nums);
        
        java.util.Collections.reverse(nums);
        System.out.println("Reversed: " + nums);
        
        
        // ===== ITERATION =====
        
        System.out.println("\n=== ITERATION ===\n");
        
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
        
        // For-each loop
        System.out.print("For-each: ");
        for (String name : names) {
            System.out.print(name + " ");
        }
        System.out.println();
        
        // Iterator
        System.out.print("Iterator: ");
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        
        // Lambda (Java 8+)
        System.out.print("Lambda: ");
        names.forEach(name -> System.out.print(name + " "));
        System.out.println();
    }
}

/*
 * KEY TAKEAWAYS:
 * 
 * 1. LIST (Ordered, allows duplicates):
 *    - ArrayList: Fast random access, slow insertion/deletion
 *    - LinkedList: Fast insertion/deletion, slow random access
 * 
 * 2. SET (No duplicates):
 *    - HashSet: Unordered, fast operations
 *    - TreeSet: Sorted, slower than HashSet
 *    - LinkedHashSet: Insertion order maintained
 * 
 * 3. MAP (Key-value pairs):
 *    - HashMap: Unordered, fast operations
 *    - TreeMap: Sorted by keys
 *    - LinkedHashMap: Insertion order maintained
 * 
 * 4. QUEUE (FIFO):
 *    - offer(): Add element
 *    - poll(): Remove and return first element
 *    - peek(): View first element without removing
 * 
 * 5. STACK (LIFO):
 *    - push(): Add element
 *    - pop(): Remove and return top element
 *    - peek(): View top element without removing
 * 
 * COMPILE AND RUN:
 * javac 13_Collections.java
 * java Collections
 */
