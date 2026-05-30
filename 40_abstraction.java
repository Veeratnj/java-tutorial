// 40_abstraction.java - beginner-friendly example for 40 abstraction
public class 40Abstraction {
    public static void main(String[] args) {
        Shape circle = new Circle(2.5); System.out.println("Area = " + circle.area());
    }
}

abstract class Shape { abstract double area(); }
class Circle extends Shape { double radius; Circle(double radius) { this.radius = radius; } @Override double area() { return Math.PI * radius * radius; } }
