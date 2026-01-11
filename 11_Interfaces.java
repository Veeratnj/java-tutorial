/**
 * 11_Interfaces.java
 * 
 * TOPIC: Interfaces in Java
 * 
 * An interface is a completely abstract type that defines a contract of methods
 * that implementing classes must provide. It's used to achieve abstraction and
 * multiple inheritance in Java.
 * 
 * KEY CONCEPTS:
 * - Interface declaration and implementation
 * - Multiple interface implementation
 * - Default methods (Java 8+)
 * - Static methods in interfaces (Java 8+)
 * - Private methods in interfaces (Java 9+)
 * - Functional interfaces
 */

// ===== BASIC INTERFACE =====

interface Animal {
    // All methods are public and abstract by default
    void makeSound();
    void eat();
    void sleep();
}

class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks: Woof!");
    }
    
    @Override
    public void eat() {
        System.out.println("Dog is eating.");
    }
    
    @Override
    public void sleep() {
        System.out.println("Dog is sleeping.");
    }
}

class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat meows: Meow!");
    }
    
    @Override
    public void eat() {
        System.out.println("Cat is eating.");
    }
    
    @Override
    public void sleep() {
        System.out.println("Cat is sleeping.");
    }
}


// ===== MULTIPLE INTERFACE IMPLEMENTATION =====

interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Duck implements Animal, Flyable, Swimmable {
    @Override
    public void makeSound() {
        System.out.println("Duck quacks: Quack!");
    }
    
    @Override
    public void eat() {
        System.out.println("Duck is eating.");
    }
    
    @Override
    public void sleep() {
        System.out.println("Duck is sleeping.");
    }
    
    @Override
    public void fly() {
        System.out.println("Duck is flying.");
    }
    
    @Override
    public void swim() {
        System.out.println("Duck is swimming.");
    }
}


// ===== INTERFACE WITH CONSTANTS =====

interface MathConstants {
    // All fields are public, static, and final by default
    double PI = 3.14159;
    double E = 2.71828;
    int MAX_VALUE = 100;
}

class Calculator implements MathConstants {
    public double calculateCircleArea(double radius) {
        return PI * radius * radius;
    }
    
    public double calculateExponential(double power) {
        return Math.pow(E, power);
    }
}


// ===== DEFAULT METHODS (Java 8+) =====

interface Vehicle {
    // Abstract method
    void start();
    void stop();
    
    // Default method (has implementation)
    default void honk() {
        System.out.println("Beep beep!");
    }
    
    default void displayInfo() {
        System.out.println("This is a vehicle.");
    }
}

class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car is starting.");
    }
    
    @Override
    public void stop() {
        System.out.println("Car is stopping.");
    }
    
    // Can override default method
    @Override
    public void honk() {
        System.out.println("Car horn: Honk honk!");
    }
}

class Bike implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bike is starting.");
    }
    
    @Override
    public void stop() {
        System.out.println("Bike is stopping.");
    }
    
    // Uses default honk() method
}


// ===== STATIC METHODS IN INTERFACES (Java 8+) =====

interface Utility {
    static void printMessage(String message) {
        System.out.println("Message: " + message);
    }
    
    static int add(int a, int b) {
        return a + b;
    }
}


// ===== FUNCTIONAL INTERFACE =====

@FunctionalInterface
interface Calculator2 {
    // Only one abstract method
    int calculate(int a, int b);
    
    // Can have default and static methods
    default void printResult(int result) {
        System.out.println("Result: " + result);
    }
}


// ===== INTERFACE INHERITANCE =====

interface Shape {
    double calculateArea();
}

interface ColoredShape extends Shape {
    String getColor();
}

class Circle implements ColoredShape {
    private double radius;
    private String color;
    
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public String getColor() {
        return color;
    }
}


// ===== PRACTICAL EXAMPLE: PAYMENT SYSTEM =====

interface PaymentMethod {
    boolean processPayment(double amount);
    String getPaymentType();
    
    default void printReceipt(double amount) {
        System.out.println("--- Receipt ---");
        System.out.println("Payment Type: " + getPaymentType());
        System.out.println("Amount: $" + amount);
        System.out.println("---------------");
    }
}

class CreditCard implements PaymentMethod {
    private String cardNumber;
    private double balance;
    
    public CreditCard(String cardNumber, double balance) {
        this.cardNumber = cardNumber;
        this.balance = balance;
    }
    
    @Override
    public boolean processPayment(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Credit card payment successful!");
            return true;
        }
        System.out.println("Insufficient balance!");
        return false;
    }
    
    @Override
    public String getPaymentType() {
        return "Credit Card";
    }
}

class PayPal implements PaymentMethod {
    private String email;
    private double balance;
    
    public PayPal(String email, double balance) {
        this.email = email;
        this.balance = balance;
    }
    
    @Override
    public boolean processPayment(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("PayPal payment successful!");
            return true;
        }
        System.out.println("Insufficient PayPal balance!");
        return false;
    }
    
    @Override
    public String getPaymentType() {
        return "PayPal";
    }
}


// ===== MAIN CLASS =====

