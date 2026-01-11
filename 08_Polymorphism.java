/**
 * 08_Polymorphism.java
 * 
 * TOPIC: Polymorphism in Java
 * 
 * Polymorphism means "many forms". It allows objects to take on multiple forms
 * and enables one interface to be used for a general class of actions.
 * 
 * KEY CONCEPTS:
 * - Compile-time polymorphism (Method Overloading)
 * - Runtime polymorphism (Method Overriding)
 * - Dynamic method dispatch
 * - Upcasting and downcasting
 * - instanceof operator
 */

// ===== RUNTIME POLYMORPHISM (METHOD OVERRIDING) =====

class Shape {
    protected String color;
    
    public Shape(String color) {
        this.color = color;
    }
    
    // Method to be overridden
    public double calculateArea() {
        return 0;
    }
    
    public double calculatePerimeter() {
        return 0;
    }
    
    public void display() {
        System.out.println("Shape color: " + color);
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
    
    @Override
    public void display() {
        super.display();
        System.out.println("Circle - Radius: " + radius);
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
    
    @Override
    public void display() {
        super.display();
        System.out.println("Rectangle - Length: " + length + ", Width: " + width);
    }
}

class Triangle extends Shape {
    private double base;
    private double height;
    private double side1, side2, side3;
    
    public Triangle(String color, double base, double height, double side1, double side2, double side3) {
        super(color);
        this.base = base;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    
    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
    
    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }
    
    @Override
    public void display() {
        super.display();
        System.out.println("Triangle - Base: " + base + ", Height: " + height);
    }
}


// ===== COMPILE-TIME POLYMORPHISM (METHOD OVERLOADING) =====

class MathOperations {
    
    // Overloaded methods with different parameter counts
    public int multiply(int a, int b) {
        return a * b;
    }
    
    public int multiply(int a, int b, int c) {
        return a * b * c;
    }
    
    // Overloaded methods with different parameter types
    public double multiply(double a, double b) {
        return a * b;
    }
    
    // Overloaded methods with different parameter order
    public void display(String message, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(message);
        }
    }
    
    public void display(int count, String message) {
        System.out.println("Count: " + count + ", Message: " + message);
    }
}


// ===== POLYMORPHIC BEHAVIOR WITH ARRAYS =====

class Animal {
    protected String name;
    
    public Animal(String name) {
        this.name = name;
    }
    
    public void makeSound() {
        System.out.println(name + " makes a sound");
    }
    
    public void move() {
        System.out.println(name + " is moving");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " barks: Woof!");
    }
    
    @Override
    public void move() {
        System.out.println(name + " runs on four legs");
    }
}

class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " chirps: Tweet!");
    }
    
    @Override
    public void move() {
        System.out.println(name + " flies in the sky");
    }
}

class Fish extends Animal {
    public Fish(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " makes bubbles");
    }
    
    @Override
    public void move() {
        System.out.println(name + " swims in water");
    }
}


// ===== DYNAMIC METHOD DISPATCH =====

class Payment {
    protected double amount;
    
    public Payment(double amount) {
        this.amount = amount;
    }
    
    public void processPayment() {
        System.out.println("Processing payment of $" + amount);
    }
    
    public void showReceipt() {
        System.out.println("Payment receipt: $" + amount);
    }
}

class CreditCardPayment extends Payment {
    private String cardNumber;
    
    public CreditCardPayment(double amount, String cardNumber) {
        super(amount);
        this.cardNumber = cardNumber;
    }
    
    @Override
    public void processPayment() {
        System.out.println("Processing credit card payment of $" + amount);
        System.out.println("Card: ****" + cardNumber.substring(cardNumber.length() - 4));
    }
}

class PayPalPayment extends Payment {
    private String email;
    
    public PayPalPayment(double amount, String email) {
        super(amount);
        this.email = email;
    }
    
