/**
 * 19_Arrays.java
 * 
 * TOPIC: Arrays in Java
 * 
 * Arrays are containers that hold a fixed number of values of a single type.
 * They are fundamental data structures in Java.
 * 
 * KEY CONCEPTS:
 * - Array declaration and initialization
 * - Accessing array elements
 * - Array length
 * - Multidimensional arrays
 * - Array operations (sorting, searching, copying)
 * - Arrays class utility methods
 */

import java.util.Arrays;

public class Arrays_Tutorial {
    
    public static void main(String[] args) {
        
        // ===== ARRAY DECLARATION AND INITIALIZATION =====
        
        System.out.println("=== ARRAY DECLARATION ===\n");
        
        // Method 1: Declare then initialize
        int[] numbers1;
        numbers1 = new int[5];  // Creates array of 5 integers (default: 0)
        
        // Method 2: Declare and initialize together
        int[] numbers2 = new int[5];
        
        // Method 3: Declare and initialize with values
        int[] numbers3 = {10, 20, 30, 40, 50};
        
        // Method 4: Using new keyword with values
        int[] numbers4 = new int[]{1, 2, 3, 4, 5};
        
        System.out.println("Array created with values: " + Arrays.toString(numbers3));
        
        
        // ===== ACCESSING ARRAY ELEMENTS =====
        
        System.out.println("\n=== ACCESSING ELEMENTS ===\n");
        
        int[] scores = {85, 92, 78, 95, 88};
        
        System.out.println("First element (index 0): " + scores[0]);
        System.out.println("Last element: " + scores[scores.length - 1]);
        System.out.println("Array length: " + scores.length);
        
        // Modifying elements
        scores[2] = 90;
        System.out.println("After modifying index 2: " + Arrays.toString(scores));
        
        
        // ===== ITERATING THROUGH ARRAYS =====
        
        System.out.println("\n=== ITERATION ===\n");
        
        String[] fruits = {"Apple", "Banana", "Orange", "Mango"};
        
        // Using traditional for loop
        System.out.print("For loop: ");
        for (int i = 0; i < fruits.length; i++) {
            System.out.print(fruits[i] + " ");
        }
        System.out.println();
        
        // Using enhanced for loop (for-each)
        System.out.print("For-each: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();
        
        
        // ===== ARRAY OPERATIONS =====
        
        System.out.println("\n=== ARRAY OPERATIONS ===\n");
        
        int[] nums = {5, 2, 8, 1, 9, 3};
        
        // Finding sum
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        System.out.println("Sum: " + sum);
        
        // Finding average
        double average = (double) sum / nums.length;
        System.out.println("Average: " + average);
        
        // Finding max
        int max = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        System.out.println("Max: " + max);
        
        // Finding min
        int min = nums[0];
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }
        System.out.println("Min: " + min);
        
        
        // ===== ARRAYS CLASS UTILITY METHODS =====
        
        System.out.println("\n=== ARRAYS CLASS METHODS ===\n");
        
        int[] data = {5, 2, 8, 1, 9, 3};
        
        // Sorting
        Arrays.sort(data);
        System.out.println("Sorted: " + Arrays.toString(data));
        
        // Binary search (array must be sorted)
        int index = Arrays.binarySearch(data, 8);
        System.out.println("Index of 8: " + index);
        
        // Fill array with value
        int[] filled = new int[5];
        Arrays.fill(filled, 7);
        System.out.println("Filled with 7: " + Arrays.toString(filled));
        
        // Copy array
        int[] original = {1, 2, 3, 4, 5};
        int[] copy = Arrays.copyOf(original, original.length);
        System.out.println("Copied array: " + Arrays.toString(copy));
        
        // Copy range
        int[] rangeCopy = Arrays.copyOfRange(original, 1, 4);
        System.out.println("Range copy [1-4): " + Arrays.toString(rangeCopy));
        
        // Compare arrays
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {1, 2, 4};
        System.out.println("arr1 equals arr2: " + Arrays.equals(arr1, arr2));
        System.out.println("arr1 equals arr3: " + Arrays.equals(arr1, arr3));
        
        
        // ===== MULTIDIMENSIONAL ARRAYS =====
        
        System.out.println("\n=== 2D ARRAYS ===\n");
        
        // 2D array (matrix)
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("2D Array:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        // Accessing 2D array elements
        System.out.println("Element at [1][2]: " + matrix[1][2]);
        
        // Jagged array (rows with different lengths)
        int[][] jagged = {
            {1, 2},
            {3, 4, 5},
            {6, 7, 8, 9}
        };
        
        System.out.println("\nJagged Array:");
        for (int i = 0; i < jagged.length; i++) {
            for (int j = 0; j < jagged[i].length; j++) {
                System.out.print(jagged[i][j] + " ");
            }
            System.out.println();
        }
        
        
        // ===== 3D ARRAYS =====
        
        System.out.println("\n=== 3D ARRAYS ===\n");
        
        int[][][] cube = {
            {{1, 2}, {3, 4}},
            {{5, 6}, {7, 8}}
        };
        
        System.out.println("3D Array:");
        for (int i = 0; i < cube.length; i++) {
            System.out.println("Layer " + i + ":");
            for (int j = 0; j < cube[i].length; j++) {
                for (int k = 0; k < cube[i][j].length; k++) {
                    System.out.print(cube[i][j][k] + " ");
                }
                System.out.println();
            }
        }
        
        
        // ===== ARRAY COPYING METHODS =====
        
        System.out.println("\n=== ARRAY COPYING ===\n");
        
        int[] source = {1, 2, 3, 4, 5};
        
        // Method 1: Arrays.copyOf()
        int[] copy1 = Arrays.copyOf(source, source.length);
        
        // Method 2: clone()
        int[] copy2 = source.clone();
        
        // Method 3: System.arraycopy()
        int[] copy3 = new int[source.length];
        System.arraycopy(source, 0, copy3, 0, source.length);
        
        System.out.println("Original: " + Arrays.toString(source));
        System.out.println("Copy 1: " + Arrays.toString(copy1));
        System.out.println("Copy 2: " + Arrays.toString(copy2));
        System.out.println("Copy 3: " + Arrays.toString(copy3));
        
        
        // ===== COMMON ARRAY PATTERNS =====
        
        System.out.println("\n=== COMMON PATTERNS ===\n");
        
        // Reverse array
        int[] toReverse = {1, 2, 3, 4, 5};
        for (int i = 0; i < toReverse.length / 2; i++) {
            int temp = toReverse[i];
            toReverse[i] = toReverse[toReverse.length - 1 - i];
            toReverse[toReverse.length - 1 - i] = temp;
        }
        System.out.println("Reversed: " + Arrays.toString(toReverse));
        
        // Find element
        int[] searchArray = {10, 20, 30, 40, 50};
        int target = 30;
        int foundIndex = -1;
        for (int i = 0; i < searchArray.length; i++) {
            if (searchArray[i] == target) {
                foundIndex = i;
                break;
            }
        }
        System.out.println("Index of " + target + ": " + foundIndex);
        
        // Count occurrences
        int[] countArray = {1, 2, 3, 2, 4, 2, 5};
        int countTarget = 2;
        int count = 0;
        for (int num : countArray) {
            if (num == countTarget) {
                count++;
            }
        }
        System.out.println("Count of " + countTarget + ": " + count);
        
        
        // ===== ARRAY OF OBJECTS =====
        
        System.out.println("\n=== ARRAY OF OBJECTS ===\n");
        
        String[] names = {"Alice", "Bob", "Charlie"};
        System.out.println("Names: " + Arrays.toString(names));
        
        // Array of custom objects
        Person[] people = new Person[3];
        people[0] = new Person("Alice", 25);
        people[1] = new Person("Bob", 30);
        people[2] = new Person("Charlie", 28);
        
        System.out.println("People:");
        for (Person person : people) {
            System.out.println("  " + person.name + " - " + person.age);
        }
    }
}

// Helper class for array of objects example
class Person {
    String name;
    int age;
    
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

/*
 * KEY TAKEAWAYS:
 * 
 * 1. ARRAY BASICS:
 *    - Fixed size (cannot change after creation)
 *    - Zero-indexed (first element at index 0)
 *    - All elements must be same type
 *    - Default values: 0 for numbers, false for boolean, null for objects
 * 
 * 2. DECLARATION SYNTAX:
 *    - int[] arr or int arr[] (prefer first)
 *    - Must specify size: new int[5]
 *    - Can initialize with values: {1, 2, 3}
 * 
 * 3. ARRAYS CLASS METHODS:
 *    - Arrays.toString(): Print array
 *    - Arrays.sort(): Sort array
 *    - Arrays.binarySearch(): Search sorted array
 *    - Arrays.copyOf(): Copy array
 *    - Arrays.equals(): Compare arrays
 *    - Arrays.fill(): Fill with value
 * 
 * 4. MULTIDIMENSIONAL ARRAYS:
 *    - 2D: int[][] matrix = new int[rows][cols]
 *    - 3D: int[][][] cube = new int[x][y][z]
 *    - Jagged arrays: Different row lengths
 * 
 * 5. COMMON OPERATIONS:
 *    - Sum, average, min, max
 *    - Searching, sorting
 *    - Reversing, copying
 *    - Counting occurrences
 * 
 * 6. LIMITATIONS:
 *    - Fixed size (use ArrayList for dynamic size)
 *    - No built-in methods (use Arrays class)
 *    - Cannot directly print (use Arrays.toString())
 * 
 * 7. BEST PRACTICES:
 *    - Check array bounds to avoid ArrayIndexOutOfBoundsException
 *    - Use enhanced for loop when index not needed
 *    - Use Arrays class utility methods
 *    - Consider ArrayList for dynamic sizing
 * 
 * COMPILE AND RUN:
 * javac 19_Arrays.java
 * java Arrays_Tutorial
 */
