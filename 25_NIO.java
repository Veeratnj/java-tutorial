/**
 * 25_NIO.java - Java NIO (New I/O)
 * 
 * Modern file I/O using Path, Files, Channels, and ByteBuffer
 */

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Stream;

public class NIO {
    
    public static void main(String[] args) {
        
        // ===== PATH CLASS =====
        
        System.out.println("=== PATH CLASS ===\n");
        
        Path path1 = Paths.get("test.txt");
        Path path2 = Paths.get("/home/user/documents/file.txt");
        Path path3 = Path.of("data", "files", "sample.txt");
        
        System.out.println("Path 1: " + path1);
        System.out.println("Path 2: " + path2);
        System.out.println("Path 3: " + path3);
        
        System.out.println("File name: " + path2.getFileName());
        System.out.println("Parent: " + path2.getParent());
        System.out.println("Root: " + path2.getRoot());
        
        
        // ===== FILES CLASS - WRITING =====
        
        System.out.println("\n=== WRITING FILES ===\n");
        
        try {
            // Write string to file
            Path file1 = Paths.get("nio_test.txt");
            Files.writeString(file1, "Hello, NIO!\n");
            System.out.println("File written: " + file1);
            
            // Write lines
            List<String> lines = List.of("Line 1", "Line 2", "Line 3");
            Path file2 = Paths.get("nio_lines.txt");
            Files.write(file2, lines);
            System.out.println("Lines written: " + file2);
            
            // Append to file
            Files.writeString(file1, "Appended line\n", StandardOpenOption.APPEND);
            System.out.println("Appended to file");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        // ===== FILES CLASS - READING =====
        
        System.out.println("\n=== READING FILES ===\n");
        
        try {
            // Read entire file as string
            Path file1 = Paths.get("nio_test.txt");
            String content = Files.readString(file1);
            System.out.println("File content:\n" + content);
            
            // Read all lines
            List<String> lines = Files.readAllLines(Paths.get("nio_lines.txt"));
            System.out.println("Lines: " + lines);
            
            // Read with stream (memory efficient)
            System.out.println("Reading with stream:");
            try (Stream<String> stream = Files.lines(file1)) {
                stream.forEach(line -> System.out.println("  " + line));
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        // ===== FILE OPERATIONS =====
        
        System.out.println("\n=== FILE OPERATIONS ===\n");
        
        try {
            Path source = Paths.get("nio_test.txt");
            Path target = Paths.get("nio_copy.txt");
            
            // Copy file
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied");
            
            // Move/Rename file
            Path renamed = Paths.get("nio_renamed.txt");
            Files.move(target, renamed, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File renamed");
            
            // Delete file
            Files.deleteIfExists(renamed);
            System.out.println("File deleted");
            
            // File attributes
            if (Files.exists(source)) {
                System.out.println("Size: " + Files.size(source) + " bytes");
                System.out.println("Is directory: " + Files.isDirectory(source));
                System.out.println("Is regular file: " + Files.isRegularFile(source));
                System.out.println("Is readable: " + Files.isReadable(source));
                System.out.println("Is writable: " + Files.isWritable(source));
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        // ===== DIRECTORY OPERATIONS =====
        
        System.out.println("\n=== DIRECTORY OPERATIONS ===\n");
        
        try {
            // Create directory
            Path dir = Paths.get("test_dir");
            Files.createDirectories(dir);
            System.out.println("Directory created: " + dir);
            
            // List directory contents
            System.out.println("Directory contents:");
            try (Stream<Path> paths = Files.list(dir)) {
                paths.forEach(p -> System.out.println("  " + p.getFileName()));
            }
            
            // Walk directory tree
            System.out.println("Walking directory tree:");
            try (Stream<Path> paths = Files.walk(Paths.get("."))) {
                paths.filter(Files::isRegularFile)
                     .filter(p -> p.toString().endsWith(".txt"))
                     .limit(5)
                     .forEach(p -> System.out.println("  " + p));
            }
            
            // Delete directory
            Files.deleteIfExists(dir);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        // ===== BYTEBUFFER =====
        
        System.out.println("\n=== BYTEBUFFER ===\n");
        
        // Create ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(48);
        
        // Write data
        buffer.put((byte) 10);
        buffer.putInt(100);
        buffer.putDouble(3.14);
        
        System.out.println("Buffer position: " + buffer.position());
        System.out.println("Buffer capacity: " + buffer.capacity());
        
        // Flip for reading
        buffer.flip();
        
        // Read data
        byte b = buffer.get();
        int i = buffer.getInt();
        double d = buffer.getDouble();
        
        System.out.println("Read: byte=" + b + ", int=" + i + ", double=" + d);
        
        // Clear buffer
        buffer.clear();
        
        
        // ===== FILE CHANNEL =====
        
        System.out.println("\n=== FILE CHANNEL ===\n");
        
        try {
            Path file = Paths.get("channel_test.txt");
            
            // Write using channel
            try (FileChannel channel = FileChannel.open(file, 
                    StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
                
                ByteBuffer writeBuffer = ByteBuffer.allocate(48);
                writeBuffer.put("Hello from Channel!".getBytes());
                writeBuffer.flip();
                
                channel.write(writeBuffer);
                System.out.println("Written using channel");
            }
            
            // Read using channel
            try (FileChannel channel = FileChannel.open(file, StandardOpenOption.READ)) {
                ByteBuffer readBuffer = ByteBuffer.allocate(48);
                int bytesRead = channel.read(readBuffer);
                
                readBuffer.flip();
                byte[] data = new byte[bytesRead];
                readBuffer.get(data);
                
                System.out.println("Read: " + new String(data));
            }
            
            // Cleanup
            Files.deleteIfExists(file);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        // Cleanup test files
        try {
            Files.deleteIfExists(Paths.get("nio_test.txt"));
            Files.deleteIfExists(Paths.get("nio_lines.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("\n=== NIO BENEFITS ===\n");
        System.out.println("- Better performance for large files");
        System.out.println("- Non-blocking I/O");
        System.out.println("- Memory-mapped files");
        System.out.println("- Channel-based I/O");
        System.out.println("- Better file system operations");
    }
}

/*
 * KEY TAKEAWAYS:
 * 
 * PATH:
 * - Represents file system path
 * - Paths.get() or Path.of()
 * - getFileName(), getParent(), getRoot()
 * 
 * FILES:
 * - Utility class for file operations
 * - readString(), writeString()
 * - readAllLines(), write()
 * - copy(), move(), delete()
 * - exists(), size(), isDirectory()
 * 
 * BYTEBUFFER:
 * - Container for data
 * - put() to write, get() to read
 * - flip() to switch read/write mode
 * - clear() to reset
 * 
 * FILECHANNEL:
 * - Channel-based I/O
 * - Better performance
 * - read() and write() with ByteBuffer
 * 
 * ADVANTAGES OVER OLD I/O:
 * - Simpler API
 * - Better performance
 * - More features
 * - Stream support
 * 
 * COMPILE AND RUN:
 * javac 25_NIO.java
 * java NIO
 */
