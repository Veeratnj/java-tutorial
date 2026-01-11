/**
 * 22_ComparableComparator.java
 * 
 * TOPIC: Comparable vs Comparator in Java
 * 
 * This tutorial explains how to sort custom objects in Java using
 * Comparable and Comparator interfaces.
 * 
 * KEY CONCEPTS:
 * - Comparable interface (natural ordering)
 * - Comparator interface (custom ordering)
 * - Multiple sorting strategies
 * - Lambda expressions with Comparator
 */

import java.util.*;

// ===== COMPARABLE INTERFACE =====

class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private double salary;
    
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    
    // Natural ordering by ID
    @Override
    public int compareTo(Employee other) {
        return this.id - other.id;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    
    @Override
    public String toString() {
        return String.format("Employee{id=%d, name='%s', salary=%.2f}", id, name, salary);
    }
}


// ===== COMPARATOR EXAMPLES =====

class Student {
    private int rollNo;
    private String name;
    private int age;
    private double gpa;
    
    public Student(int rollNo, String name, int age, double gpa) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }
    
    public int getRollNo() { return rollNo; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getGpa() { return gpa; }
    
    @Override
    public String toString() {
        return String.format("Student{rollNo=%d, name='%s', age=%d, gpa=%.2f}", 
                           rollNo, name, age, gpa);
    }
}

// Comparator for sorting by name
class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
}

// Comparator for sorting by age
class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getAge() - s2.getAge();
    }
}

// Comparator for sorting by GPA (descending)
class GPAComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s2.getGpa(), s1.getGpa());  // Descending
    }
}


// ===== MAIN CLASS =====

public class ComparableComparator {
    
    public static void main(String[] args) {
        
        // ===== COMPARABLE INTERFACE =====
        
        System.out.println("=== COMPARABLE INTERFACE ===\n");
        
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(103, "Alice", 75000));
        employees.add(new Employee(101, "Bob", 65000));
        employees.add(new Employee(102, "Charlie", 80000));
        
        System.out.println("Before sorting:");
        employees.forEach(System.out::println);
        
        Collections.sort(employees);  // Uses compareTo()
        
        System.out.println("\nAfter sorting (by ID - natural ordering):");
        employees.forEach(System.out::println);
        
        
        // ===== COMPARATOR WITH SEPARATE CLASSES =====
        
        System.out.println("\n=== COMPARATOR WITH CLASSES ===\n");
        
        List<Student> students = new ArrayList<>();
        students.add(new Student(103, "Charlie", 22, 3.5));
        students.add(new Student(101, "Alice", 20, 3.8));
        students.add(new Student(102, "Bob", 21, 3.2));
        
        System.out.println("Original list:");
        students.forEach(System.out::println);
        
        // Sort by name
        Collections.sort(students, new NameComparator());
        System.out.println("\nSorted by name:");
        students.forEach(System.out::println);
        
        // Sort by age
        Collections.sort(students, new AgeComparator());
        System.out.println("\nSorted by age:");
        students.forEach(System.out::println);
        
        // Sort by GPA (descending)
        Collections.sort(students, new GPAComparator());
        System.out.println("\nSorted by GPA (descending):");
        students.forEach(System.out::println);
        
        
        // ===== COMPARATOR WITH ANONYMOUS CLASS =====
        
