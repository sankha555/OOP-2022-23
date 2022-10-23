// Remove public in hackerrank submission
public class NumberWithIndex {
    private final int number;
    private final int index;

    public NumberWithIndex(int number, int index) {
        this.number = number;
        this.index = index;
    }

    @Override
    public String toString() {
        return "(" + "number=" + number + ", index=" + index + ")";
    }
}
