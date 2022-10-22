import java.util.Iterator;

public class LinkedListTester {
    public static void main(String[] args) {
        List<Integer> list = LinkedList.of(1, 2, 3);
        Iterator<Integer> iterator = list.iterator();
        System.out.println("Iterator version: ");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("for each loop condensed version");
        for (int x : list) {
            System.out.println(x);
        }
    }
}
