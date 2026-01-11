/**
 * 06_Classes.java
 * 
 * TOPIC: Classes and Objects in Java
 * 
 * A class is a blueprint for creating objects. It defines the structure and behavior
 * that objects of that class will have. An object is an instance of a class.
 * 
 * KEY CONCEPTS:
 * - Class declaration and structure
 * - Instance variables (fields)
 * - Methods (behaviors)
 * - Constructors
 * - The 'this' keyword
 * - Object creation and usage
 * - Access modifiers (public, private, protected, default)
 */

// ===== SIMPLE CLASS EXAMPLE =====

class Student {
    // Instance variables (fields/attributes)
    String name;
    int age;
    String major;
    double gpa;
    
    // Method to display student information
    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Major: " + major);
        System.out.println("GPA: " + gpa);
    }
    
    // Method to check if student is on honor roll
    boolean isHonorRoll() {
        return gpa >= 3.5;
    }
}


// ===== CLASS WITH CONSTRUCTORS =====

class Book {
    // Instance variables
    private String title;
    private String author;
    private int pages;
    private double price;
    
    // Default constructor (no parameters)
    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.pages = 0;
        this.price = 0.0;
    }
    
    // Parameterized constructor
    public Book(String title, String author, int pages, double price) {
        this.title = title;      // 'this' refers to instance variable
        this.author = author;
        this.pages = pages;
        this.price = price;
    }
    
    // Constructor overloading (different parameters)
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.pages = 0;
        this.price = 0.0;
    }
    
    // Getter methods (accessors)
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public int getPages() {
        return pages;
    }
    
    public double getPrice() {
        return price;
    }
    
    // Setter methods (mutators)
    public void setPrice(double price) {
        if (price >= 0) {  // Validation
            this.price = price;
        }
    }
    
    public void setPages(int pages) {
        if (pages >= 0) {
            this.pages = pages;
        }
    }
    
    // Method to display book information
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Pages: " + pages);
        System.out.println("Price: $" + price);
    }
    
    // Method to apply discount
    public void applyDiscount(double percentage) {
        if (percentage > 0 && percentage <= 100) {
            price = price - (price * percentage / 100);
        }
    }
}


// ===== CLASS WITH STATIC MEMBERS =====

class BankAccount {
    // Instance variables (unique to each object)
    private String accountNumber;
    private String holderName;
    private double balance;
    
    // Static variable (shared by all instances)
    private static int totalAccounts = 0;
    private static final double INTEREST_RATE = 0.05;  // Static constant
    
    // Constructor
    public BankAccount(String accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
        totalAccounts++;  // Increment for each new account
    }
    
    // Instance method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds!");
        }
    }
    
    public void displayBalance() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Holder: " + holderName);
        System.out.println("Balance: $" + balance);
    }
    
    public void addInterest() {
        balance += balance * INTEREST_RATE;
        System.out.println("Interest added at " + (INTEREST_RATE * 100) + "%");
    }
    
    // Static method (can be called without creating an object)
    public static int getTotalAccounts() {
        return totalAccounts;
    }
    
    public static void displayBankInfo() {
        System.out.println("Total Accounts: " + totalAccounts);
        System.out.println("Interest Rate: " + (INTEREST_RATE * 100) + "%");
    }
}


// ===== CLASS WITH METHOD OVERLOADING =====

class Calculator {
    // Method overloading: Same name, different parameters
    
    // Add two integers
    public int add(int a, int b) {
        return a + b;
    }
    
    // Add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }
    
    // Add two doubles
    public double add(double a, double b) {
        return a + b;
    }
    
    // Add array of integers
    public int add(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}


// ===== MAIN CLASS =====

public class Classes {
    
