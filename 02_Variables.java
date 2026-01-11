/**
 * 02_Variables.java
 * 
 * TOPIC: Variables in Java
 * 
 * Variables are containers that store data values.
 * In Java, variables must be declared with a specific data type.
 * 
 * KEY CONCEPTS:
 * - Variable declaration and initialization
 * - Naming conventions
 * - Variable scope (local, instance, static)
 * - Constants (final keyword)
 * - Type inference (var keyword - Java 10+)
 */

public class Variables {
    
    // INSTANCE VARIABLES (also called fields or member variables)
    // Declared inside a class but outside methods
    // Each object has its own copy
    String instanceVariable = "I belong to an object";
    
    // STATIC VARIABLES (also called class variables)
    // Shared among all instances of the class
    static int staticVariable = 100;
    
    // CONSTANTS (final keyword makes it unchangeable)
    // Convention: Use UPPERCASE with underscores
    static final double PI = 3.14159;
    static final String COMPANY_NAME = "TechCorp";
    
    public static void main(String[] args) {
        
        // ===== VARIABLE DECLARATION AND INITIALIZATION =====
        
        // Declaration (creating a variable)
        int age;
        
        // Initialization (assigning a value)
        age = 25;
        
        // Declaration and initialization together
        String name = "Alice";
        double salary = 75000.50;
        boolean isEmployed = true;
        
        // Multiple variables of same type
        int x = 10, y = 20, z = 30;
        
        System.out.println("=== Basic Variables ===");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: $" + salary);
        System.out.println("Employed: " + isEmployed);
        
        
        // ===== VARIABLE NAMING CONVENTIONS =====
        
        // Valid variable names (camelCase for variables)
        int studentAge = 20;
        String firstName = "John";
        double accountBalance = 1000.50;
        boolean isValidUser = true;
        
        // Invalid variable names (these would cause compilation errors):
        // int 2ndNumber = 5;        // Cannot start with digit
        // String first-name = "X";  // Cannot use hyphen
        // double class = 10.5;      // Cannot use reserved keywords
        
        System.out.println("\n=== Naming Conventions ===");
        System.out.println("Student Age: " + studentAge);
        System.out.println("First Name: " + firstName);
        
        
        // ===== LOCAL VARIABLES =====
        
        // Local variables are declared inside methods
        // They must be initialized before use
        int localVar = 50;
        System.out.println("\n=== Local Variable ===");
        System.out.println("Local Variable: " + localVar);
        
        
        // ===== CONSTANTS =====
        
        // Constants cannot be changed after initialization
        final int MAX_USERS = 1000;
        final String APP_VERSION = "1.0.0";
        
        System.out.println("\n=== Constants ===");
        System.out.println("Max Users: " + MAX_USERS);
        System.out.println("App Version: " + APP_VERSION);
        System.out.println("PI: " + PI);
        
        // This would cause an error:
        // MAX_USERS = 2000; // Error: cannot assign a value to final variable
        
        
        // ===== TYPE INFERENCE (var keyword - Java 10+) =====
        
        // The compiler infers the type from the value
        var autoInt = 100;           // inferred as int
        var autoString = "Hello";    // inferred as String
        var autoDouble = 99.99;      // inferred as double
        var autoBoolean = false;     // inferred as boolean
        
        System.out.println("\n=== Type Inference (var) ===");
        System.out.println("Auto Int: " + autoInt);
        System.out.println("Auto String: " + autoString);
        System.out.println("Auto Double: " + autoDouble);
        
        
        // ===== VARIABLE SCOPE DEMONSTRATION =====
        
        System.out.println("\n=== Variable Scope ===");
        System.out.println("Static Variable: " + staticVariable);
        
        // To access instance variable, we need to create an object
        Variables obj = new Variables();
        System.out.println("Instance Variable: " + obj.instanceVariable);
        
        
        // ===== VARIABLE REASSIGNMENT =====
        
        int counter = 0;
        System.out.println("\n=== Variable Reassignment ===");
        System.out.println("Initial counter: " + counter);
        
        counter = 10;
        System.out.println("After reassignment: " + counter);
        
        counter = counter + 5;
        System.out.println("After increment: " + counter);
        
        
        // ===== SCOPE EXAMPLE WITH BLOCKS =====
        
        int outerScope = 100;
        
        {
            // This is a code block
            int innerScope = 200;
            System.out.println("\n=== Block Scope ===");
            System.out.println("Outer scope inside block: " + outerScope);
            System.out.println("Inner scope: " + innerScope);
        }
        
        // innerScope is not accessible here
        // System.out.println(innerScope); // This would cause an error
        System.out.println("Outer scope outside block: " + outerScope);
    }
}

/*
 * KEY TAKEAWAYS:
 * 
 * 1. VARIABLE TYPES BY SCOPE:
 *    - Local: Declared in methods, must be initialized
 *    - Instance: Declared in class, belong to objects
 *    - Static: Declared with 'static', shared by all instances
 * 
 * 2. NAMING RULES:
 *    - Must start with letter, $, or _
 *    - Cannot use Java keywords
 *    - Case-sensitive (age and Age are different)
 *    - Convention: camelCase for variables, UPPERCASE for constants
 * 
 * 3. BEST PRACTICES:
 *    - Use meaningful names (age instead of a)
 *    - Initialize variables when declaring them
 *    - Use final for values that shouldn't change
 *    - Keep variable scope as narrow as possible
 * 
 * EXPECTED OUTPUT:
 * === Basic Variables ===
 * Name: Alice
 * Age: 25
 * Salary: $75000.5
 * Employed: true
 * 
 * === Naming Conventions ===
 * Student Age: 20
 * First Name: John
 * 
 * === Local Variable ===
 * Local Variable: 50
 * 
 * === Constants ===
 * Max Users: 1000
 * App Version: 1.0.0
 * PI: 3.14159
 * 
 * === Type Inference (var) ===
 * Auto Int: 100
 * Auto String: Hello
 * Auto Double: 99.99
 * 
 * === Variable Scope ===
 * Static Variable: 100
 * Instance Variable: I belong to an object
 * 
 * === Variable Reassignment ===
 * Initial counter: 0
 * After reassignment: 10
 * After increment: 15
 * 
 * === Block Scope ===
 * Outer scope inside block: 100
 * Inner scope: 200
 * Outer scope outside block: 100
 */
