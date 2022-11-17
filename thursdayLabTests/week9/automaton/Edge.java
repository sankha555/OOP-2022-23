// Remove public in hackerrank submission
public class Edge {
    private final State from;
    private final State to;
    private final char on;

    public Edge(State from, char on, State to) {
        this.from = from;
        this.to = to;
        this.on = on;
    }

    public State getFrom() {
        return from;
    }

    public State getTo() {
        return to;
    }

    public char getOn() {
        return on;
    }
}
