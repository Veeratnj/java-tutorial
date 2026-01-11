/**
 * 09_Encapsulation.java
 * 
 * TOPIC: Encapsulation in Java
 * 
 * Encapsulation is the bundling of data (variables) and methods that operate on
 * the data into a single unit (class), and restricting direct access to some
 * components. It's achieved through access modifiers and getter/setter methods.
 * 
 * KEY CONCEPTS:
 * - Data hiding
 * - Access modifiers (private, public, protected, default)
 * - Getter and setter methods
 * - Benefits of encapsulation
 * - Validation in setters
 * - Read-only and write-only properties
 */

// ===== BASIC ENCAPSULATION =====

class Person {
    // Private fields (data hiding)
    private String name;
    private int age;
    private String email;
    
    // Constructor
    public Person(String name, int age, String email) {
        this.name = name;
        setAge(age);      // Use setter for validation
        setEmail(email);  // Use setter for validation
    }
    
    // Getter methods (read access)
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getEmail() {
        return email;
    }
    
    // Setter methods (write access with validation)
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid name!");
        }
    }
    
    public void setAge(int age) {
        if (age >= 0 && age <= 150) {
            this.age = age;
        } else {
            System.out.println("Invalid age! Must be between 0 and 150.");
        }
    }
    
    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("Invalid email format!");
        }
    }
    
    // Method to display information
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
    }
}


// ===== ENCAPSULATION WITH VALIDATION =====

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private String pin;
    
    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double initialBalance, String pin) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance >= 0 ? initialBalance : 0;
        this.pin = pin;
    }
    
    // Getter for account number (read-only, no setter)
    public String getAccountNumber() {
        return accountNumber;
    }
    
    // Getter for account holder (read-only)
    public String getAccountHolder() {
        return accountHolder;
    }
    
    // Getter for balance (read-only)
    public double getBalance() {
        return balance;
    }
    
    // No getter for PIN (completely hidden)
    
    // Deposit method (controlled way to modify balance)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
            System.out.println("New balance: $" + balance);
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }
    
    // Withdraw method with validation
    public void withdraw(double amount, String enteredPin) {
        if (!verifyPin(enteredPin)) {
            System.out.println("Invalid PIN!");
            return;
        }
        
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive!");
        } else if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
            System.out.println("Remaining balance: $" + balance);
        }
    }
    
    // Private helper method (internal use only)
    private boolean verifyPin(String enteredPin) {
        return this.pin.equals(enteredPin);
    }
    
    // Change PIN with validation
    public void changePin(String oldPin, String newPin) {
        if (verifyPin(oldPin)) {
            if (newPin != null && newPin.length() == 4) {
                this.pin = newPin;
                System.out.println("PIN changed successfully!");
            } else {
                System.out.println("New PIN must be 4 digits!");
            }
        } else {
            System.out.println("Invalid old PIN!");
        }
    }
}


// ===== IMMUTABLE CLASS (READ-ONLY) =====

final class ImmutableStudent {
    private final String studentId;
    private final String name;
    private final int age;
    
    // Constructor is the only way to set values
    public ImmutableStudent(String studentId, String name, int age) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
    }
    
    // Only getters, no setters
    public String getStudentId() {
        return studentId;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    // To "modify", create a new object
    public ImmutableStudent withAge(int newAge) {
        return new ImmutableStudent(this.studentId, this.name, newAge);
    }
    
    public ImmutableStudent withName(String newName) {
        return new ImmutableStudent(this.studentId, newName, this.age);
    }
}


// ===== ENCAPSULATION WITH COMPUTED PROPERTIES =====

class Rectangle {
    private double length;
    private double width;
    
    public Rectangle(double length, double width) {
        setLength(length);
        setWidth(width);
    }
    
    public double getLength() {
        return length;
    }
    
    public void setLength(double length) {
        if (length > 0) {
            this.length = length;
        } else {
            System.out.println("Length must be positive!");
        }
    }
    
    public double getWidth() {
        return width;
    }
    
    public void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        } else {
            System.out.println("Width must be positive!");
        }
    }
    
    // Computed property (no field, calculated on demand)
    public double getArea() {
        return length * width;
    }
    
    public double getPerimeter() {
        return 2 * (length + width);
    }
    
    public boolean isSquare() {
        return length == width;
    }
}


// ===== ACCESS MODIFIERS DEMONSTRATION =====

class AccessModifiersDemo {
    public String publicField = "Public - accessible everywhere";
    private String privateField = "Private - only within this class";
    protected String protectedField = "Protected - within package and subclasses";
    String defaultField = "Default - within package only";
    
    public void publicMethod() {
        System.out.println("Public method");
        // Can access all fields here
        System.out.println(publicField);
        System.out.println(privateField);
        System.out.println(protectedField);
        System.out.println(defaultField);
    }
    
    private void privateMethod() {
        System.out.println("Private method - only accessible within this class");
    }
    
    protected void protectedMethod() {
        System.out.println("Protected method - accessible in package and subclasses");
    }
    
    void defaultMethod() {
        System.out.println("Default method - accessible within package");
    }
    
    public void demonstrateAccess() {
        // Can call all methods here
        publicMethod();
        privateMethod();
        protectedMethod();
        defaultMethod();
    }
}


// ===== MAIN CLASS =====

public class Encapsulation {
    
