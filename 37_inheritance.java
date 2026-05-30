// 37_inheritance.java - beginner-friendly example for 37 inheritance
public class 37Inheritance {
    public static void main(String[] args) {
        Animal animal = new Dog(); animal.sound();
    }
}

class Animal { void sound() { System.out.println("Animal sound"); } }
class Dog extends Animal { @Override void sound() { System.out.println("Bark"); } }
