/**
 * 23_Java8Features.java - Java 8+ Modern Features
 * 
 * Covers Optional, Date/Time API, forEach, and default methods
 */

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Java8Features {
    
    public static void main(String[] args) {
        
        // ===== OPTIONAL CLASS =====
        
        System.out.println("=== OPTIONAL CLASS ===\n");
        
        // Creating Optional
        Optional<String> optional1 = Optional.of("Hello");
        Optional<String> optional2 = Optional.ofNullable(null);
        Optional<String> optional3 = Optional.empty();
        
        System.out.println("optional1 present: " + optional1.isPresent());
        System.out.println("optional2 present: " + optional2.isPresent());
        
        // Getting value
        if (optional1.isPresent()) {
            System.out.println("Value: " + optional1.get());
        }
        
        // orElse - provide default
        String value1 = optional2.orElse("Default Value");
        System.out.println("With orElse: " + value1);
        
        // orElseGet - lazy evaluation
        String value2 = optional2.orElseGet(() -> "Computed Default");
        System.out.println("With orElseGet: " + value2);
        
        // orElseThrow
        try {
            String value3 = optional2.orElseThrow(() -> new RuntimeException("Value not present"));
        } catch (RuntimeException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        
        // ifPresent - execute if value exists
        optional1.ifPresent(val -> System.out.println("Value exists: " + val));
        
        // map - transform value
        Optional<Integer> length = optional1.map(String::length);
        System.out.println("String length: " + length.orElse(0));
        
        // filter
        Optional<String> filtered = optional1.filter(s -> s.startsWith("H"));
        System.out.println("Filtered: " + filtered.orElse("Not found"));
        
        
        // ===== DATE AND TIME API =====
        
        System.out.println("\n=== DATE AND TIME API ===\n");
        
        // LocalDate
        LocalDate today = LocalDate.now();
        LocalDate specificDate = LocalDate.of(2024, 1, 15);
        LocalDate parsedDate = LocalDate.parse("2024-12-25");
        
        System.out.println("Today: " + today);
        System.out.println("Specific date: " + specificDate);
        System.out.println("Parsed date: " + parsedDate);
        
        // Date operations
        LocalDate tomorrow = today.plusDays(1);
        LocalDate nextWeek = today.plusWeeks(1);
        LocalDate nextMonth = today.plusMonths(1);
        
        System.out.println("Tomorrow: " + tomorrow);
        System.out.println("Next week: " + nextWeek);
        System.out.println("Next month: " + nextMonth);
        
        // LocalTime
        LocalTime now = LocalTime.now();
        LocalTime specificTime = LocalTime.of(14, 30, 0);
        
        System.out.println("\nCurrent time: " + now);
        System.out.println("Specific time: " + specificTime);
        
        // LocalDateTime
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDateTime specificDateTime = LocalDateTime.of(2024, 12, 25, 10, 30);
        
        System.out.println("\nCurrent date-time: " + dateTime);
        System.out.println("Specific date-time: " + specificDateTime);
        
        // Formatting
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatted = dateTime.format(formatter);
        System.out.println("Formatted: " + formatted);
        
        // Period (date-based)
        Period period = Period.between(specificDate, today);
        System.out.println("\nPeriod: " + period.getYears() + " years, " + 
                          period.getMonths() + " months, " + period.getDays() + " days");
        
        // Duration (time-based)
        Duration duration = Duration.between(specificTime, now);
        System.out.println("Duration: " + duration.toHours() + " hours");
        
        
        // ===== FOREACH METHOD =====
        
        System.out.println("\n=== FOREACH METHOD ===\n");
        
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        
        // forEach with lambda
        names.forEach(name -> System.out.println("Hello, " + name));
        
        // forEach with method reference
        System.out.println("\nWith method reference:");
        names.forEach(System.out::println);
        
        // Map forEach
        Map<String, Integer> ages = new HashMap<>();
        ages.put("Alice", 25);
        ages.put("Bob", 30);
        
        System.out.println("\nMap forEach:");
        ages.forEach((name, age) -> System.out.println(name + ": " + age));
        
        
        // ===== DEFAULT METHODS IN INTERFACES =====
        
        System.out.println("\n=== DEFAULT METHODS ===\n");
        
        Vehicle car = new Car();
        car.start();
        car.honk();  // Default method
        
        
        // ===== PRACTICAL EXAMPLES =====
        
        System.out.println("\n=== PRACTICAL EXAMPLES ===\n");
        
        // Optional with database query simulation
        Optional<String> user = findUserById(101);
        user.ifPresentOrElse(
            u -> System.out.println("User found: " + u),
            () -> System.out.println("User not found")
        );
        
        // Date calculations
        LocalDate birthday = LocalDate.of(1990, 5, 15);
        Period age = Period.between(birthday, LocalDate.now());
        System.out.println("Age: " + age.getYears() + " years");
        
        // Working days calculation
        LocalDate start = LocalDate.of(2024, 1, 1);
        LocalDate end = LocalDate.of(2024, 1, 31);
        long days = start.datesUntil(end).count();
        System.out.println("Days in January 2024: " + days);
    }
    
    // Helper method
    static Optional<String> findUserById(int id) {
        return id == 101 ? Optional.of("John Doe") : Optional.empty();
    }
}

// Interface with default method
interface Vehicle {
    void start();
    
    default void honk() {
        System.out.println("Beep beep!");
    }
}

class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car started");
    }
}

/*
 * KEY TAKEAWAYS:
 * 
 * OPTIONAL:
 * - Avoid NullPointerException
 * - of(), ofNullable(), empty()
 * - isPresent(), get(), orElse(), orElseGet()
 * - map(), filter(), ifPresent()
 * 
 * DATE/TIME API:
 * - LocalDate: Date without time
 * - LocalTime: Time without date
 * - LocalDateTime: Date and time
 * - Period: Date-based amount
 * - Duration: Time-based amount
 * 
 * COMPILE AND RUN:
 * javac 23_Java8Features.java
 * java Java8Features
 */
