// 44_access_modifiers.java - beginner-friendly example for 44 access modifiers
public class 44AccessModifiers {
    public static void main(String[] args) {
        Example example = new Example(); System.out.println(example.publicValue);
    }
}

class Example { public int publicValue = 10; private int privateValue = 20; protected int protectedValue = 30; int defaultValue = 40; }
