public class BoxTester {
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>(2); // box of 2
        System.out.println(intBox); // should print box of 2
        Box<String> stringBox = new Box<>("Hi"); // box of hi
        System.out.println(stringBox); // should print box of hi
        Box<String> stringBox2 = new Box<>("Ab"); // box of Ab
        System.out.println(stringBox.compareTo(stringBox2)); // should print 1 as H > A in natural ordering of strings
    }
}