    public static void main(String[] args) {
        
        // ===== BASIC ENCAPSULATION =====
        
        System.out.println("=== BASIC ENCAPSULATION ===\n");
        
        Person person = new Person("John Doe", 30, "john@example.com");
        
        // Cannot access private fields directly
        // System.out.println(person.name);  // Compile error!
        
        // Must use getters
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Email: " + person.getEmail());
        
        // Using setters with validation
        System.out.println("\nUpdating person information:");
        person.setAge(35);
        person.setEmail("john.doe@example.com");
        person.displayInfo();
        
        // Validation in action
        System.out.println("\nTrying invalid values:");
        person.setAge(200);      // Invalid
        person.setAge(-5);       // Invalid
        person.setEmail("invalid");  // Invalid
        
        
        // ===== BANK ACCOUNT ENCAPSULATION =====
        
        System.out.println("\n=== BANK ACCOUNT ENCAPSULATION ===\n");
        
        BankAccount account = new BankAccount("ACC001", "Alice Smith", 1000.0, "1234");
        
        System.out.println("Account: " + account.getAccountNumber());
        System.out.println("Holder: " + account.getAccountHolder());
        System.out.println("Balance: $" + account.getBalance());
        
        // Cannot directly modify balance
        // account.balance = 10000;  // Compile error!
        
        // Must use controlled methods
        System.out.println("\nDepositing money:");
        account.deposit(500);
        
        System.out.println("\nWithdrawing with correct PIN:");
        account.withdraw(200, "1234");
        
        System.out.println("\nWithdrawing with wrong PIN:");
        account.withdraw(100, "0000");
        
        System.out.println("\nTrying to withdraw more than balance:");
        account.withdraw(2000, "1234");
        
        System.out.println("\nChanging PIN:");
        account.changePin("1234", "5678");
        account.withdraw(100, "5678");  // Works with new PIN
        
        
        // ===== IMMUTABLE CLASS =====
        
        System.out.println("\n=== IMMUTABLE CLASS ===\n");
        
        ImmutableStudent student1 = new ImmutableStudent("S001", "Bob", 20);
        System.out.println("Student: " + student1.getName() + ", Age: " + student1.getAge());
        
        // Cannot modify (no setters)
        // student1.setAge(21);  // Compile error!
        
        // Create new object with modified value
        ImmutableStudent student2 = student1.withAge(21);
        System.out.println("Original: " + student1.getName() + ", Age: " + student1.getAge());
        System.out.println("Modified: " + student2.getName() + ", Age: " + student2.getAge());
        
        
        // ===== COMPUTED PROPERTIES =====
        
        System.out.println("\n=== COMPUTED PROPERTIES ===\n");
        
        Rectangle rect = new Rectangle(5.0, 3.0);
        System.out.println("Length: " + rect.getLength());
        System.out.println("Width: " + rect.getWidth());
        System.out.println("Area: " + rect.getArea());        // Computed
        System.out.println("Perimeter: " + rect.getPerimeter());  // Computed
        System.out.println("Is Square: " + rect.isSquare());  // Computed
        
        System.out.println("\nChanging dimensions:");
        rect.setLength(4.0);
        rect.setWidth(4.0);
        System.out.println("Area: " + rect.getArea());
        System.out.println("Is Square: " + rect.isSquare());
        
        
        // ===== ACCESS MODIFIERS =====
        
        System.out.println("\n=== ACCESS MODIFIERS ===\n");
        
        AccessModifiersDemo demo = new AccessModifiersDemo();
        
        // Can access public members
        System.out.println(demo.publicField);
        demo.publicMethod();
        
        // Cannot access private members
        // System.out.println(demo.privateField);  // Compile error!
        // demo.privateMethod();  // Compile error!
        
        // Can access protected and default (same package)
        System.out.println(demo.protectedField);
        System.out.println(demo.defaultField);
        demo.protectedMethod();
        demo.defaultMethod();
        
        System.out.println("\nDemonstrating internal access:");
        demo.demonstrateAccess();
        
        
        // ===== BENEFITS DEMONSTRATION =====
        
        System.out.println("\n=== BENEFITS OF ENCAPSULATION ===\n");
        
        System.out.println("1. Data Hiding: Private fields cannot be accessed directly");
        System.out.println("2. Validation: Setters can validate data before setting");
        System.out.println("3. Flexibility: Can change internal implementation without affecting users");
        System.out.println("4. Read-only/Write-only: Control access level (getters only, setters only)");
        System.out.println("5. Computed Properties: Calculate values on demand");
        System.out.println("6. Security: Sensitive data (like PIN) can be completely hidden");
    }
}

/*
 * KEY TAKEAWAYS:
 * 
 * 1. ENCAPSULATION PRINCIPLES:
 *    - Bundle data and methods together
 *    - Hide internal state (private fields)
 *    - Provide controlled access (public methods)
 *    - Validate data before modification
 * 
 * 2. ACCESS MODIFIERS:
 *    - private: Only within the class
 *    - default (no modifier): Within the package
 *    - protected: Within package and subclasses
 *    - public: Everywhere
 * 
 * 3. GETTER/SETTER PATTERNS:
 *    - Getters: public Type getFieldName()
 *    - Setters: public void setFieldName(Type value)
 *    - Boolean getters: public boolean isFieldName()
 * 
 * 4. BENEFITS:
 *    - Data hiding and security
 *    - Flexibility to change implementation
 *    - Validation and error checking
 *    - Read-only or write-only properties
 *    - Computed properties
 *    - Better maintainability
 * 
 * 5. IMMUTABILITY:
 *    - Make class final
 *    - Make all fields private and final
 *    - No setters
 *    - Initialize in constructor only
 * 
 * 6. BEST PRACTICES:
 *    - Make fields private by default
 *    - Provide getters/setters only when needed
 *    - Validate in setters
 *    - Use meaningful names (getName, not getN)
 *    - Consider immutability for value objects
 *    - Don't expose internal collections directly
 * 
 * COMPILE AND RUN:
 * javac 09_Encapsulation.java
 * java Encapsulation
 */
