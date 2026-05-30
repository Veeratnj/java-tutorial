// 41_interfaces.java - beginner-friendly example for 41 interfaces
public class 41Interfaces {
    public static void main(String[] args) {
        Printable doc = new Document(); doc.print();
    }
}

interface Printable { void print(); }
class Document implements Printable { @Override public void print() { System.out.println("Printing document"); } }
