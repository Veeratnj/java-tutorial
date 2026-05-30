// 86_sealed_classes.java - beginner-friendly example for 86 sealed classes
public class 86SealedClasses {
    public static void main(String[] args) {
        Shape shape = new Circle(); System.out.println(shape.getClass().getSimpleName());
    }
}

sealed interface Shape permits Circle, Rectangle {}
final class Circle implements Shape {}
final class Rectangle implements Shape {}
