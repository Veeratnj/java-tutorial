/**
 * 21_AdvancedOOPS.java
 * 
 * TOPIC: Advanced Object-Oriented Programming Concepts
 * 
 * This tutorial covers advanced OOP concepts including the final keyword,
 * object relationships (Association, Aggregation, Composition), and
 * important Object class methods.
 * 
 * KEY CONCEPTS:
 * - final keyword (variables, methods, classes)
 * - Association, Aggregation, Composition
 * - equals() and hashCode()
 * - toString()
 * - Object lifecycle
 */

import java.util.*;

// ===== FINAL KEYWORD =====

// Final class (cannot be extended)
final class FinalClass {
    void display() {
        System.out.println("This is a final class");
    }
}

// Cannot extend final class
// class ChildClass extends FinalClass { }  // Compile error!

class FinalExamples {
    // Final variable (constant)
    final int MAX_VALUE = 100;
    static final double PI = 3.14159;
    
    // Final method (cannot be overridden)
    final void finalMethod() {
        System.out.println("This method cannot be overridden");
    }
    
    void demonstrateFinal() {
        // Final local variable
        final int x = 10;
        // x = 20;  // Compile error! Cannot reassign
        
        System.out.println("Final variable x: " + x);
        System.out.println("MAX_VALUE: " + MAX_VALUE);
    }
}

class ChildOfFinalExamples extends FinalExamples {
    // Cannot override final method
    // void finalMethod() { }  // Compile error!
}


// ===== ASSOCIATION (HAS-A Relationship) =====

class Student {
    private String name;
    private int id;
    
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    public String getName() { return name; }
    public int getId() { return id; }
}

class Course {
    private String courseName;
    private String courseCode;
    
    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
    }
    
    public String getCourseName() { return courseName; }
    public String getCourseCode() { return courseCode; }
}

// Association: Student and Course are independent
class Enrollment {
    private Student student;
    private Course course;
    
    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }
    
    public void displayEnrollment() {
        System.out.println(student.getName() + " enrolled in " + course.getCourseName());
    }
}


// ===== AGGREGATION (Weak HAS-A) =====

class Department {
    private String name;
    
    public Department(String name) {
        this.name = name;
    }
    
    public String getName() { return name; }
}

// Teacher can exist without Department
class Teacher {
    private String name;
    private Department department;  // Aggregation
    
    public Teacher(String name, Department department) {
        this.name = name;
        this.department = department;
    }
    
    public void displayInfo() {
        System.out.println("Teacher: " + name);
        if (department != null) {
            System.out.println("Department: " + department.getName());
        }
    }
}


// ===== COMPOSITION (Strong HAS-A) =====

class Engine {
    private int horsepower;
    
    public Engine(int horsepower) {
        this.horsepower = horsepower;
    }
    
    public void start() {
        System.out.println("Engine started (" + horsepower + " HP)");
    }
}

// Car owns Engine - Engine cannot exist without Car
class Car {
    private String model;
    private Engine engine;  // Composition
    
    public Car(String model, int horsepower) {
        this.model = model;
        this.engine = new Engine(horsepower);  // Engine created with Car
    }
    
    public void start() {
        System.out.println("Starting " + model);
        engine.start();
    }
}


// ===== EQUALS AND HASHCODE =====

class Person {
    private String name;
    private int age;
    private String email;
    
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    
    // Override equals() - defines equality
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // Same reference
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Person person = (Person) obj;
        return age == person.age &&
               Objects.equals(name, person.name) &&
               Objects.equals(email, person.email);
    }
    
    // Override hashCode() - must override when equals() is overridden
    @Override
    public int hashCode() {
        return Objects.hash(name, age, email);
    }
    
    // Override toString() - string representation
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", email='" + email + "'}";
    }
    
    public String getName() { return name; }
    public int getAge() { return age; }
}


// ===== OBJECT LIFECYCLE =====

class LifecycleDemo {
    private String name;
    
    public LifecycleDemo(String name) {
        this.name = name;
        System.out.println("Object created: " + name);
    }
    
    public void doWork() {
        System.out.println(name + " is working");
    }
    
    // finalize() is deprecated but shown for educational purposes
    @Override
    @Deprecated
    protected void finalize() throws Throwable {
        System.out.println("Object " + name + " is being garbage collected");
        super.finalize();
    }
}


// ===== MAIN CLASS =====

public class AdvancedOOPS {
    