    public static void main(String[] args) {
        
        // ===== CREATING AND USING OBJECTS =====
        
        System.out.println("=== SIMPLE CLASS EXAMPLE ===\n");
        
        // Creating an object (instance of Student class)
        Student student1 = new Student();
        
        // Setting values
        student1.name = "Alice Johnson";
        student1.age = 20;
        student1.major = "Computer Science";
        student1.gpa = 3.8;
        
        // Calling methods
        student1.displayInfo();
        System.out.println("Honor Roll: " + student1.isHonorRoll());
        
        // Creating another object
        Student student2 = new Student();
        student2.name = "Bob Smith";
        student2.age = 22;
        student2.major = "Mathematics";
        student2.gpa = 3.2;
        
        System.out.println("\nStudent 2:");
        student2.displayInfo();
        System.out.println("Honor Roll: " + student2.isHonorRoll());
        
        
        // ===== USING CONSTRUCTORS =====
        
        System.out.println("\n=== CONSTRUCTORS ===\n");
        
        // Using default constructor
        Book book1 = new Book();
        System.out.println("Book 1 (default constructor):");
        book1.displayInfo();
        
        // Using parameterized constructor
        Book book2 = new Book("1984", "George Orwell", 328, 15.99);
        System.out.println("\nBook 2 (parameterized constructor):");
        book2.displayInfo();
        
        // Using overloaded constructor
        Book book3 = new Book("The Hobbit", "J.R.R. Tolkien");
        System.out.println("\nBook 3 (overloaded constructor):");
        book3.displayInfo();
        
        
        // ===== USING GETTERS AND SETTERS =====
        
        System.out.println("\n=== GETTERS AND SETTERS ===\n");
        
        System.out.println("Book 2 title: " + book2.getTitle());
        System.out.println("Book 2 author: " + book2.getAuthor());
        
        // Modifying using setters
        book3.setPages(310);
        book3.setPrice(12.99);
        System.out.println("\nBook 3 after updates:");
        book3.displayInfo();
        
        // Applying discount
        book2.applyDiscount(20);  // 20% discount
        System.out.println("\nBook 2 after 20% discount:");
        book2.displayInfo();
        
        
        // ===== STATIC MEMBERS =====
        
        System.out.println("\n=== STATIC MEMBERS ===\n");
        
        // Calling static method without creating object
        System.out.println("Initial bank info:");
        BankAccount.displayBankInfo();
        
        // Creating bank accounts
        BankAccount account1 = new BankAccount("ACC001", "John Doe", 1000.0);
        BankAccount account2 = new BankAccount("ACC002", "Jane Smith", 2000.0);
        BankAccount account3 = new BankAccount("ACC003", "Bob Johnson", 1500.0);
        
        System.out.println("\nAfter creating 3 accounts:");
        BankAccount.displayBankInfo();
        System.out.println("Total accounts: " + BankAccount.getTotalAccounts());
        
        // Using instance methods
        System.out.println("\n--- Account 1 Operations ---");
        account1.displayBalance();
        account1.deposit(500);
        account1.withdraw(200);
        account1.addInterest();
        account1.displayBalance();
        
        
        // ===== METHOD OVERLOADING =====
        
        System.out.println("\n=== METHOD OVERLOADING ===\n");
        
        Calculator calc = new Calculator();
        
        System.out.println("Add two ints (5, 3): " + calc.add(5, 3));
        System.out.println("Add three ints (5, 3, 2): " + calc.add(5, 3, 2));
        System.out.println("Add two doubles (5.5, 3.2): " + calc.add(5.5, 3.2));
        
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Add array [1,2,3,4,5]: " + calc.add(numbers));
        
        
        // ===== OBJECT REFERENCES =====
        
        System.out.println("\n=== OBJECT REFERENCES ===\n");
        
        Student s1 = new Student();
        s1.name = "Charlie";
        s1.age = 21;
        
        // s2 references the same object as s1
        Student s2 = s1;
        
        System.out.println("s1 name: " + s1.name);
        System.out.println("s2 name: " + s2.name);
        
        // Changing s2 affects s1 (they reference the same object)
        s2.name = "Charlie Brown";
        System.out.println("\nAfter changing s2.name:");
        System.out.println("s1 name: " + s1.name);
        System.out.println("s2 name: " + s2.name);
        
        
        // ===== NULL REFERENCES =====
        
        System.out.println("\n=== NULL REFERENCES ===\n");
        
        Student s3 = null;  // No object created
        System.out.println("s3 is null: " + (s3 == null));
        
        // This would cause NullPointerException:
        // s3.displayInfo();
        
        // Safe way to check before using
        if (s3 != null) {
            s3.displayInfo();
        } else {
            System.out.println("s3 is null, cannot call methods");
        }
    }
}

/*
 * KEY TAKEAWAYS:
 * 
 * 1. CLASS STRUCTURE:
 *    - Fields (instance variables): Store object state
 *    - Methods: Define object behavior
 *    - Constructors: Initialize objects
 *    - Static members: Shared by all instances
 * 
 * 2. CONSTRUCTORS:
 *    - Same name as class
 *    - No return type
 *    - Can be overloaded
 *    - Default constructor provided if none defined
 * 
 * 3. THE 'this' KEYWORD:
 *    - Refers to current object
 *    - Used to distinguish instance variables from parameters
 *    - Can call other constructors: this(params)
 * 
 * 4. STATIC vs INSTANCE:
 *    - Static: Belongs to class, shared by all instances
 *    - Instance: Belongs to object, unique to each instance
 *    - Static methods can't access instance variables directly
 * 
 * 5. ACCESS MODIFIERS:
 *    - public: Accessible from anywhere
 *    - private: Accessible only within the class
 *    - protected: Accessible within package and subclasses
 *    - default (no modifier): Accessible within package
 * 
 * 6. BEST PRACTICES:
 *    - Make fields private, provide public getters/setters
 *    - Use constructors to ensure valid object state
 *    - Use meaningful class and method names
 *    - Keep classes focused on single responsibility
 *    - Validate input in setters
 * 
 * COMPILE AND RUN:
 * javac 06_Classes.java
 * java Classes
 */
