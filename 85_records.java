// 85_records.java - beginner-friendly example for 85 records
public class 85Records {
    public static void main(String[] args) {
        PersonRecord p = new PersonRecord("Ana", 25); System.out.println(p.name() + " is " + p.age());
    }
}

record PersonRecord(String name, int age) {}
