// Remove public in hackerrank submission
public class Box<T extends Comparable<T>> implements Comparable<Box<T>> {
    private final T item;

    public Box(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    /**
     * @param o the object to be compared for equality
     * @return true if this object is equal to o
     */
    @Override
    public boolean equals(Object o) {
        // Question repeated from lab4 assignment
        if (this == o) return true;
        // class check to ensure casting is safe
        if (o == null || getClass() != o.getClass()) return false;
        // question mark means any type because we could be comparing a box of string with a box of integer!
        Box<?> box = (Box<?>) o;
        return item.equals(box.item);
    }

    /**
     * @return A string representation for the Box in the form "Box of item"
     */
    @Override
    public String toString() {
        return "Box of " + item;
    }

    /**
     * @param other the object to be compared.
     * @return 1, -1, 0 if the item this box contains is greater, smaller, or equal to the item in the other box.
     */
    @Override
    public int compareTo(Box<T> other) {
        // Given T extends Comparable T => T is a subtype of Comparable interface and hence has compareTo, 
        // also, question states that box items are comparable
        int c = this.item.compareTo(other.item);
        return Integer.compare(c, 0);
        /*
         * Alternatively: 
         * if (c > 0) return 1;
         * else if (c < 0) return -1;
         * else return 0;
         */
    }

}
