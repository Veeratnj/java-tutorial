// 42_abstract_classes.java - beginner-friendly example for 42 abstract classes
public class 42AbstractClasses {
    public static void main(String[] args) {
        Vehicle car = new Car(); car.drive();
    }
}

abstract class Vehicle { abstract void drive(); }
class Car extends Vehicle { @Override void drive() { System.out.println("Car driving"); } }
