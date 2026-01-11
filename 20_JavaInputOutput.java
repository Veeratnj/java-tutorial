/**
 * 20_JavaInputOutput.java
 * 
 * TOPIC: Java Input/Output (Console Input)
 * 
 * This tutorial covers various ways to read input from the user in Java,
 * including Scanner, BufferedReader, and Console classes.
 * 
 * KEY CONCEPTS:
 * - Scanner class (most common)
 * - BufferedReader with InputStreamReader
 * - Console class
 * - Command-line arguments
 * - Input validation
 */

import java.io.*;
import java.util.Scanner;

public class JavaInputOutput {
    
    public static void main(String[] args) throws IOException {
        
        // ===== SCANNER CLASS =====
        
        System.out.println("=== SCANNER CLASS ===\n");
        
        Scanner scanner = new Scanner(System.in);
        
        // Reading different data types
        System.out.println("--- Reading Different Types ---");
        
        // String input
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        
        // Integer input
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        System.out.println("You are " + age + " years old.");
        
        // Double input
        System.out.print("Enter your salary: ");
        double salary = scanner.nextDouble();
        System.out.println("Your salary is: $" + salary);
        
        // Boolean input
        System.out.print("Are you employed? (true/false): ");
        boolean employed = scanner.nextBoolean();
        System.out.println("Employed: " + employed);
        
        // Clear buffer after nextInt/nextDouble/nextBoolean
        scanner.nextLine();
        
        
        // ===== SCANNER METHODS =====
        
        System.out.println("\n=== SCANNER METHODS ===\n");
        
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();  // Reads entire line
        
        System.out.print("Enter a single word: ");
        String word = scanner.next();  // Reads until whitespace
        scanner.nextLine();  // Clear buffer
        
        System.out.println("Sentence: " + sentence);
        System.out.println("Word: " + word);
        
        
        // ===== INPUT VALIDATION =====
        
        System.out.println("\n=== INPUT VALIDATION ===\n");
        
        // Validate integer input
        System.out.print("Enter a number: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a number.");
            scanner.next();  // Clear invalid input
            System.out.print("Enter a number: ");
        }
        int number = scanner.nextInt();
        System.out.println("You entered: " + number);
        scanner.nextLine();  // Clear buffer
        
        
        // ===== READING MULTIPLE VALUES =====
        
        System.out.println("\n=== READING MULTIPLE VALUES ===\n");
        
        System.out.print("Enter 3 numbers separated by spaces: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        System.out.println("Sum: " + (num1 + num2 + num3));
        scanner.nextLine();  // Clear buffer
        
        
        // ===== BUFFEREDREADER =====
        
        System.out.println("\n=== BUFFEREDREADER ===\n");
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter your city (BufferedReader): ");
        String city = reader.readLine();
        System.out.println("City: " + city);
        
        System.out.print("Enter your age (BufferedReader): ");
        String ageStr = reader.readLine();
        int ageFromReader = Integer.parseInt(ageStr);
        System.out.println("Age: " + ageFromReader);
        
        
        // ===== CONSOLE CLASS =====
        
        System.out.println("\n=== CONSOLE CLASS ===\n");
        
        Console console = System.console();
        
        if (console != null) {
            String username = console.readLine("Enter username: ");
            char[] password = console.readPassword("Enter password: ");
            
            System.out.println("Username: " + username);
            System.out.println("Password entered (hidden)");
            
            // Clear password from memory
            java.util.Arrays.fill(password, ' ');
        } else {
            System.out.println("Console not available (running in IDE)");
        }
        
        
        // ===== COMMAND-LINE ARGUMENTS =====
        
        System.out.println("\n=== COMMAND-LINE ARGUMENTS ===\n");
        
        if (args.length > 0) {
            System.out.println("Arguments passed:");
            for (int i = 0; i < args.length; i++) {
                System.out.println("Arg " + i + ": " + args[i]);
            }
        } else {
            System.out.println("No command-line arguments provided.");
            System.out.println("Run with: java JavaInputOutput arg1 arg2 arg3");
        }
        
        
        // ===== PRACTICAL EXAMPLES =====
        
        System.out.println("\n=== PRACTICAL EXAMPLES ===\n");
        
        // Example 1: Simple Calculator
        System.out.println("--- Simple Calculator ---");
        System.out.print("Enter first number: ");
        double a = scanner.nextDouble();
        System.out.print("Enter operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);
        System.out.print("Enter second number: ");
        double b = scanner.nextDouble();
        
        double result = 0;
        switch (operator) {
            case '+': result = a + b; break;
            case '-': result = a - b; break;
            case '*': result = a * b; break;
            case '/': result = a / b; break;
            default: System.out.println("Invalid operator");
        }
        System.out.println("Result: " + result);
        scanner.nextLine();  // Clear buffer
        
        
        // Example 2: Menu-driven program
        System.out.println("\n--- Menu Example ---");
        System.out.println("1. Option A");
        System.out.println("2. Option B");
        System.out.println("3. Exit");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                System.out.println("You selected Option A");
                break;
            case 2:
                System.out.println("You selected Option B");
                break;
            case 3:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice");
        }
        
        
        // Close scanner
        scanner.close();
        
        
        // ===== BEST PRACTICES =====
        
        System.out.println("\n=== BEST PRACTICES ===\n");
        System.out.println("1. Always close Scanner when done");
        System.out.println("2. Use nextLine() after nextInt/nextDouble to clear buffer");
        System.out.println("3. Validate input before processing");
        System.out.println("4. Use try-catch for parsing errors");
        System.out.println("5. Scanner is easier than BufferedReader for simple input");
        System.out.println("6. BufferedReader is faster for large input");
        System.out.println("7. Console is best for password input (hides input)");
    }
}

/*
 * KEY TAKEAWAYS:
 * 
 * 1. SCANNER CLASS:
 *    - Most commonly used for console input
 *    - Methods: nextLine(), next(), nextInt(), nextDouble(), nextBoolean()
 *    - hasNext() methods for validation
 *    - Remember to clear buffer after nextInt/nextDouble
 * 
 * 2. BUFFEREDREADER:
 *    - Faster than Scanner for large input
 *    - Only reads strings (need to parse)
 *    - Throws IOException (must handle)
 *    - Good for reading files line by line
 * 
 * 3. CONSOLE CLASS:
 *    - Best for password input (readPassword())
 *    - Not available in IDEs (only command line)
 *    - Returns null if console not available
 * 
 * 4. COMMAND-LINE ARGUMENTS:
 *    - Passed via main(String[] args)
 *    - Access via args[0], args[1], etc.
 *    - Check args.length before accessing
 * 
 * 5. INPUT VALIDATION:
 *    - Use hasNextInt(), hasNextDouble() to check type
 *    - Use try-catch for parsing errors
 *    - Provide clear error messages
 * 
 * 6. COMMON PITFALLS:
 *    - Forgetting to clear buffer after nextInt/nextDouble
 *    - Not validating input
 *    - Not closing Scanner
 *    - InputMismatchException when wrong type entered
 * 
 * 7. WHEN TO USE WHAT:
 *    - Scanner: General purpose, easy to use
 *    - BufferedReader: Large input, better performance
 *    - Console: Password input, command-line only
 * 
 * COMPILE AND RUN:
 * javac 20_JavaInputOutput.java
 * java JavaInputOutput
 * 
 * WITH ARGUMENTS:
 * java JavaInputOutput arg1 arg2 arg3
 */
