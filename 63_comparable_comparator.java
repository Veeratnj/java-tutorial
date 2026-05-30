import java.util.*;

// 63_comparable_comparator.java - beginner-friendly example for 63 comparable comparator
public class 63ComparableComparator {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("Ana", 22), new Person("Bob", 20)); Collections.sort(people); people.sort(Comparator.comparing(Person::getName)); System.out.println(people.get(0).getName());
    }
}

class Person implements Comparable<Person> { private String name; private int age; Person(String name, int age) { this.name = name; this.age = age; } public int getAge() { return age; } public String getName() { return name; } @Override public int compareTo(Person other) { return this.age - other.age; } }
