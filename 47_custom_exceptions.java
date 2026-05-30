// 47_custom_exceptions.java - beginner-friendly example for 47 custom exceptions
public class 47CustomExceptions {
    public static void main(String[] args) {
        try { throw new MyException("Custom error"); } catch (MyException e) { System.out.println(e.getMessage()); }
    }
}

class MyException extends Exception { public MyException(String message) { super(message); } }
