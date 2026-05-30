// 39_polymorphism.java - beginner-friendly example for 39 polymorphism
public class 39Polymorphism {
    public static void main(String[] args) {
        Animal animal = new Dog(); animal.sound();
    }
}

class Animal { void sound() { System.out.println("Animal sound"); } }
class Dog extends Animal { @Override void sound() { System.out.println("Bark"); } }
