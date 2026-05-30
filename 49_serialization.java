import java.io.*;

// 49_serialization.java - beginner-friendly example for 49 serialization
public class 49Serialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializablePerson person = new SerializablePerson("Eva", 30); try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.dat"))) { out.writeObject(person); } try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.dat"))) { SerializablePerson copy = (SerializablePerson) in.readObject(); System.out.println(copy.name + " is " + copy.age); }
    }
}

class SerializablePerson implements java.io.Serializable { String name; int age; SerializablePerson(String name, int age) { this.name = name; this.age = age; } }
