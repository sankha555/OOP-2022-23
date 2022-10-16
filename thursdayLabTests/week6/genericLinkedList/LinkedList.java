// Remove public in hackerrank submission
public class LinkedList<T> implements List<T> {
    private class Node {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private int size;
    private final Node first;

    public LinkedList() {
        this.size = 0;
        this.first = new Node(null, null);
    }

    @SafeVarargs
    public static <T> LinkedList<T> of(T... items) {
        LinkedList<T> toReturn = new LinkedList<>();
        for (int i = items.length - 1; i >= 0; i--) {
            toReturn.addFirst(items[i]);
        }
        return toReturn;
    }

    /**
     * Adds the item to the end of the list
     *
     * @param item the item to be added to the end of the list
     */
    @Override
    public void addLast(T item) {
        Node tracker = first;
        while (tracker.next != null) {
            tracker = tracker.next;
        }
        tracker.next = new Node(item, null);
        ++size;
    }

    /**
     * Adds an item to the front of the list
     *
     * @param item the item to be added to the front of the list
     */
    @Override
    public void addFirst(T item) {
        if (size == 0) {
            addLast(item);
            return;
        }
        Node oldHead = first.next;
        Node newHead = new Node(item, oldHead);
        first.next = newHead;
        ++size;
    }

    /**
     * @return a string representation of this list
     * Examples : list of 1,2 returns [1, 2]
     * : empty list returns [];
     */
    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder stringBuilder = new StringBuilder();
        Node tracker = first.next;
        stringBuilder.append("[");
        while (tracker != null) {
            stringBuilder.append(tracker.item.toString()).append(", ");
            tracker = tracker.next;
        }
        stringBuilder.setLength(stringBuilder.length() - 2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /**
     * @return the first item in the list or null if the list is empty
     */
    public T getFirst() {
        if (size == 0) {
            return null;
        }
        return first.next.item;
    }

    /**
     * @return the item at the end in the list or null if the list is empty
     */
    public T getLast() {
        if (size == 0) {
            return null;
        }
        Node tracker = first.next;
        while (tracker.next != null) {
            tracker = tracker.next;
        }
        return tracker.item;
    }

    /**
     * @return the number of elements in the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @return removes the first node and returns its item
     */
    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node previousHead = first.next;
        first.next = previousHead.next;
        --size;
        return previousHead.item;
    }

    /**
     * @return removes the last node and returns its item
     */
    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node tracker = first;
        for (int i = 0; i < size - 1; i++) {
            tracker = tracker.next;
        }
        T toReturn = tracker.next.item;
        tracker.next = null;
        --size;
        return toReturn;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T remove(int index) {
        return null;
    }
}
