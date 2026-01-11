/**
 * 12_ExceptionHandling.java
 * 
 * TOPIC: Exception Handling in Java
 * 
 * Exceptions are events that disrupt the normal flow of program execution.
 * Java provides a robust exception handling mechanism to handle runtime errors
 * and maintain normal application flow.
 * 
 * KEY CONCEPTS:
 * - try-catch-finally blocks
 * - throw and throws keywords
 * - Exception hierarchy (Checked vs Unchecked)
 * - Custom exceptions
 * - Try-with-resources (Java 7+)
 * - Multi-catch (Java 7+)
 */

import java.io.*;
import java.util.*;

// ===== CUSTOM EXCEPTIONS =====

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

// ===== BANK ACCOUNT CLASS =====

class BankAccount {
    private double balance;
    
    public BankAccount(double balance) {
        this.balance = balance;
    }
    
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds! Balance: $" + balance);
        }
        balance -= amount;
        System.out.println("Withdrawn: $" + amount + ", Remaining: $" + balance);
    }
    
    public double getBalance() {
        return balance;
    }
}

// ===== MAIN CLASS =====

public class ExceptionHandling {
    
    // ===== BASIC TRY-CATCH =====
    
    public static void basicTryCatch() {
        System.out.println("=== BASIC TRY-CATCH ===\n");
        
        try {
            int result = 10 / 0;  // ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
            System.out.println("Exception: " + e.getMessage());
        }
        
        System.out.println("Program continues...\n");
    }
    
    // ===== MULTIPLE CATCH BLOCKS =====
    
    public static void multipleCatch() {
        System.out.println("=== MULTIPLE CATCH BLOCKS ===\n");
        
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]);  // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index out of bounds!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    // ===== MULTI-CATCH (Java 7+) =====
    
    public static void multiCatch() {
        System.out.println("=== MULTI-CATCH ===\n");
        
        try {
            String str = null;
            System.out.println(str.length());  // NullPointerException
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getClass().getSimpleName());
        }
        
        System.out.println();
    }
    
    // ===== TRY-CATCH-FINALLY =====
    
    public static void tryCatchFinally() {
        System.out.println("=== TRY-CATCH-FINALLY ===\n");
        
        try {
            System.out.println("In try block");
            int result = 10 / 2;
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("In catch block");
        } finally {
            System.out.println("In finally block (always executes)");
        }
        
        System.out.println();
    }
    
    // ===== THROW KEYWORD =====
    
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException("Invalid age: " + age);
        }
        System.out.println("Valid age: " + age);
    }
    
    public static void throwExample() {
        System.out.println("=== THROW KEYWORD ===\n");
        
        try {
            validateAge(25);
            validateAge(200);  // Throws exception
        } catch (InvalidAgeException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    // ===== CUSTOM EXCEPTIONS =====
    
    public static void customExceptions() {
        System.out.println("=== CUSTOM EXCEPTIONS ===\n");
        
        BankAccount account = new BankAccount(1000);
        
        try {
            account.withdraw(500);
            account.withdraw(700);  // Throws InsufficientFundsException
        } catch (InsufficientFundsException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    // ===== TRY-WITH-RESOURCES (Java 7+) =====
    
    public static void tryWithResources() {
        System.out.println("=== TRY-WITH-RESOURCES ===\n");
        
        // Automatically closes resources
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Scanner created and will be auto-closed");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("Scanner automatically closed\n");
    }
    
    // ===== EXCEPTION PROPAGATION =====
    
    public static void method1() throws Exception {
        method2();
    }
    
    public static void method2() throws Exception {
        method3();
    }
    
    public static void method3() throws Exception {
        throw new Exception("Exception from method3");
    }
    
    public static void exceptionPropagation() {
        System.out.println("=== EXCEPTION PROPAGATION ===\n");
        
        try {
            method1();
        } catch (Exception e) {
            System.out.println("Caught in main: " + e.getMessage());
            System.out.println("Stack trace:");
            e.printStackTrace();
        }
        
        System.out.println();
    }
    
    // ===== MAIN METHOD =====
    
    public static void main(String[] args) {
        basicTryCatch();
        multipleCatch();
        multiCatch();
        tryCatchFinally();
        throwExample();
        customExceptions();
        tryWithResources();
        exceptionPropagation();
        
        System.out.println("=== EXCEPTION HIERARCHY ===\n");
        System.out.println("Throwable");
        System.out.println("├── Error (Unchecked - system errors)");
        System.out.println("└── Exception");
        System.out.println("    ├── RuntimeException (Unchecked)");
        System.out.println("    │   ├── NullPointerException");
        System.out.println("    │   ├── ArrayIndexOutOfBoundsException");
        System.out.println("    │   └── ArithmeticException");
        System.out.println("    └── Checked Exceptions");
        System.out.println("        ├── IOException");
        System.out.println("        └── SQLException");
    }
}

/*
 * KEY TAKEAWAYS:
 * 
 * 1. EXCEPTION TYPES:
 *    - Checked: Must be caught or declared (IOException, SQLException)
 *    - Unchecked: Runtime exceptions (NullPointerException, ArithmeticException)
 *    - Error: System errors (OutOfMemoryError, StackOverflowError)
 * 
 * 2. TRY-CATCH-FINALLY:
 *    - try: Code that might throw exception
 *    - catch: Handle the exception
 *    - finally: Always executes (cleanup code)
 * 
 * 3. THROW vs THROWS:
 *    - throw: Actually throws an exception
 *    - throws: Declares that method might throw exception
 * 
 * 4. BEST PRACTICES:
 *    - Catch specific exceptions first
 *    - Don't catch Exception unless necessary
 *    - Use try-with-resources for auto-closing
 *    - Create meaningful custom exceptions
 *    - Log exceptions properly
 *    - Don't swallow exceptions silently
 * 
 * COMPILE AND RUN:
 * javac 12_ExceptionHandling.java
 * java ExceptionHandling
 */
