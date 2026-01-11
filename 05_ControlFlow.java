/**
 * 05_ControlFlow.java
 * 
 * TOPIC: Control Flow Statements in Java
 * 
 * Control flow statements determine the order in which code is executed.
 * They allow you to make decisions, repeat code, and control program flow.
 * 
 * KEY CONCEPTS:
 * - Decision-making: if, if-else, if-else-if, nested if, switch
 * - Loops: for, while, do-while, enhanced for (for-each)
 * - Jump statements: break, continue, return
 * - Labeled statements
 */

public class ControlFlow {
    
    public static void main(String[] args) {
        
        // ===== IF STATEMENT =====
        
        System.out.println("=== IF STATEMENT ===\n");
        
        int age = 20;
        
        if (age >= 18) {
            System.out.println("You are an adult.");
        }
        
        // Single line if (not recommended for readability)
        if (age >= 18) System.out.println("Eligible to vote.");
        
        
        // ===== IF-ELSE STATEMENT =====
        
        System.out.println("\n=== IF-ELSE STATEMENT ===\n");
        
        int temperature = 25;
        
        if (temperature > 30) {
            System.out.println("It's hot outside!");
        } else {
            System.out.println("The weather is pleasant.");
        }
        
        
        // ===== IF-ELSE-IF LADDER =====
        
        System.out.println("\n=== IF-ELSE-IF LADDER ===\n");
        
        int score = 85;
        
        if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 80) {
            System.out.println("Grade: B");
        } else if (score >= 70) {
            System.out.println("Grade: C");
        } else if (score >= 60) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }
        
        
        // ===== NESTED IF =====
        
        System.out.println("\n=== NESTED IF ===\n");
        
        int num = 15;
        
        if (num > 0) {
            if (num % 2 == 0) {
                System.out.println(num + " is positive and even.");
            } else {
                System.out.println(num + " is positive and odd.");
            }
        } else {
            System.out.println(num + " is not positive.");
        }
        
        
        // ===== SWITCH STATEMENT =====
        
        System.out.println("\n=== SWITCH STATEMENT ===\n");
        
        int day = 3;
        String dayName;
        
        switch (day) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
                break;
            case 7:
                dayName = "Sunday";
                break;
            default:
                dayName = "Invalid day";
                break;
        }
        
        System.out.println("Day " + day + " is " + dayName);
        
        // Switch with String (Java 7+)
        String month = "January";
        int quarter;
        
        switch (month) {
            case "January":
            case "February":
            case "March":
                quarter = 1;
                break;
            case "April":
            case "May":
            case "June":
                quarter = 2;
                break;
            case "July":
            case "August":
            case "September":
                quarter = 3;
                break;
            case "October":
            case "November":
            case "December":
                quarter = 4;
                break;
            default:
                quarter = 0;
                break;
        }
        
        System.out.println(month + " is in Quarter " + quarter);
        
        // Switch expression (Java 14+, preview feature)
        // Uncomment if using Java 14+
        /*
        String season = switch (month) {
            case "December", "January", "February" -> "Winter";
            case "March", "April", "May" -> "Spring";
            case "June", "July", "August" -> "Summer";
            case "September", "October", "November" -> "Fall";
            default -> "Unknown";
        };
        System.out.println("Season: " + season);
        */
        
        
        // ===== FOR LOOP =====
        
        System.out.println("\n=== FOR LOOP ===\n");
        
        // Basic for loop
        System.out.print("Counting 1 to 5: ");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Counting backwards
        System.out.print("Countdown from 5: ");
        for (int i = 5; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Step by 2
        System.out.print("Even numbers 0-10: ");
        for (int i = 0; i <= 10; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Multiple variables
        System.out.print("Multiple variables: ");
        for (int i = 0, j = 10; i < j; i++, j--) {
            System.out.print(i + "," + j + " ");
        }
        System.out.println();
        
        
        // ===== ENHANCED FOR LOOP (FOR-EACH) =====
        
        System.out.println("\n=== ENHANCED FOR LOOP ===\n");
        
        int[] numbers = {10, 20, 30, 40, 50};
        
        System.out.print("Array elements: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
        
        String[] fruits = {"Apple", "Banana", "Orange"};
        System.out.println("Fruits:");
        for (String fruit : fruits) {
            System.out.println("  - " + fruit);
        }
        
        
        // ===== WHILE LOOP =====
        
        System.out.println("\n=== WHILE LOOP ===\n");
        
        int count = 1;
        System.out.print("While loop (1-5): ");
        while (count <= 5) {
            System.out.print(count + " ");
            count++;
        }
        System.out.println();
        
        // Finding first power of 2 greater than 100
        int power = 1;
        while (power <= 100) {
            power *= 2;
        }
        System.out.println("First power of 2 > 100: " + power);
        
        
        // ===== DO-WHILE LOOP =====
        
        System.out.println("\n=== DO-WHILE LOOP ===\n");
        
        int counter = 1;
        System.out.print("Do-while loop (1-5): ");
        do {
            System.out.print(counter + " ");
            counter++;
        } while (counter <= 5);
        System.out.println();
        
        // Executes at least once even if condition is false
        int x = 10;
        do {
            System.out.println("This executes once even though x >= 10");
        } while (x < 10);
        
        
        // ===== BREAK STATEMENT =====
        
        System.out.println("\n=== BREAK STATEMENT ===\n");
        
        // Break in loop
        System.out.print("Break at 3: ");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                break;  // Exit loop when i is 3
            }
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Finding first number divisible by 7
        for (int i = 1; i <= 100; i++) {
            if (i % 7 == 0) {
                System.out.println("First number divisible by 7: " + i);
                break;
            }
        }
        
        
        // ===== CONTINUE STATEMENT =====
        
        System.out.println("\n=== CONTINUE STATEMENT ===\n");
        
        // Skip even numbers
        System.out.print("Odd numbers (1-10): ");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue;  // Skip rest of loop body for even numbers
            }
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Skip multiples of 3
        System.out.print("Skip multiples of 3 (1-15): ");
        for (int i = 1; i <= 15; i++) {
            if (i % 3 == 0) {
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println();
        
        
        // ===== NESTED LOOPS =====
        
        System.out.println("\n=== NESTED LOOPS ===\n");
        
        // Multiplication table
        System.out.println("Multiplication Table (1-5):");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }
        
        // Pattern printing
        System.out.println("\nTriangle Pattern:");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
        
        // ===== LABELED STATEMENTS =====
        
        System.out.println("\n=== LABELED STATEMENTS ===\n");
        
        // Break with label (breaks outer loop)
        System.out.println("Break outer loop:");
        outer: for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) {
                    System.out.println("Breaking outer loop at i=" + i + ", j=" + j);
                    break outer;
                }
                System.out.println("i=" + i + ", j=" + j);
            }
        }
        
        // Continue with label
        System.out.println("\nContinue outer loop:");
        outer2: for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (j == 2) {
                    continue outer2;
                }
                System.out.println("i=" + i + ", j=" + j);
            }
        }
        
        
        // ===== PRACTICAL EXAMPLES =====
        
        System.out.println("\n=== PRACTICAL EXAMPLES ===\n");
        
        // Find prime numbers from 2 to 20
        System.out.print("Prime numbers (2-20): ");
        for (int i = 2; i <= 20; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        
        // Fibonacci sequence
        System.out.print("Fibonacci (first 10): ");
        int a = 0, b = 1;
        for (int i = 0; i < 10; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
        
        // Sum of digits
        int number = 12345;
        int sum = 0;
        int temp = number;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        System.out.println("Sum of digits of " + number + ": " + sum);
    }
}

