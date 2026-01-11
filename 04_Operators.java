/**
 * 04_Operators.java
 * 
 * TOPIC: Operators in Java
 * 
 * Operators are special symbols that perform operations on operands (variables/values).
 * Java provides various types of operators for different purposes.
 * 
 * KEY CONCEPTS:
 * - Arithmetic operators (+, -, *, /, %)
 * - Relational/Comparison operators (==, !=, >, <, >=, <=)
 * - Logical operators (&&, ||, !)
 * - Assignment operators (=, +=, -=, *=, /=, %=)
 * - Unary operators (++, --, +, -, !)
 * - Bitwise operators (&, |, ^, ~, <<, >>, >>>)
 * - Ternary operator (? :)
 * - instanceof operator
 */

public class Operators {
    
    public static void main(String[] args) {
        
        // ===== ARITHMETIC OPERATORS =====
        
        System.out.println("=== ARITHMETIC OPERATORS ===\n");
        
        int a = 10, b = 3;
        
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("Addition (a + b): " + (a + b));        // 13
        System.out.println("Subtraction (a - b): " + (a - b));     // 7
        System.out.println("Multiplication (a * b): " + (a * b));  // 30
        System.out.println("Division (a / b): " + (a / b));        // 3 (integer division)
        System.out.println("Modulus (a % b): " + (a % b));         // 1 (remainder)
        
        // Division with decimals
        double x = 10.0, y = 3.0;
        System.out.println("Division (10.0 / 3.0): " + (x / y));   // 3.333...
        
        
        // ===== UNARY OPERATORS =====
        
        System.out.println("\n=== UNARY OPERATORS ===\n");
        
        int num = 5;
        System.out.println("Original num: " + num);
        
        // Increment operators
        System.out.println("Post-increment (num++): " + (num++));  // Prints 5, then increments to 6
        System.out.println("After post-increment: " + num);        // 6
        
        System.out.println("Pre-increment (++num): " + (++num));   // Increments to 7, then prints 7
        System.out.println("After pre-increment: " + num);         // 7
        
        // Decrement operators
        System.out.println("Post-decrement (num--): " + (num--));  // Prints 7, then decrements to 6
        System.out.println("After post-decrement: " + num);        // 6
        
        System.out.println("Pre-decrement (--num): " + (--num));   // Decrements to 5, then prints 5
        System.out.println("After pre-decrement: " + num);         // 5
        
        // Unary plus and minus
        int positive = +num;  // +5
        int negative = -num;  // -5
        System.out.println("Unary plus (+num): " + positive);
        System.out.println("Unary minus (-num): " + negative);
        
        
        // ===== RELATIONAL (COMPARISON) OPERATORS =====
        
        System.out.println("\n=== RELATIONAL OPERATORS ===\n");
        
        int p = 10, q = 20;
        
        System.out.println("p = " + p + ", q = " + q);
        System.out.println("p == q (Equal to): " + (p == q));           // false
        System.out.println("p != q (Not equal to): " + (p != q));       // true
        System.out.println("p > q (Greater than): " + (p > q));         // false
        System.out.println("p < q (Less than): " + (p < q));            // true
        System.out.println("p >= q (Greater than or equal): " + (p >= q)); // false
        System.out.println("p <= q (Less than or equal): " + (p <= q));    // true
        
        
        // ===== LOGICAL OPERATORS =====
        
        System.out.println("\n=== LOGICAL OPERATORS ===\n");
        
        boolean isAdult = true;
        boolean hasLicense = false;
        
        System.out.println("isAdult = " + isAdult + ", hasLicense = " + hasLicense);
        
        // AND operator (both must be true)
        System.out.println("isAdult && hasLicense: " + (isAdult && hasLicense));  // false
        
        // OR operator (at least one must be true)
        System.out.println("isAdult || hasLicense: " + (isAdult || hasLicense));  // true
        
        // NOT operator (inverts the value)
        System.out.println("!isAdult: " + (!isAdult));                             // false
        System.out.println("!hasLicense: " + (!hasLicense));                       // true
        
        // Short-circuit evaluation
        int value = 0;
        boolean result = (value != 0) && (10 / value > 1);  // Second part not evaluated
        System.out.println("Short-circuit AND result: " + result);  // false (no division by zero)
        
        
        // ===== ASSIGNMENT OPERATORS =====
        
        System.out.println("\n=== ASSIGNMENT OPERATORS ===\n");
        
        int n = 10;
        System.out.println("Initial n: " + n);
        
        n += 5;  // n = n + 5
        System.out.println("After n += 5: " + n);   // 15
        
        n -= 3;  // n = n - 3
        System.out.println("After n -= 3: " + n);   // 12
        
        n *= 2;  // n = n * 2
        System.out.println("After n *= 2: " + n);   // 24
        
        n /= 4;  // n = n / 4
        System.out.println("After n /= 4: " + n);   // 6
        
        n %= 4;  // n = n % 4
        System.out.println("After n %= 4: " + n);   // 2
        
        
        // ===== TERNARY OPERATOR =====
        
        System.out.println("\n=== TERNARY OPERATOR ===\n");
        
        // Syntax: condition ? valueIfTrue : valueIfFalse
        int age = 20;
        String status = (age >= 18) ? "Adult" : "Minor";
        System.out.println("Age: " + age + ", Status: " + status);
        
        int score = 85;
        String grade = (score >= 90) ? "A" : 
                       (score >= 80) ? "B" : 
                       (score >= 70) ? "C" : "F";
        System.out.println("Score: " + score + ", Grade: " + grade);
        
        
        // ===== BITWISE OPERATORS =====
        
        System.out.println("\n=== BITWISE OPERATORS ===\n");
        
        int bit1 = 5;   // Binary: 0101
        int bit2 = 3;   // Binary: 0011
        
        System.out.println("bit1 = " + bit1 + " (binary: " + Integer.toBinaryString(bit1) + ")");
        System.out.println("bit2 = " + bit2 + " (binary: " + Integer.toBinaryString(bit2) + ")");
        
        // Bitwise AND
        System.out.println("bit1 & bit2: " + (bit1 & bit2) + " (binary: " + 
                          Integer.toBinaryString(bit1 & bit2) + ")");  // 1 (0001)
        
        // Bitwise OR
        System.out.println("bit1 | bit2: " + (bit1 | bit2) + " (binary: " + 
                          Integer.toBinaryString(bit1 | bit2) + ")");  // 7 (0111)
        
        // Bitwise XOR
        System.out.println("bit1 ^ bit2: " + (bit1 ^ bit2) + " (binary: " + 
                          Integer.toBinaryString(bit1 ^ bit2) + ")");  // 6 (0110)
        
        // Bitwise NOT (complement)
        System.out.println("~bit1: " + (~bit1));  // -6 (inverts all bits)
        
        // Left shift (multiply by 2^n)
        System.out.println("bit1 << 1: " + (bit1 << 1) + " (multiply by 2)");  // 10
        
        // Right shift (divide by 2^n)
        System.out.println("bit1 >> 1: " + (bit1 >> 1) + " (divide by 2)");    // 2
        
        // Unsigned right shift
        System.out.println("bit1 >>> 1: " + (bit1 >>> 1));  // 2
        
        
        // ===== INSTANCEOF OPERATOR =====
        
        System.out.println("\n=== INSTANCEOF OPERATOR ===\n");
        
        String text = "Hello";
        Integer number = 100;
        
        System.out.println("text instanceof String: " + (text instanceof String));      // true
        System.out.println("number instanceof Integer: " + (number instanceof Integer)); // true
        System.out.println("text instanceof Object: " + (text instanceof Object));      // true
        System.out.println("number instanceof String: " + (number instanceof String));  // false
        
        
        // ===== OPERATOR PRECEDENCE =====
        
        System.out.println("\n=== OPERATOR PRECEDENCE ===\n");
        
        int result1 = 10 + 5 * 2;        // Multiplication first: 10 + 10 = 20
        int result2 = (10 + 5) * 2;      // Parentheses first: 15 * 2 = 30
        
        System.out.println("10 + 5 * 2 = " + result1);
        System.out.println("(10 + 5) * 2 = " + result2);
        
        boolean complexResult = 5 > 3 && 10 < 20 || false;
        System.out.println("5 > 3 && 10 < 20 || false = " + complexResult);  // true
        
        
        // ===== STRING CONCATENATION WITH + =====
        
        System.out.println("\n=== STRING CONCATENATION ===\n");
        
        String firstName = "John";
        String lastName = "Doe";
        String fullName = firstName + " " + lastName;
        System.out.println("Full Name: " + fullName);
        
        // Mixing strings and numbers
        System.out.println("Result: " + 10 + 20);      // "Result: 1020" (string concatenation)
        System.out.println("Result: " + (10 + 20));    // "Result: 30" (addition first)
        System.out.println(10 + 20 + " Result");       // "30 Result" (left to right)
    }
}

