import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

// 48_file_handling.java - beginner-friendly example for 48 file handling
public class 48FileHandling {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("example.txt"); Files.writeString(path, "Hello Java
"); String content = Files.readString(path); System.out.println(content);
    }
}
