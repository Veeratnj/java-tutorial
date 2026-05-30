// 33_this_keyword.java - beginner-friendly example for 33 this keyword
public class 33ThisKeyword {
    public static void main(String[] args) {
        Person person = new Person("Ana", 22); System.out.println(person.name + " is " + person.age);
    }
}

class Person {
    String name;
    int age;
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
