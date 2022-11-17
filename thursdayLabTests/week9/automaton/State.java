
public class State {
    private final int identifier;
    private final boolean accepts;

    public State(int identifier, boolean isAcceptState) {
        this.identifier = identifier;
        accepts = isAcceptState;
    }

    @Override
    public String toString() {
        return "Q" + identifier;
    }

    public boolean isAcceptState() {
        return accepts;
    }
}