/*
 * KEY TAKEAWAYS:
 * 
 * 1. DECISION-MAKING STATEMENTS:
 *    - if: Execute code if condition is true
 *    - if-else: Choose between two alternatives
 *    - if-else-if: Choose among multiple alternatives
 *    - switch: Select one of many code blocks
 * 
 * 2. LOOP STATEMENTS:
 *    - for: Known number of iterations
 *    - while: Loop while condition is true (may not execute)
 *    - do-while: Loop at least once, then while condition is true
 *    - for-each: Iterate over arrays/collections
 * 
 * 3. JUMP STATEMENTS:
 *    - break: Exit loop or switch
 *    - continue: Skip current iteration, continue with next
 *    - return: Exit method and optionally return value
 * 
 * 4. BEST PRACTICES:
 *    - Use switch for multiple equality checks on same variable
 *    - Use for loop when you know iteration count
 *    - Use while when iteration count is unknown
 *    - Use enhanced for loop for arrays/collections
 *    - Avoid deep nesting (use methods or early returns)
 *    - Use meaningful variable names in loops
 * 
 * 5. COMMON PATTERNS:
 *    - Validation: if-else for input checking
 *    - Menu systems: switch statements
 *    - Array processing: for-each loops
 *    - Search algorithms: while with break
 *    - Pattern printing: nested for loops
 * 
 * COMPILE AND RUN:
 * javac 05_ControlFlow.java
 * java ControlFlow
 */
