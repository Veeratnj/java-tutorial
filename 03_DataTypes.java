/**
 * 03_DataTypes.java
 * 
 * TOPIC: Data Types in Java
 * 
 * Java is a strongly-typed language, meaning every variable must have a data type.
 * There are two categories: Primitive types and Reference types.
 * 
 * KEY CONCEPTS:
 * - Primitive data types (8 types)
 * - Reference data types (String, Arrays, Objects)
 * - Type casting (implicit and explicit)
 * - Wrapper classes
 * - Default values
 */

public class DataTypes {
    
    public static void main(String[] args) {
        
        // ===== PRIMITIVE DATA TYPES =====
        // Primitive types store simple values directly in memory
        
        System.out.println("=== PRIMITIVE DATA TYPES ===\n");
        
        // 1. byte: 8-bit integer (-128 to 127)
        byte byteVar = 100;
        System.out.println("byte: " + byteVar + " (Range: -128 to 127)");
        
        // 2. short: 16-bit integer (-32,768 to 32,767)
        short shortVar = 30000;
        System.out.println("short: " + shortVar + " (Range: -32,768 to 32,767)");
        
        // 3. int: 32-bit integer (-2^31 to 2^31-1)
        int intVar = 2147483647;
        System.out.println("int: " + intVar + " (Range: -2,147,483,648 to 2,147,483,647)");
        
        // 4. long: 64-bit integer (use 'L' suffix)
        long longVar = 9223372036854775807L;
        System.out.println("long: " + longVar + " (Range: -2^63 to 2^63-1)");
        
        // 5. float: 32-bit floating point (use 'f' suffix)
        float floatVar = 3.14f;
        System.out.println("float: " + floatVar + " (6-7 decimal digits precision)");
        
        // 6. double: 64-bit floating point (default for decimals)
        double doubleVar = 3.141592653589793;
        System.out.println("double: " + doubleVar + " (15 decimal digits precision)");
        
        // 7. char: 16-bit Unicode character (use single quotes)
        char charVar = 'A';
        char unicodeChar = '\u0041'; // Unicode for 'A'
        System.out.println("char: " + charVar + " (Unicode: " + unicodeChar + ")");
        
        // 8. boolean: true or false
        boolean boolVar = true;
        System.out.println("boolean: " + boolVar + " (true or false)");
        
        
        // ===== REFERENCE DATA TYPES =====
        
        System.out.println("\n=== REFERENCE DATA TYPES ===\n");
        
        // String: Sequence of characters (use double quotes)
        String stringVar = "Hello, Java!";
        System.out.println("String: " + stringVar);
        
        // Arrays: Collection of elements of same type
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Array: " + numbers[0] + ", " + numbers[1] + ", ...");
        
        // Objects: Instances of classes
        DataTypes obj = new DataTypes();
        System.out.println("Object: " + obj.getClass().getSimpleName());
        
        
        // ===== SIZE AND MEMORY =====
        
        System.out.println("\n=== SIZE IN MEMORY ===\n");
        System.out.println("byte:    " + Byte.BYTES + " byte(s)");
        System.out.println("short:   " + Short.BYTES + " byte(s)");
        System.out.println("int:     " + Integer.BYTES + " byte(s)");
        System.out.println("long:    " + Long.BYTES + " byte(s)");
        System.out.println("float:   " + Float.BYTES + " byte(s)");
        System.out.println("double:  " + Double.BYTES + " byte(s)");
        System.out.println("char:    " + Character.BYTES + " byte(s)");
        System.out.println("boolean: ~1 bit (JVM dependent)");
        
        
        // ===== TYPE CASTING =====
        
        System.out.println("\n=== TYPE CASTING ===\n");
        
        // Implicit casting (Widening) - automatic, no data loss
        // byte -> short -> int -> long -> float -> double
        int intValue = 100;
        long longValue = intValue;        // int to long (automatic)
        double doubleValue = intValue;    // int to double (automatic)
        
        System.out.println("Implicit Casting:");
        System.out.println("int " + intValue + " -> long " + longValue);
        System.out.println("int " + intValue + " -> double " + doubleValue);
        
        // Explicit casting (Narrowing) - manual, possible data loss
        // double -> float -> long -> int -> short -> byte
        double pi = 3.14159;
        int piInt = (int) pi;              // double to int (loses decimal)
        byte piByte = (byte) pi;           // double to byte
        
        System.out.println("\nExplicit Casting:");
        System.out.println("double " + pi + " -> int " + piInt + " (lost decimal part)");
        System.out.println("double " + pi + " -> byte " + piByte);
        
        // Casting with potential overflow
        int largeInt = 130;
        byte smallByte = (byte) largeInt;  // Overflow: 130 is outside byte range
        System.out.println("int " + largeInt + " -> byte " + smallByte + " (overflow!)");
        
        
        // ===== WRAPPER CLASSES =====
        
        System.out.println("\n=== WRAPPER CLASSES ===\n");
        
        // Each primitive type has a corresponding wrapper class
        Integer wrapperInt = 100;          // Autoboxing (int -> Integer)
        Double wrapperDouble = 99.99;      // Autoboxing (double -> Double)
        Boolean wrapperBoolean = true;     // Autoboxing (boolean -> Boolean)
        
        int primitiveInt = wrapperInt;     // Unboxing (Integer -> int)
        
        System.out.println("Wrapper Integer: " + wrapperInt);
        System.out.println("Wrapper Double: " + wrapperDouble);
        System.out.println("Wrapper Boolean: " + wrapperBoolean);
        
        // Wrapper classes provide useful methods
        System.out.println("\nWrapper Class Methods:");
        System.out.println("Max int value: " + Integer.MAX_VALUE);
        System.out.println("Min int value: " + Integer.MIN_VALUE);
        System.out.println("Parse string to int: " + Integer.parseInt("123"));
        System.out.println("Convert int to binary: " + Integer.toBinaryString(10));
        
        
        // ===== DEFAULT VALUES =====
        
        System.out.println("\n=== DEFAULT VALUES (for instance variables) ===\n");
        System.out.println("byte:    0");
        System.out.println("short:   0");
        System.out.println("int:     0");
        System.out.println("long:    0L");
        System.out.println("float:   0.0f");
        System.out.println("double:  0.0");
        System.out.println("char:    '\\u0000' (null character)");
        System.out.println("boolean: false");
        System.out.println("Reference types: null");
        
        
        // ===== SPECIAL NUMERIC NOTATIONS =====
        
        System.out.println("\n=== SPECIAL NUMERIC NOTATIONS ===\n");
        
        // Underscore for readability (Java 7+)
        int million = 1_000_000;
        long creditCard = 1234_5678_9012_3456L;
        System.out.println("Million: " + million);
        System.out.println("Credit Card: " + creditCard);
        
        // Binary (prefix: 0b)
        int binary = 0b1010;  // 10 in decimal
        System.out.println("Binary 0b1010 = " + binary);
        
        // Octal (prefix: 0)
        int octal = 012;      // 10 in decimal
        System.out.println("Octal 012 = " + octal);
        
        // Hexadecimal (prefix: 0x)
        int hex = 0xA;        // 10 in decimal
        System.out.println("Hexadecimal 0xA = " + hex);
        
        
        // ===== STRING OPERATIONS =====
        
        System.out.println("\n=== STRING OPERATIONS ===\n");
        
        String str1 = "Hello";
        String str2 = "World";
        String str3 = str1 + " " + str2;  // Concatenation
        
        System.out.println("Concatenation: " + str3);
        System.out.println("Length: " + str3.length());
        System.out.println("Uppercase: " + str3.toUpperCase());
        System.out.println("Character at index 0: " + str3.charAt(0));
        System.out.println("Substring: " + str3.substring(0, 5));
    }
}

/*
 * KEY TAKEAWAYS:
 * 
 * 1. PRIMITIVE TYPES (8 total):
 *    - Integer: byte, short, int, long
 *    - Floating-point: float, double
 *    - Character: char
 *    - Boolean: boolean
 * 
 * 2. REFERENCE TYPES:
 *    - String, Arrays, Objects, Interfaces
 *    - Store references (memory addresses) not actual values
 *    - Default value is null
 * 
 * 3. TYPE CASTING:
 *    - Widening (implicit): smaller to larger type
 *    - Narrowing (explicit): larger to smaller type (use parentheses)
 * 
 * 4. WRAPPER CLASSES:
 *    - Byte, Short, Integer, Long, Float, Double, Character, Boolean
 *    - Provide utility methods and allow primitives in collections
 * 
 * 5. BEST PRACTICES:
 *    - Use int for integers unless you need long
 *    - Use double for decimals (more precise than float)
 *    - Use String for text (not char arrays)
 *    - Be careful with explicit casting (data loss possible)
 * 
 * COMPILE AND RUN:
 * javac 03_DataTypes.java
 * java DataTypes
 */