public class Interfaces {
    
    public static void main(String[] args) {
        
        // ===== BASIC INTERFACE USAGE =====
        
        System.out.println("=== BASIC INTERFACE ===\n");
        
        Animal dog = new Dog();
        Animal cat = new Cat();
        
        dog.makeSound();
        dog.eat();
        dog.sleep();
        
        System.out.println();
        
        cat.makeSound();
        cat.eat();
        cat.sleep();
        
        
        // ===== MULTIPLE INTERFACES =====
        
        System.out.println("\n=== MULTIPLE INTERFACES ===\n");
        
        Duck duck = new Duck();
        duck.makeSound();
        duck.fly();
        duck.swim();
        
        
        // ===== INTERFACE CONSTANTS =====
        
        System.out.println("\n=== INTERFACE CONSTANTS ===\n");
        
        Calculator calc = new Calculator();
        System.out.println("PI: " + MathConstants.PI);
        System.out.println("Circle area (radius 5): " + calc.calculateCircleArea(5));
        System.out.println("e^2: " + calc.calculateExponential(2));
        
        
        // ===== DEFAULT METHODS =====
        
        System.out.println("\n=== DEFAULT METHODS ===\n");
        
        Car car = new Car();
        car.start();
        car.honk();  // Overridden default method
        car.displayInfo();  // Inherited default method
        car.stop();
        
        System.out.println();
        
        Bike bike = new Bike();
        bike.start();
        bike.honk();  // Uses default implementation
        bike.stop();
        
        
        // ===== STATIC METHODS =====
        
        System.out.println("\n=== STATIC METHODS ===\n");
        
        Utility.printMessage("Hello from interface!");
        System.out.println("5 + 3 = " + Utility.add(5, 3));
        
        
        // ===== FUNCTIONAL INTERFACE =====
        
        System.out.println("\n=== FUNCTIONAL INTERFACE ===\n");
        
        // Using lambda expression
        Calculator2 addition = (a, b) -> a + b;
        Calculator2 multiplication = (a, b) -> a * b;
        
        int sum = addition.calculate(10, 5);
        int product = multiplication.calculate(10, 5);
        
        addition.printResult(sum);
        multiplication.printResult(product);
        
        
        // ===== INTERFACE INHERITANCE =====
        
        System.out.println("\n=== INTERFACE INHERITANCE ===\n");
        
        Circle circle = new Circle(5.0, "Red");
        System.out.println("Color: " + circle.getColor());
        System.out.println("Area: " + circle.calculateArea());
        
        
        // ===== PAYMENT SYSTEM =====
        
        System.out.println("\n=== PAYMENT SYSTEM ===\n");
        
        PaymentMethod creditCard = new CreditCard("1234-5678", 1000);
        PaymentMethod paypal = new PayPal("user@example.com", 500);
        
        double amount = 100;
        
        if (creditCard.processPayment(amount)) {
            creditCard.printReceipt(amount);
        }
        
        System.out.println();
        
        if (paypal.processPayment(amount)) {
            paypal.printReceipt(amount);
        }
        
        
        // ===== POLYMORPHISM WITH INTERFACES =====
        
        System.out.println("\n=== POLYMORPHISM ===\n");
        
        Animal[] animals = {new Dog(), new Cat(), new Duck()};
        
        for (Animal animal : animals) {
            animal.makeSound();
        }
    }
}

/*
 * KEY TAKEAWAYS:
 * 
 * 1. INTERFACE BASICS:
 *    - Declared with 'interface' keyword
 *    - All methods are public and abstract by default
 *    - All fields are public, static, and final
 *    - Cannot be instantiated
 *    - Implemented using 'implements' keyword
 * 
 * 2. MULTIPLE IMPLEMENTATION:
 *    - A class can implement multiple interfaces
 *    - Solves multiple inheritance problem
 *    - Syntax: class MyClass implements Interface1, Interface2
 * 
 * 3. DEFAULT METHODS (Java 8+):
 *    - Provide default implementation
 *    - Can be overridden
 *    - Allow adding new methods without breaking existing code
 * 
 * 4. STATIC METHODS (Java 8+):
 *    - Called using interface name
 *    - Cannot be overridden
 *    - Utility methods
 * 
 * 5. FUNCTIONAL INTERFACE:
 *    - Has exactly one abstract method
 *    - Can have default and static methods
 *    - Used with lambda expressions
 *    - @FunctionalInterface annotation (optional but recommended)
 * 
 * 6. INTERFACE vs ABSTRACT CLASS:
 *    - Interface: Multiple inheritance, no state
 *    - Abstract class: Single inheritance, can have state
 *    - Interface: CAN-DO relationship
 *    - Abstract class: IS-A relationship
 * 
 * 7. BEST PRACTICES:
 *    - Use interfaces to define contracts
 *    - Keep interfaces focused and cohesive
 *    - Use default methods for backward compatibility
 *    - Prefer interfaces over abstract classes for flexibility
 *    - Use functional interfaces with lambdas
 * 
 * COMPILE AND RUN:
 * javac 11_Interfaces.java
 * java Interfaces
 */
