/**
 * 10_Abstraction.java
 * 
 * TOPIC: Abstraction in Java
 * 
 * Abstraction is the process of hiding implementation details and showing only
 * essential features to the user. It focuses on WHAT an object does rather than HOW.
 * In Java, abstraction is achieved using abstract classes and interfaces.
 * 
 * KEY CONCEPTS:
 * - Abstract classes
 * - Abstract methods
 * - Concrete methods in abstract classes
 * - Cannot instantiate abstract classes
 * - Abstraction vs Encapsulation
 */

// ===== ABSTRACT CLASS BASICS =====

abstract class Animal {
    // Instance variables
    protected String name;
    protected int age;
    
    // Constructor (yes, abstract classes can have constructors)
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Abstract method (no implementation, must be overridden)
    public abstract void makeSound();
    
    // Abstract method
    public abstract void move();
    
    // Concrete method (has implementation, can be inherited as-is)
    public void sleep() {
        System.out.println(name + " is sleeping.");
    }
    
    public void eat() {
        System.out.println(name + " is eating.");
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Concrete class extending abstract class
class Dog extends Animal {
    private String breed;
    
    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }
    
    // Must implement all abstract methods
    @Override
    public void makeSound() {
        System.out.println(name + " barks: Woof! Woof!");
    }
    
    @Override
    public void move() {
        System.out.println(name + " runs on four legs.");
    }
    
    public void fetch() {
        System.out.println(name + " is fetching the ball.");
    }
}

class Bird extends Animal {
    private boolean canFly;
    
    public Bird(String name, int age, boolean canFly) {
        super(name, age);
        this.canFly = canFly;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " chirps: Tweet! Tweet!");
    }
    
    @Override
    public void move() {
        if (canFly) {
            System.out.println(name + " flies in the sky.");
        } else {
            System.out.println(name + " walks on the ground.");
        }
    }
}


// ===== ABSTRACT CLASS FOR SHAPES =====

abstract class Shape {
    protected String color;
    
    public Shape(String color) {
        this.color = color;
    }
    
    // Abstract methods - each shape calculates differently
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
    
    // Concrete method - common to all shapes
    public void displayColor() {
        System.out.println("Color: " + color);
    }
    
    // Concrete method with implementation
    public void displayInfo() {
        displayColor();
        System.out.printf("Area: %.2f%n", calculateArea());
        System.out.printf("Perimeter: %.2f%n", calculatePerimeter());
    }
}

class Circle extends Shape {
    private double radius;
    
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;
    
    public Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }
    
    @Override
    public double calculateArea() {
        return length * width;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}


// ===== ABSTRACT CLASS FOR BANK ACCOUNTS =====

abstract class BankAccount {
    protected String accountNumber;
    protected String holderName;
    protected double balance;
    
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }
    
    // Abstract method - different account types have different interest calculations
    public abstract double calculateInterest();
    
    // Abstract method - different withdrawal rules
    public abstract boolean canWithdraw(double amount);
    
    // Concrete methods - common to all accounts
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }
    
    public void withdraw(double amount) {
        if (canWithdraw(amount)) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Cannot withdraw $" + amount);
        }
    }
    
    public void displayBalance() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Holder: " + holderName);
        System.out.println("Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;
    private double minimumBalance;
    
    public SavingsAccount(String accountNumber, String holderName, double balance, 
                         double interestRate, double minimumBalance) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
        this.minimumBalance = minimumBalance;
    }
    
    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }
    
    @Override
    public boolean canWithdraw(double amount) {
        return (balance - amount) >= minimumBalance;
    }
}

class CheckingAccount extends BankAccount {
    private double overdraftLimit;
    
    public CheckingAccount(String accountNumber, String holderName, double balance, 
                          double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }
    
    @Override
    public double calculateInterest() {
        return 0;  // No interest on checking accounts
    }
    
    @Override
    public boolean canWithdraw(double amount) {
        return (balance - amount) >= -overdraftLimit;
    }
}


// ===== ABSTRACT CLASS WITH TEMPLATE METHOD PATTERN =====

abstract class DataProcessor {
    // Template method (defines the algorithm structure)
    public final void process() {
        readData();
        processData();
        writeData();
    }
    
    // Abstract methods to be implemented by subclasses
    protected abstract void readData();
    protected abstract void processData();
    protected abstract void writeData();
    
    // Concrete helper method
    protected void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

class CSVProcessor extends DataProcessor {
    @Override
    protected void readData() {
        log("Reading data from CSV file");
    }
    
    @Override
    protected void processData() {
        log("Processing CSV data");
    }
    
    @Override
    protected void writeData() {
        log("Writing data to CSV file");
    }
}

class JSONProcessor extends DataProcessor {
    @Override
    protected void readData() {
        log("Reading data from JSON file");
    }
    
    @Override
    protected void processData() {
        log("Processing JSON data");
    }
    
    @Override
    protected void writeData() {
        log("Writing data to JSON file");
    }
}


// ===== MAIN CLASS =====

public class Abstraction {
    