    @Override
    public void processPayment() {
        System.out.println("Processing PayPal payment of $" + amount);
        System.out.println("Email: " + email);
    }
}

class CashPayment extends Payment {
    public CashPayment(double amount) {
        super(amount);
    }
    
    @Override
    public void processPayment() {
        System.out.println("Processing cash payment of $" + amount);
        System.out.println("Please provide exact change");
    }
}


// ===== MAIN CLASS =====

public class Polymorphism {
    
    public static void main(String[] args) {
        
        // ===== RUNTIME POLYMORPHISM =====
        
        System.out.println("=== RUNTIME POLYMORPHISM ===\n");
        
        // Parent reference, child objects
        Shape shape1 = new Circle("Red", 5.0);
        Shape shape2 = new Rectangle("Blue", 4.0, 6.0);
        Shape shape3 = new Triangle("Green", 3.0, 4.0, 3.0, 4.0, 5.0);
        
        // Dynamic method dispatch - correct method called at runtime
        System.out.println("Circle:");
        shape1.display();
        System.out.println("Area: " + shape1.calculateArea());
        System.out.println("Perimeter: " + shape1.calculatePerimeter());
        
        System.out.println("\nRectangle:");
        shape2.display();
        System.out.println("Area: " + shape2.calculateArea());
        System.out.println("Perimeter: " + shape2.calculatePerimeter());
        
        System.out.println("\nTriangle:");
        shape3.display();
        System.out.println("Area: " + shape3.calculateArea());
        System.out.println("Perimeter: " + shape3.calculatePerimeter());
        
        
        // ===== COMPILE-TIME POLYMORPHISM =====
        
        System.out.println("\n=== COMPILE-TIME POLYMORPHISM ===\n");
        
        MathOperations math = new MathOperations();
        
        System.out.println("multiply(5, 3): " + math.multiply(5, 3));
        System.out.println("multiply(5, 3, 2): " + math.multiply(5, 3, 2));
        System.out.println("multiply(5.5, 2.5): " + math.multiply(5.5, 2.5));
        
        System.out.println("\nDisplay methods:");
        math.display("Hello", 2);
        math.display(3, "World");
        
        
        // ===== POLYMORPHIC ARRAYS =====
        
        System.out.println("\n=== POLYMORPHIC ARRAYS ===\n");
        
        // Array of parent type holding child objects
        Animal[] animals = new Animal[4];
        animals[0] = new Dog("Buddy");
        animals[1] = new Bird("Tweety");
        animals[2] = new Fish("Nemo");
        animals[3] = new Animal("Generic");
        
        // Iterate and call overridden methods
        for (Animal animal : animals) {
            animal.makeSound();
            animal.move();
            System.out.println();
        }
        
        
        // ===== DYNAMIC METHOD DISPATCH =====
        
        System.out.println("=== DYNAMIC METHOD DISPATCH ===\n");
        
        Payment payment1 = new CreditCardPayment(100.50, "1234567890123456");
        Payment payment2 = new PayPalPayment(75.25, "user@example.com");
        Payment payment3 = new CashPayment(50.00);
        
        // Process different payment types polymorphically
        processTransaction(payment1);
        System.out.println();
        processTransaction(payment2);
        System.out.println();
        processTransaction(payment3);
        
        
        // ===== UPCASTING AND DOWNCASTING =====
        
        System.out.println("\n=== UPCASTING AND DOWNCASTING ===\n");
        
        // Upcasting (implicit, automatic)
        Circle circle = new Circle("Yellow", 7.0);
        Shape shape = circle;  // Upcasting: Circle -> Shape
        System.out.println("Upcasted circle area: " + shape.calculateArea());
        
        // Downcasting (explicit, manual)
        if (shape instanceof Circle) {
            Circle downcastedCircle = (Circle) shape;  // Downcasting: Shape -> Circle
            System.out.println("Downcasted successfully");
            downcastedCircle.display();
        }
        
        // Unsafe downcasting (would throw ClassCastException)
        Shape rectShape = new Rectangle("Purple", 5.0, 3.0);
        // Circle wrongCast = (Circle) rectShape;  // Runtime error!
        
        // Safe downcasting with instanceof
        if (rectShape instanceof Circle) {
            Circle c = (Circle) rectShape;
            System.out.println("Is a Circle");
        } else {
            System.out.println("Not a Circle, cannot downcast");
        }
        
        
        // ===== INSTANCEOF OPERATOR =====
        
        System.out.println("\n=== INSTANCEOF OPERATOR ===\n");
        
        Shape[] shapes = {
            new Circle("Red", 3.0),
            new Rectangle("Blue", 4.0, 5.0),
            new Triangle("Green", 3.0, 4.0, 3.0, 4.0, 5.0)
        };
        
        for (Shape s : shapes) {
            if (s instanceof Circle) {
                System.out.println("Found a Circle");
            } else if (s instanceof Rectangle) {
                System.out.println("Found a Rectangle");
            } else if (s instanceof Triangle) {
                System.out.println("Found a Triangle");
            }
            System.out.println("Area: " + s.calculateArea());
            System.out.println();
        }
        
        
        // ===== POLYMORPHISM BENEFITS =====
        
        System.out.println("=== POLYMORPHISM BENEFITS ===\n");
        
        // Single method can work with different types
        printShapeInfo(new Circle("Orange", 4.0));
        printShapeInfo(new Rectangle("Pink", 6.0, 3.0));
        printShapeInfo(new Triangle("Brown", 5.0, 6.0, 5.0, 6.0, 7.0));
    }
    
