/**
 * 16_FileIO.java - File Input/Output Tutorial
 * 
 * Java provides various classes for reading from and writing to files.
 * This tutorial covers basic file operations using different approaches.
 */

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileIO {
    public static void main(String[] args) {
        
        String filename = "sample.txt";
        
        // ===== WRITING TO FILE =====
        
        System.out.println("=== WRITING TO FILE ===\n");
        
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Hello, World!\n");
            writer.write("This is a test file.\n");
            writer.write("Java File I/O is easy!\n");
            System.out.println("File written successfully!");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
        
        // ===== READING FROM FILE =====
        
        System.out.println("\n=== READING FROM FILE ===\n");
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        // ===== APPENDING TO FILE =====
        
        System.out.println("\n=== APPENDING TO FILE ===\n");
        
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write("Appended line!\n");
            System.out.println("Line appended successfully!");
        } catch (IOException e) {
            System.out.println("Error appending: " + e.getMessage());
        }
        
        // ===== USING FILES CLASS (Java 7+) =====
        
        System.out.println("\n=== USING FILES CLASS ===\n");
        
        try {
            // Write all lines
            List<String> lines = Arrays.asList("Line 1", "Line 2", "Line 3");
            Files.write(Paths.get("lines.txt"), lines);
            
            // Read all lines
            List<String> readLines = Files.readAllLines(Paths.get("lines.txt"));
            System.out.println("Read lines: " + readLines);
            
            // Delete file
            Files.deleteIfExists(Paths.get("lines.txt"));
            System.out.println("File deleted!");
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        // ===== FILE INFORMATION =====
        
        System.out.println("\n=== FILE INFORMATION ===\n");
        
        File file = new File(filename);
        if (file.exists()) {
            System.out.println("File name: " + file.getName());
            System.out.println("Absolute path: " + file.getAbsolutePath());
            System.out.println("Size: " + file.length() + " bytes");
            System.out.println("Can read: " + file.canRead());
            System.out.println("Can write: " + file.canWrite());
        }
        
        // Cleanup
        try {
            Files.deleteIfExists(Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
 * KEY TAKEAWAYS:
 * - FileWriter/FileReader: Character streams
 * - BufferedReader/BufferedWriter: Buffered I/O (more efficient)
 * - Files class: Modern approach (Java 7+)
 * - Always use try-with-resources for automatic closing
 * - Handle IOException properly
 * 
 * COMMON CLASSES:
 * - FileWriter: Write characters to file
 * - FileReader: Read characters from file
 * - BufferedReader: Efficient reading
 * - BufferedWriter: Efficient writing
 * - Files: Utility class for file operations
 * 
 * COMPILE AND RUN:
 * javac 16_FileIO.java
 * java FileIO
 */
