// 34_static_keyword.java - beginner-friendly example for 34 static keyword
public class 34StaticKeyword {
    public static void main(String[] args) {
        Counter.increment(); System.out.println("Count = " + Counter.count);
    }
}

class Counter {
    static int count = 0;
    static void increment() { count++; }
}