    // Helper method demonstrating polymorphism
    public static void processTransaction(Payment payment) {
        System.out.println("--- Processing Transaction ---");
        payment.processPayment();
        payment.showReceipt();
    }
    
    // Method that accepts any Shape (polymorphic parameter)
    public static void printShapeInfo(Shape shape) {
        System.out.println("--- Shape Information ---");
        shape.display();
        System.out.printf("Area: %.2f%n", shape.calculateArea());
        System.out.printf("Perimeter: %.2f%n", shape.calculatePerimeter());
        System.out.println();
    }
}

/*
 * KEY TAKEAWAYS:
 * 
 * 1. TYPES OF POLYMORPHISM:
 *    - Compile-time (Static): Method overloading
 *    - Runtime (Dynamic): Method overriding
 * 
 * 2. METHOD OVERLOADING (Compile-time):
 *    - Same method name, different parameters
 *    - Different number of parameters
 *    - Different types of parameters
 *    - Different order of parameters
 *    - Return type alone is NOT enough
 * 
 * 3. METHOD OVERRIDING (Runtime):
 *    - Same signature as parent method
 *    - Determined at runtime based on object type
 *    - Enables dynamic method dispatch
 *    - Use @Override annotation
 * 
 * 4. DYNAMIC METHOD DISPATCH:
 *    - JVM determines which method to call at runtime
 *    - Based on actual object type, not reference type
 *    - Enables true polymorphic behavior
 * 
 * 5. UPCASTING vs DOWNCASTING:
 *    - Upcasting: Child -> Parent (automatic, safe)
 *    - Downcasting: Parent -> Child (manual, risky)
 *    - Use instanceof before downcasting
 * 
 * 6. BENEFITS:
 *    - Code flexibility and extensibility
 *    - Single interface for multiple implementations
 *    - Easier maintenance and updates
 *    - Supports loose coupling
 * 
 * 7. BEST PRACTICES:
 *    - Use polymorphism for cleaner, more maintainable code
 *    - Program to interfaces/superclasses, not implementations
 *    - Always check with instanceof before downcasting
 *    - Use @Override annotation for clarity
 *    - Avoid excessive downcasting (sign of poor design)
 * 
 * COMPILE AND RUN:
 * javac 08_Polymorphism.java
 * java Polymorphism
 */
