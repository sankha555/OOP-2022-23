// Remove public in hackerrank submission
public class LinkedListTester {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("hey");
        list.addFirst("hello");
        list.addLast("bye");
        System.out.println(list); // should print [hello, hey, bye]
        System.out.println(list.size()); // should print 3
    }
}
