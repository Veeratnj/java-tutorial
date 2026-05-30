// 31_classes_objects.java - beginner-friendly example for 31 classes objects
public class 31ClassesObjects {
    public static void main(String[] args) {
        Person person = new Person("Ana", 22); System.out.println(person.name + " is " + person.age);
    }
}

class Person {
    String name;
    int age;
    Person(String name, int age) { this.name = name; this.age = age; }
}