    public static void main(String[] args) {
        
        // ===== FINAL KEYWORD =====
        
        System.out.println("=== FINAL KEYWORD ===\n");
        
        FinalExamples finalEx = new FinalExamples();
        finalEx.demonstrateFinal();
        finalEx.finalMethod();
        
        FinalClass fc = new FinalClass();
        fc.display();
        
        
        // ===== ASSOCIATION =====
        
        System.out.println("\n=== ASSOCIATION ===\n");
        
        Student student1 = new Student("Alice", 101);
        Student student2 = new Student("Bob", 102);
        
        Course course1 = new Course("Java Programming", "CS101");
        Course course2 = new Course("Data Structures", "CS102");
        
        Enrollment enroll1 = new Enrollment(student1, course1);
        Enrollment enroll2 = new Enrollment(student2, course2);
        
        enroll1.displayEnrollment();
        enroll2.displayEnrollment();
        
        System.out.println("Note: Student and Course exist independently");
        
        
        // ===== AGGREGATION =====
        
        System.out.println("\n=== AGGREGATION ===\n");
        
        Department csDept = new Department("Computer Science");
        
        Teacher teacher1 = new Teacher("Dr. Smith", csDept);
        Teacher teacher2 = new Teacher("Dr. Johnson", csDept);
        
        teacher1.displayInfo();
        teacher2.displayInfo();
        
        System.out.println("Note: Teacher can exist without Department");
        
        
        // ===== COMPOSITION =====
        
        System.out.println("\n=== COMPOSITION ===\n");
        
        Car car1 = new Car("Tesla Model 3", 283);
        Car car2 = new Car("BMW M3", 473);
        
        car1.start();
        car2.start();
        
        System.out.println("Note: Engine is part of Car, cannot exist independently");
        
        
        // ===== EQUALS AND HASHCODE =====
        
        System.out.println("\n=== EQUALS AND HASHCODE ===\n");
        
        Person p1 = new Person("John", 30, "john@example.com");
        Person p2 = new Person("John", 30, "john@example.com");
        Person p3 = new Person("Jane", 25, "jane@example.com");
        
        // Using equals()
        System.out.println("p1.equals(p2): " + p1.equals(p2));  // true
        System.out.println("p1.equals(p3): " + p1.equals(p3));  // false
        System.out.println("p1 == p2: " + (p1 == p2));  // false (different objects)
        
        // Using hashCode()
        System.out.println("\nHash codes:");
        System.out.println("p1 hashCode: " + p1.hashCode());
        System.out.println("p2 hashCode: " + p2.hashCode());  // Same as p1
        System.out.println("p3 hashCode: " + p3.hashCode());  // Different
        
        // Using in HashMap
        HashMap<Person, String> map = new HashMap<>();
        map.put(p1, "Employee");
        map.put(p3, "Manager");
        
        System.out.println("\nHashMap lookup:");
        System.out.println("p1: " + map.get(p1));
        System.out.println("p2: " + map.get(p2));  // Works because equals/hashCode
        System.out.println("p3: " + map.get(p3));
        
        
        // ===== TOSTRING =====
        
        System.out.println("\n=== TOSTRING ===\n");
        
        System.out.println("Without toString(): " + new Object());
        System.out.println("With toString(): " + p1);
        
        
        // ===== OBJECT LIFECYCLE =====
        
        System.out.println("\n=== OBJECT LIFECYCLE ===\n");
        
        LifecycleDemo obj1 = new LifecycleDemo("Object1");
        obj1.doWork();
        
        obj1 = null;  // Remove reference
        System.gc();  // Suggest garbage collection (not guaranteed)
        
        try {
            Thread.sleep(1000);  // Wait for GC
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
        // ===== RELATIONSHIP COMPARISON =====
        
        System.out.println("\n=== RELATIONSHIP COMPARISON ===\n");
        
        System.out.println("Association:");
        System.out.println("  - Objects are independent");
        System.out.println("  - Example: Student and Course");
        
        System.out.println("\nAggregation (Weak HAS-A):");
        System.out.println("  - Child can exist without parent");
        System.out.println("  - Example: Teacher and Department");
        
        System.out.println("\nComposition (Strong HAS-A):");
        System.out.println("  - Child cannot exist without parent");
        System.out.println("  - Example: Car and Engine");
    }
}

/*
 * KEY TAKEAWAYS:
 * 
 * 1. FINAL KEYWORD:
 *    - final variable: Cannot be reassigned (constant)
 *    - final method: Cannot be overridden
 *    - final class: Cannot be extended
 *    - Use for constants, security, and immutability
 * 
 * 2. OBJECT RELATIONSHIPS:
 *    - Association: Independent objects (Student-Course)
 *    - Aggregation: Weak relationship (Teacher-Department)
 *    - Composition: Strong relationship (Car-Engine)
 * 
 * 3. EQUALS() AND HASHCODE():
 *    - Override both together (contract)
 *    - equals() defines logical equality
 *    - hashCode() for hash-based collections
 *    - If equals() returns true, hashCode() must be same
 * 
 * 4. TOSTRING():
 *    - Provides string representation
 *    - Useful for debugging
 *    - Override for meaningful output
 * 
 * 5. OBJECT LIFECYCLE:
 *    - Creation: new keyword
 *    - Usage: method calls
 *    - Destruction: Garbage collection
 *    - finalize() is deprecated (use try-with-resources)
 * 
 * 6. BEST PRACTICES:
 *    - Use final for constants
 *    - Always override equals() and hashCode() together
 *    - Override toString() for debugging
 *    - Prefer composition over inheritance
 *    - Use appropriate relationships
 * 
 * COMPILE AND RUN:
 * javac 21_AdvancedOOPS.java
 * java AdvancedOOPS
 */
