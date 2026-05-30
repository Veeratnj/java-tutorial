import java.util.Scanner;

// 07_input_output.java - beginner-friendly example for 07 input output
public class 07InputOutput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); System.out.print("Enter your name: "); String name = scanner.nextLine(); System.out.println("Hello, " + name); scanner.close();
    }
}
