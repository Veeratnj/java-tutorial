/**
 * 07_Inheritance.java
 * 
 * TOPIC: Inheritance in Java
 * 
 * Inheritance is a mechanism where a new class (child/subclass) inherits
 * properties and behaviors from an existing class (parent/superclass).
 * It promotes code reusability and establishes a relationship between classes.
 * 
 * KEY CONCEPTS:
 * - extends keyword
 * - super keyword
 * - Method overriding
 * - Constructor chaining
 * - Types of inheritance
 * - IS-A relationship
 * - Object class (root of all classes)
 */

// ===== BASIC INHERITANCE =====

// Parent class (Superclass/Base class)
class Animal {
    String name;
    int age;
    
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void eat() {
        System.out.println(name + " is eating.");
    }
    
    public void sleep() {
        System.out.println(name + " is sleeping.");
    }
    
    public void makeSound() {
        System.out.println(name + " makes a sound.");
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Child class (Subclass/Derived class)
class Dog extends Animal {
    String breed;
    
    public Dog(String name, int age, String breed) {
        super(name, age);  // Call parent constructor
        this.breed = breed;
    }
    
    // Method overriding: Providing specific implementation
    @Override
    public void makeSound() {
        System.out.println(name + " barks: Woof! Woof!");
    }
    
    // New method specific to Dog
    public void fetch() {
        System.out.println(name + " is fetching the ball.");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();  // Call parent method
        System.out.println("Breed: " + breed);
    }
}

class Cat extends Animal {
    boolean isIndoor;
    
    public Cat(String name, int age, boolean isIndoor) {
        super(name, age);
        this.isIndoor = isIndoor;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " meows: Meow! Meow!");
    }
    
    public void scratch() {
        System.out.println(name + " is scratching.");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Indoor: " + isIndoor);
    }
}


// ===== MULTILEVEL INHERITANCE =====

class Vehicle {
    String brand;
    int year;
    
    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }
    
    public void start() {
        System.out.println(brand + " vehicle is starting.");
    }
    
    public void stop() {
        System.out.println(brand + " vehicle is stopping.");
    }
}

class Car extends Vehicle {
    int doors;
    
    public Car(String brand, int year, int doors) {
        super(brand, year);
        this.doors = doors;
    }
    
    @Override
    public void start() {
        System.out.println(brand + " car is starting with key.");
    }
    
    public void drive() {
        System.out.println("Driving the " + brand + " car.");
    }
}

class ElectricCar extends Car {
    int batteryCapacity;
    
    public ElectricCar(String brand, int year, int doors, int batteryCapacity) {
        super(brand, year, doors);
        this.batteryCapacity = batteryCapacity;
    }
    
    @Override
    public void start() {
        System.out.println(brand + " electric car is starting silently.");
    }
    
    public void charge() {
        System.out.println("Charging " + brand + " with " + batteryCapacity + " kWh battery.");
    }
}


// ===== HIERARCHICAL INHERITANCE =====

class Employee {
    protected String name;
    protected int id;
    protected double baseSalary;
    
    public Employee(String name, int id, double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }
    
    public double calculateSalary() {
        return baseSalary;
    }
    
    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: $" + baseSalary);
    }
}

class Manager extends Employee {
    private double bonus;
    
    public Manager(String name, int id, double baseSalary, double bonus) {
        super(name, id, baseSalary);
        this.bonus = bonus;
    }
    
    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Bonus: $" + bonus);
        System.out.println("Total Salary: $" + calculateSalary());
    }
}

class Developer extends Employee {
    private String programmingLanguage;
    private double projectBonus;
    
    public Developer(String name, int id, double baseSalary, String language, double projectBonus) {
        super(name, id, baseSalary);
        this.programmingLanguage = language;
        this.projectBonus = projectBonus;
    }
    
    @Override
    public double calculateSalary() {
        return baseSalary + projectBonus;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Language: " + programmingLanguage);
        System.out.println("Project Bonus: $" + projectBonus);
        System.out.println("Total Salary: $" + calculateSalary());
    }
}


// ===== PROTECTED ACCESS MODIFIER =====

class BankAccount {
    private String accountNumber;      // Only accessible within this class
    protected double balance;          // Accessible in subclasses
    public String holderName;          // Accessible everywhere
    
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }
    
    protected void displayBalance() {
        System.out.println("Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;
    
    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }
    
    public void addInterest() {
        // Can access protected member 'balance' from parent
        balance += balance * interestRate;
        System.out.println("Interest added. New balance: $" + balance);
    }
    
    public void showAccountInfo() {
        System.out.println("Holder: " + holderName);  // public member
        displayBalance();  // protected method
        // Cannot access accountNumber (private in parent)
    }
}


// ===== MAIN CLASS =====

public class Inheritance {
    
