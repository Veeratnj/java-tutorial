import java.lang.reflect.Method;

// 84_reflection.java - beginner-friendly example for 84 reflection
public class 84Reflection {
    public static void main(String[] args) {
        Class<?> clazz = String.class; Method method = clazz.getMethod("substring", int.class); System.out.println(method.getName());
    }
}
