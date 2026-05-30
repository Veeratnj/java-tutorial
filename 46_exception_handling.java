// 46_exception_handling.java - beginner-friendly example for 46 exception handling
public class 46ExceptionHandling {
    public static void main(String[] args) {
        try { int result = 10 / 0; } catch (ArithmeticException e) { System.out.println("Cannot divide by zero"); }
    }
}