    public static void main(String[] args) {
        
        // ===== CANNOT INSTANTIATE ABSTRACT CLASS =====
        
        System.out.println("=== ABSTRACT CLASS BASICS ===\n");
        
        // This would cause a compile error:
        // Animal animal = new Animal("Generic", 5);
        
        // Must create instances of concrete subclasses
        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
        Bird bird = new Bird("Tweety", 1, true);
        Bird penguin = new Bird("Pingu", 2, false);
        
        dog.displayInfo();
        dog.makeSound();
        dog.move();
        dog.sleep();  // Inherited concrete method
        dog.fetch();  // Dog-specific method
        
        System.out.println();
        
        bird.displayInfo();
        bird.makeSound();
        bird.move();
        
        System.out.println();
        
        penguin.displayInfo();
        penguin.makeSound();
        penguin.move();
        
        
        // ===== POLYMORPHISM WITH ABSTRACT CLASSES =====
        
        System.out.println("\n=== POLYMORPHISM WITH ABSTRACT CLASSES ===\n");
        
        // Abstract class reference, concrete object
        Animal[] animals = {
            new Dog("Max", 4, "Labrador"),
            new Bird("Polly", 2, true),
            new Dog("Rocky", 5, "Bulldog")
        };
        
        for (Animal animal : animals) {
            animal.makeSound();
            animal.move();
            System.out.println();
        }
        
        
        // ===== ABSTRACT SHAPES =====
        
        System.out.println("=== ABSTRACT SHAPES ===\n");
        
        Shape circle = new Circle("Red", 5.0);
        Shape rectangle = new Rectangle("Blue", 4.0, 6.0);
        
        System.out.println("Circle:");
        circle.displayInfo();
        
        System.out.println("\nRectangle:");
        rectangle.displayInfo();
        
        // Using polymorphism
        Shape[] shapes = {circle, rectangle};
        double totalArea = 0;
        
        for (Shape shape : shapes) {
            totalArea += shape.calculateArea();
        }
        System.out.printf("%nTotal area of all shapes: %.2f%n", totalArea);
        
        
        // ===== ABSTRACT BANK ACCOUNTS =====
        
        System.out.println("\n=== ABSTRACT BANK ACCOUNTS ===\n");
        
        SavingsAccount savings = new SavingsAccount("SAV001", "Alice", 10000, 0.05, 1000);
        CheckingAccount checking = new CheckingAccount("CHK001", "Bob", 5000, 1000);
        
        System.out.println("--- Savings Account ---");
        savings.displayBalance();
        System.out.println("Interest: $" + savings.calculateInterest());
        savings.withdraw(500);
        savings.displayBalance();
        
        System.out.println("\n--- Checking Account ---");
        checking.displayBalance();
        System.out.println("Interest: $" + checking.calculateInterest());
        checking.withdraw(5500);  // Uses overdraft
        checking.displayBalance();
        
        // Polymorphic array
        System.out.println("\n--- All Accounts ---");
        BankAccount[] accounts = {savings, checking};
        
        for (BankAccount account : accounts) {
            System.out.println("\nAccount: " + account.accountNumber);
            System.out.println("Interest: $" + account.calculateInterest());
        }
        
        
        // ===== TEMPLATE METHOD PATTERN =====
        
        System.out.println("\n=== TEMPLATE METHOD PATTERN ===\n");
        
        System.out.println("Processing CSV:");
        DataProcessor csvProcessor = new CSVProcessor();
        csvProcessor.process();
        
        System.out.println("\nProcessing JSON:");
        DataProcessor jsonProcessor = new JSONProcessor();
        jsonProcessor.process();
        
        
        // ===== ABSTRACTION BENEFITS =====
        
        System.out.println("\n=== ABSTRACTION BENEFITS ===\n");
        
        System.out.println("1. Hides implementation details");
        System.out.println("2. Focuses on WHAT rather than HOW");
        System.out.println("3. Provides a common interface for related classes");
        System.out.println("4. Supports polymorphism");
        System.out.println("5. Enforces method implementation in subclasses");
        System.out.println("6. Allows partial implementation (concrete methods in abstract class)");
    }
}

/*
 * KEY TAKEAWAYS:
 * 
 * 1. ABSTRACT CLASS:
 *    - Declared with 'abstract' keyword
 *    - Cannot be instantiated directly
 *    - Can have abstract and concrete methods
 *    - Can have constructors, fields, and static methods
 *    - Used when classes share common behavior
 * 
 * 2. ABSTRACT METHOD:
 *    - Declared with 'abstract' keyword
 *    - No method body (no implementation)
 *    - Must be overridden in concrete subclass
 *    - Only exists in abstract classes or interfaces
 * 
 * 3. RULES:
 *    - Abstract class can have 0 or more abstract methods
 *    - If a class has even one abstract method, it must be abstract
 *    - Subclass must implement all abstract methods or be abstract itself
 *    - Abstract classes can extend other abstract classes
 *    - Can have constructors (called via super())
 * 
 * 4. ABSTRACTION vs ENCAPSULATION:
 *    - Abstraction: Hides complexity (WHAT to do)
 *    - Encapsulation: Hides data (HOW it's done)
 *    - Both promote information hiding
 *    - Often used together
 * 
 * 5. WHEN TO USE ABSTRACT CLASSES:
 *    - When classes share common behavior
 *    - When you want to provide default implementation
 *    - When you need constructors or instance variables
 *    - When you want to enforce method implementation
 *    - For template method pattern
 * 
 * 6. ABSTRACT CLASS vs INTERFACE:
 *    - Abstract class: Can have state (fields), constructors
 *    - Interface: Only method signatures (Java 8+ allows default methods)
 *    - Abstract class: Single inheritance
 *    - Interface: Multiple inheritance
 *    - Abstract class: For IS-A relationship
 *    - Interface: For CAN-DO relationship
 * 
 * 7. BEST PRACTICES:
 *    - Use abstract classes for common base functionality
 *    - Keep abstract classes focused and cohesive
 *    - Provide meaningful default implementations
 *    - Use template method pattern for algorithms
 *    - Prefer interfaces for defining contracts
 *    - Use abstract classes when you need to share code
 * 
 * COMPILE AND RUN:
 * javac 10_Abstraction.java
 * java Abstraction
 */