    public static void main(String[] args) {
        
        // ===== BASIC INHERITANCE =====
        
        System.out.println("=== BASIC INHERITANCE ===\n");
        
        // Creating parent class object
        Animal animal = new Animal("Generic Animal", 5);
        animal.displayInfo();
        animal.makeSound();
        animal.eat();
        
        System.out.println();
        
        // Creating child class objects
        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
        dog.displayInfo();
        dog.makeSound();  // Overridden method
        dog.eat();        // Inherited method
        dog.fetch();      // Dog-specific method
        
        System.out.println();
        
        Cat cat = new Cat("Whiskers", 2, true);
        cat.displayInfo();
        cat.makeSound();  // Overridden method
        cat.sleep();      // Inherited method
        cat.scratch();    // Cat-specific method
        
        
        // ===== MULTILEVEL INHERITANCE =====
        
        System.out.println("\n=== MULTILEVEL INHERITANCE ===\n");
        
        Vehicle vehicle = new Vehicle("Generic", 2020);
        vehicle.start();
        vehicle.stop();
        
        System.out.println();
        
        Car car = new Car("Toyota", 2022, 4);
        car.start();  // Overridden in Car
        car.drive();
        car.stop();   // Inherited from Vehicle
        
        System.out.println();
        
        ElectricCar tesla = new ElectricCar("Tesla", 2023, 4, 100);
        tesla.start();   // Overridden in ElectricCar
        tesla.drive();   // Inherited from Car
        tesla.charge();  // ElectricCar-specific
        tesla.stop();    // Inherited from Vehicle
        
        
        // ===== HIERARCHICAL INHERITANCE =====
        
        System.out.println("\n=== HIERARCHICAL INHERITANCE ===\n");
        
        Manager manager = new Manager("Alice Smith", 101, 80000, 20000);
        System.out.println("--- Manager Info ---");
        manager.displayInfo();
        
        System.out.println();
        
        Developer developer = new Developer("Bob Johnson", 102, 75000, "Java", 15000);
        System.out.println("--- Developer Info ---");
        developer.displayInfo();
        
        
        // ===== POLYMORPHISM WITH INHERITANCE =====
        
        System.out.println("\n=== POLYMORPHISM ===\n");
        
        // Parent reference, child object
        Animal myPet1 = new Dog("Max", 4, "Labrador");
        Animal myPet2 = new Cat("Luna", 1, false);
        
        // Calls overridden methods in child classes
        myPet1.makeSound();  // Dog's makeSound
        myPet2.makeSound();  // Cat's makeSound
        
        // Cannot call child-specific methods
        // myPet1.fetch();  // Compile error
        
        // Need to cast to access child-specific methods
        if (myPet1 instanceof Dog) {
            Dog myDog = (Dog) myPet1;
            myDog.fetch();
        }
        
        
        // ===== PROTECTED ACCESS =====
        
        System.out.println("\n=== PROTECTED ACCESS ===\n");
        
        SavingsAccount savings = new SavingsAccount("SAV001", "John Doe", 10000, 0.05);
        savings.showAccountInfo();
        savings.addInterest();
        savings.showAccountInfo();
        
        
        // ===== IS-A RELATIONSHIP =====
        
        System.out.println("\n=== IS-A RELATIONSHIP ===\n");
        
        Dog dog2 = new Dog("Rocky", 5, "Bulldog");
        
        System.out.println("dog2 is a Dog: " + (dog2 instanceof Dog));
        System.out.println("dog2 is an Animal: " + (dog2 instanceof Animal));
        System.out.println("dog2 is an Object: " + (dog2 instanceof Object));
        
        
        // ===== CONSTRUCTOR CHAINING =====
        
        System.out.println("\n=== CONSTRUCTOR CHAINING ===\n");
        
        System.out.println("Creating ElectricCar object:");
        ElectricCar ev = new ElectricCar("Nissan Leaf", 2024, 4, 62);
        // Constructor chain: ElectricCar -> Car -> Vehicle
        
        
        // ===== METHOD OVERRIDING RULES =====
        
        System.out.println("\n=== METHOD OVERRIDING RULES ===\n");
        
        Employee emp = new Manager("Sarah", 103, 70000, 15000);
        System.out.println("Employee salary: $" + emp.calculateSalary());
        // Calls Manager's overridden method, not Employee's
    }
}

/*
 * KEY TAKEAWAYS:
 * 
 * 1. INHERITANCE SYNTAX:
 *    - Use 'extends' keyword
 *    - Child class inherits all non-private members
 *    - Java supports single inheritance (one parent only)
 * 
 * 2. TYPES OF INHERITANCE:
 *    - Single: Child extends one parent
 *    - Multilevel: Child extends parent, grandchild extends child
 *    - Hierarchical: Multiple children extend same parent
 *    - Multiple: NOT supported in Java (use interfaces instead)
 * 
 * 3. SUPER KEYWORD:
 *    - super() calls parent constructor
 *    - super.method() calls parent method
 *    - Must be first statement in constructor
 * 
 * 4. METHOD OVERRIDING:
 *    - Same signature as parent method
 *    - Use @Override annotation (recommended)
 *    - Cannot reduce visibility (public -> private)
 *    - Cannot override static, final, or private methods
 * 
 * 5. ACCESS MODIFIERS IN INHERITANCE:
 *    - private: Not inherited
 *    - protected: Inherited, accessible in subclass
 *    - public: Inherited, accessible everywhere
 *    - default: Inherited if in same package
 * 
 * 6. BENEFITS:
 *    - Code reusability
 *    - Method overriding (runtime polymorphism)
 *    - Establishes IS-A relationship
 *    - Hierarchical classification
 * 
 * 7. BEST PRACTICES:
 *    - Use inheritance for IS-A relationships
 *    - Prefer composition over inheritance when appropriate
 *    - Don't inherit just to reuse code
 *    - Keep inheritance hierarchies shallow
 *    - Use @Override annotation
 * 
 * COMPILE AND RUN:
 * javac 07_Inheritance.java
 * java Inheritance
 */
