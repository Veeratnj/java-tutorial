/**
 * 01_HelloWorld.java
 * 
 * TOPIC: Introduction to Java Programming
 * 
 * This is the traditional first program in any programming language.
 * It demonstrates the basic structure of a Java program.
 * 
 * KEY CONCEPTS:
 * - Class declaration
 * - Main method (entry point of Java application)
 * - Print statements
 * - Comments (single-line, multi-line, and JavaDoc)
 */

public class HelloWorld {
    
    /**
     * The main method is the entry point of any Java application.
     * When you run a Java program, the JVM looks for this method to start execution.
     * 
     * @param args Command-line arguments passed to the program
     */
    public static void main(String[] args) {
        
        // Single-line comment: This is used for brief explanations
        
        /*
         * Multi-line comment: This is used for longer explanations
         * that span multiple lines.
         */
        
        // Print to console (with newline at the end)
        System.out.println("Hello, World!");
        
        // Print without newline
        System.out.print("Hello, ");
        System.out.print("Java!");
        System.out.println(); // Print empty line
        
        // Formatted output
        String name = "Java";
        int version = 17;
        System.out.printf("Welcome to %s %d!%n", name, version);
        
        // String concatenation
        System.out.println("Learning " + name + " is fun!");
    }
}

/*
 * EXPLANATION OF COMPONENTS:
 * 
 * 1. public class HelloWorld
 *    - 'public' is an access modifier (visible to all)
 *    - 'class' keyword defines a class
 *    - 'HelloWorld' is the class name (must match filename)
 * 
 * 2. public static void main(String[] args)
 *    - 'public' - accessible from anywhere
 *    - 'static' - can be called without creating an object
 *    - 'void' - doesn't return any value
 *    - 'main' - method name (JVM looks for this)
 *    - 'String[] args' - array of command-line arguments
 * 
 * 3. System.out.println()
 *    - 'System' is a built-in class
 *    - 'out' is a static member (PrintStream object)
 *    - 'println' is a method that prints and adds newline
 * 
 * HOW TO COMPILE AND RUN:
 * 1. Compile: javac 01_HelloWorld.java
 * 2. Run: java HelloWorld
 * 
 * EXPECTED OUTPUT:
 * Hello, World!
 * Hello, Java!
 * Welcome to Java 17!
 * Learning Java is fun!
 */