/*
 * KEY TAKEAWAYS:
 * 
 * 1. OPERATOR CATEGORIES:
 *    - Arithmetic: +, -, *, /, %
 *    - Relational: ==, !=, >, <, >=, <=
 *    - Logical: &&, ||, !
 *    - Assignment: =, +=, -=, *=, /=, %=
 *    - Unary: ++, --, +, -, !
 *    - Bitwise: &, |, ^, ~, <<, >>, >>>
 *    - Ternary: ? :
 *    - instanceof
 * 
 * 2. OPERATOR PRECEDENCE (highest to lowest):
 *    1. Postfix: expr++, expr--
 *    2. Unary: ++expr, --expr, +expr, -expr, !
 *    3. Multiplicative: *, /, %
 *    4. Additive: +, -
 *    5. Shift: <<, >>, >>>
 *    6. Relational: <, >, <=, >=, instanceof
 *    7. Equality: ==, !=
 *    8. Bitwise AND: &
 *    9. Bitwise XOR: ^
 *    10. Bitwise OR: |
 *    11. Logical AND: &&
 *    12. Logical OR: ||
 *    13. Ternary: ? :
 *    14. Assignment: =, +=, -=, etc.
 * 
 * 3. IMPORTANT NOTES:
 *    - Use parentheses to make precedence clear
 *    - Be careful with integer division (10/3 = 3, not 3.33)
 *    - Post-increment returns value then increments
 *    - Pre-increment increments then returns value
 *    - Logical operators use short-circuit evaluation
 * 
 * COMPILE AND RUN:
 * javac 04_Operators.java
 * java Operators
 */
