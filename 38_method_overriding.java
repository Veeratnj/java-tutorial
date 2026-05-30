// 38_method_overriding.java - beginner-friendly example for 38 method overriding
public class 38MethodOverriding {
    public static void main(String[] args) {
        Animal dog = new Dog(); dog.sound();
    }
}

class Animal { void sound() { System.out.println("Animal sound"); } }
class Dog extends Animal { @Override void sound() { System.out.println("Bark"); } }