        System.out.println("\n=== ANONYMOUS CLASS COMPARATOR ===\n");
        
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getRollNo() - s2.getRollNo();
            }
        });
        
        System.out.println("Sorted by roll number (anonymous class):");
        students.forEach(System.out::println);
        
        
        // ===== COMPARATOR WITH LAMBDA =====
        
        System.out.println("\n=== LAMBDA COMPARATORS ===\n");
        
        // Sort by name (lambda)
        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
        System.out.println("Sorted by name (lambda):");
        students.forEach(System.out::println);
        
        // Sort by age (lambda)
        students.sort((s1, s2) -> s1.getAge() - s2.getAge());
        System.out.println("\nSorted by age (lambda):");
        students.forEach(System.out::println);
        
        
        // ===== COMPARATOR STATIC METHODS (Java 8+) =====
        
        System.out.println("\n=== COMPARATOR STATIC METHODS ===\n");
        
        // comparing() method
        students.sort(Comparator.comparing(Student::getName));
        System.out.println("Sorted by name (Comparator.comparing):");
        students.forEach(System.out::println);
        
        // comparingInt()
        students.sort(Comparator.comparingInt(Student::getAge));
        System.out.println("\nSorted by age (comparingInt):");
        students.forEach(System.out::println);
        
        // comparingDouble() with reversed()
        students.sort(Comparator.comparingDouble(Student::getGpa).reversed());
        System.out.println("\nSorted by GPA descending (reversed):");
        students.forEach(System.out::println);
        
        
        // ===== CHAINING COMPARATORS =====
        
        System.out.println("\n=== CHAINING COMPARATORS ===\n");
        
        List<Student> students2 = new ArrayList<>();
        students2.add(new Student(101, "Alice", 20, 3.8));
        students2.add(new Student(102, "Alice", 22, 3.5));
        students2.add(new Student(103, "Bob", 20, 3.2));
        students2.add(new Student(104, "Bob", 21, 3.9));
        
        // Sort by name, then by age
        students2.sort(Comparator.comparing(Student::getName)
                                 .thenComparingInt(Student::getAge));
        
        System.out.println("Sorted by name, then age:");
        students2.forEach(System.out::println);
        
        // Sort by GPA (desc), then by name
        students2.sort(Comparator.comparingDouble(Student::getGpa).reversed()
                                 .thenComparing(Student::getName));
        
        System.out.println("\nSorted by GPA (desc), then name:");
        students2.forEach(System.out::println);
        
        
        // ===== NULL HANDLING =====
        
        System.out.println("\n=== NULL HANDLING ===\n");
        
        List<String> names = new ArrayList<>();
        names.add("Charlie");
        names.add(null);
        names.add("Alice");
        names.add("Bob");
        names.add(null);
        
        // nullsFirst() - nulls come first
        names.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
        System.out.println("With nullsFirst: " + names);
        
        // nullsLast() - nulls come last
        names.sort(Comparator.nullsLast(Comparator.naturalOrder()));
        System.out.println("With nullsLast: " + names);
        
        
        // ===== PRACTICAL EXAMPLES =====
        
        System.out.println("\n=== PRACTICAL EXAMPLES ===\n");
        
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9, 3);
        
        // Natural order
        numbers.sort(Comparator.naturalOrder());
        System.out.println("Natural order: " + numbers);
        
        // Reverse order
        numbers.sort(Comparator.reverseOrder());
        System.out.println("Reverse order: " + numbers);
        
        
        // ===== PERFORMANCE COMPARISON =====
        
        System.out.println("\n=== PERFORMANCE NOTES ===\n");
        
        System.out.println("Comparable:");
        System.out.println("  - Single sorting sequence (natural order)");
        System.out.println("  - Modifies the class");
        System.out.println("  - compareTo() method");
        
        System.out.println("\nComparator:");
        System.out.println("  - Multiple sorting sequences");
        System.out.println("  - Doesn't modify the class");
        System.out.println("  - compare() method");
        System.out.println("  - More flexible");
    }
}

/*
 * KEY TAKEAWAYS:
 * 
 * 1. COMPARABLE INTERFACE:
 *    - Defines natural ordering
 *    - compareTo() method
 *    - Modifies the class itself
 *    - Single sorting sequence
 *    - Used with Collections.sort(list)
 * 
 * 2. COMPARATOR INTERFACE:
 *    - Defines custom ordering
 *    - compare() method
 *    - Separate from the class
 *    - Multiple sorting sequences
 *    - Used with Collections.sort(list, comparator)
 * 
 * 3. WHEN TO USE:
 *    - Comparable: When there's one obvious natural ordering
 *    - Comparator: When you need multiple sorting options
 * 
 * 4. MODERN APPROACHES (Java 8+):
 *    - Comparator.comparing()
 *    - Comparator.comparingInt/Double/Long()
 *    - thenComparing() for chaining
 *    - reversed() for reverse order
 *    - nullsFirst() / nullsLast()
 * 
 * 5. RETURN VALUES:
 *    - Negative: first object is less than second
 *    - Zero: objects are equal
 *    - Positive: first object is greater than second
 * 
 * 6. BEST PRACTICES:
 *    - Use Comparator.comparing() instead of manual compare
 *    - Chain comparators for multi-field sorting
 *    - Handle nulls explicitly
 *    - Use method references when possible
 *    - Prefer Comparator for flexibility
 * 
 * COMPILE AND RUN:
 * javac 22_ComparableComparator.java
 * java ComparableComparator
 */
